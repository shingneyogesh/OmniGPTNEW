name: Java CI with Maven and Selenium Test Execution

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build-and-test:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout Repository
      uses: actions/checkout@v4

    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven

    - name: Install Google Chrome
      run: |
        wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
        sudo apt install ./google-chrome-stable_current_amd64.deb

    - name: Install Dependencies
      run: mvn install -DskipTests

    - name: Build with Maven
      run: mvn -B package --file pom.xml

    - name: Run Selenium Tests
      run: mvn test -Dtest=testcases.AllScript -DbaseUrl=http://52.12.150.66/

    - name: Archive Test Reports
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: test-reports
        path: target/surefire-reports/

    - name: Archive Screenshots
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: screenshots
        path: screenshots/
