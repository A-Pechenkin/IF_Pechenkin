package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.PageLoadStrategy;

public class Hooks {
    @Before("@jira")
    public static void before(Scenario scenario) {
        scenario.log("Runs before each scenarios tagged with @jira");
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        Selenide.open("https://edujira.ifellow.ru");
    }

    @After("@jira")
    public static void after() {
        Selenide.closeWebDriver();
    }
}
