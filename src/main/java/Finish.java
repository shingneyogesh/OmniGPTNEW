import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Finish {
    public static void main(String[] args) {

        // Setup WebDriver automatically using WebDriverManager
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.saucedemo.com/");
            
            // Login process
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
            usernameField.sendKeys("standard_user");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
            passwordField.sendKeys("secret_sauce");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button")));
            loginButton.click();

            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

            // Add product to cart
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")));
            addToCartButton.click();

            // Go to cart
            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart_link")));
            cartIcon.click();

            // Proceed to checkout
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_action.checkout_button")));
            checkoutButton.click();

            // Fill in personal information
            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
            firstNameField.sendKeys("Yogesh");

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
            lastNameField.sendKeys("Shingne");

            WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
            postalCodeField.sendKeys("431203");

            // Continue to review page
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_primary.cart_button")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);
            continueButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
