package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка 'Проекты'");
    private final SelenideElement testLink = $x("//a[@id='admin_main_proj_link_lnk']").as("Кнопка 'Test' в меню 'Проекты'");
    private final SelenideElement testProject = $x("//a[@href='/projects/TEST/summary']").as("Проект 'Test'");

    public boolean checkLogin() {
        projectButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return projectButton.isDisplayed();
    }

    public void clickToProject() {
        projectButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void clickToTest() {
        testLink.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public boolean checkProjectPage() {
        testProject.shouldBe(Condition.visible);
        return testProject.isDisplayed();
    }
}
