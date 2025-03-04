package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка 'Проекты'");
    private final SelenideElement testLink = $x("//a[@id='admin_main_proj_link_lnk']").as("Кнопка 'Test' в меню 'Проекты'");
    private final SelenideElement testProject = $x("//a[@href='/projects/TEST/summary']").as("Проект 'Test'");

    @Step("Проверка успешности авторизации")
    public boolean checkLogin() {
        projectButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return projectButton.isDisplayed();
    }

    @Step("Переход в проект 'Test'")
    public void goToProject() {
        projectButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        testLink.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    @Step("Проверка перехода на страницу проекта 'Test'")
    public boolean checkProjectPage() {
        testProject.shouldBe(Condition.visible);
        return testProject.isDisplayed();
    }
}
