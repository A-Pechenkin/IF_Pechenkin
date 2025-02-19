package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CreateTaskPage {

    private final SelenideElement taskTypeField = $x("//input[@id='issuetype-field']").as("Поле 'Тип задачи'");
    private final SelenideElement topicField = $x("//input[@id='summary']").as("Поле 'Тема'"); //
    private final SelenideElement createTaskButton = $x("//input[@id='create-issue-submit']").as("Кнопка 'Создать'");
    private final SelenideElement descriptionFieldButton = $x("//div[@id='description-wiki-edit']//button[text()='Визуальный']").as("//Кнопка 'Визуальный' в Описании");
    private final SelenideElement environmentFieldButton = $x("//div[@id='environment-wiki-edit']//button[text()='Визуальный']").as("//Кнопка 'Визуальный' в Окружении");
    private final SelenideElement taskNumber = $x("//a[contains(@class, 'issue-created-key')]").as("//Номер задачи из всплывающего окна");

    public void createTask(String topic) {
        topicField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(topic);
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        Selenide.refresh();
    }

    public void createBug(String type, String topic) {
        taskTypeField.shouldBe(Condition.clickable, Duration.ofSeconds(10)).click();
        taskTypeField.shouldBe(Condition.clickable, Duration.ofSeconds(30)).sendKeys(type);
        topicField.setValue(topic);
        descriptionFieldButton.shouldBe(Condition.enabled, Duration.ofSeconds(30)).click();
        environmentFieldButton.shouldBe(Condition.enabled, Duration.ofSeconds(30)).click();
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        taskNumber.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}