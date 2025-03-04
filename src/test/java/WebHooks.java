import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @BeforeEach
    @Step("Открытие браузера и переход на страницу Jira")
    public void openBrowser() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}
