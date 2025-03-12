import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @BeforeEach
    @Step("Открытие браузера и переход на страницу Jira")
    public void openBrowser() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}
