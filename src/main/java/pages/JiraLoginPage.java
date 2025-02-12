package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class JiraLoginPage {

    private final WebDriver driver;

    public JiraLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameField = By.id("login-form-username");
    private final By passwordField = By.id("login-form-password");
    private final By loginButton = By.id("login");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
