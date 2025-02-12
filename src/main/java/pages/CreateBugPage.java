package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CreateBugPage {

    private final WebDriver driver;

    public CreateBugPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By taskTypeField = By.xpath("//input[@id='issuetype-field']"); //Поле "Тип задачи"
    private final By topicField = By.id("summary"); //Поле "Тема"
    private final By createTaskButton = By.id("create-issue-submit"); //Кнопка "Создать"
    private final By descriptionFieldButton = By.xpath("//div[@id='description-wiki-edit']//button[text()='Визуальный']"); //Кнопка "Визуальный" в Описании
    private final By environmentFieldButton = By.xpath("//div[@id='environment-wiki-edit']//button[text()='Визуальный']"); //Кнопка "Визуальный" в Окружении
    private final By taskNumber = By.xpath("//a[contains(@class, 'issue-created-key')]"); //Номер задачи из всплывающего окна при создании

    public void createBug(String type, String topic) {
        driver.findElement(taskTypeField).click();
        Selenide.sleep(2000);
        driver.findElement(taskTypeField).sendKeys(type);
        Selenide.sleep(1000);
        driver.findElement(taskTypeField).sendKeys(Keys.ENTER);
        Selenide.sleep(1000);
        driver.findElement(topicField).sendKeys(topic);
        Selenide.sleep(1000);
        driver.findElement(descriptionFieldButton).click();
        Selenide.sleep(1000);
        driver.findElement(environmentFieldButton).click();
        Selenide.sleep(1000);
        driver.findElement(createTaskButton).click();
        Selenide.sleep(2000);
        driver.findElement(taskNumber).click();
        Selenide.sleep(2000);
    }
}