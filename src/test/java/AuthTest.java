import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.JiraLoginPage;


public class AuthTest extends WebHooks {

    private static JiraLoginPage loginPage;

    @Test
    @DisplayName("Авторизация")
    public void testLogin() {
        loginPage = new JiraLoginPage(driver);
        loginPage.login("AT11", "Qwerty123");
        Selenide.sleep(2000);

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='dashboard-item-header']//h3[text()='Назначенные мне']")).isDisplayed());
    }
}
