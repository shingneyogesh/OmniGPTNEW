import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Finish {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(5000); 

            WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
            usernameField.sendKeys("standard_user");
            
            Thread.sleep(5000);

            WebElement passwordField = driver.findElement(By.cssSelector("#password"));
            passwordField.sendKeys("secret_sauce");
            
            Thread.sleep(5000);

            WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
            loginButton.click();
            Thread.sleep(5000); 

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

            Thread.sleep(5000); 

            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")));
            addToCartButton.click();
            Thread.sleep(5000); 

            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart_link")));
            cartIcon.click();
            Thread.sleep(5000); 

            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_action.checkout_button")));
            checkoutButton.click();
            Thread.sleep(5000); 

            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
            firstNameField.sendKeys("Yogesh");
            
            Thread.sleep(5000);

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
            lastNameField.sendKeys("Shingne");
            
            Thread.sleep(5000);

            WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
            postalCodeField.sendKeys("431203");
            
            Thread.sleep(5000);

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_primary.cart_button")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);
            Thread.sleep(5000); 

            continueButton.click();

            Thread.sleep(5000); 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}
