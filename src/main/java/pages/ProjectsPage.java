package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsPage {

    private final SelenideElement taskLink = $x("//a[@href='/projects/TEST/issues']").as("Кнопка 'Задачи' на странице 'Test'");
    private final SelenideElement taskCount = $x("//div[@class='showing']/span").as("Счетчик задач");
    private final SelenideElement createNewTaskButton = $x("//li[@id='create-menu']").as("Кнопка 'Создать новую задачу'");

    @Step("Получение количества задач")
    public int getTaskCount() {
        taskLink.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        String countText = taskCount.getText();
        String[] parts = countText.split(" из ");
        int number = Integer.parseInt(parts[1]);
        return number;
    }

    @Step("Нажатие кнопки 'Создать новую задачу'")
    public void createNewTaskButton() {
        createNewTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

}
