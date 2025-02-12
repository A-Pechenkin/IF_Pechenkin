package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTaskPage {

    private WebDriver driver;

    public CreateTaskPage(WebDriver driver) {
        this.driver = driver;
    }

    private By topicField = By.id("summary"); //Поле "Тема"
    private By createTaskButton = By.id("create-issue-submit"); //Кнопка "Создать"

    public void taskForm(String topic) {
        Selenide.sleep(2000);
        driver.findElement(topicField).sendKeys(topic);
        Selenide.sleep(1000);
        driver.findElement(createTaskButton).click();
        Selenide.sleep(1000);
        driver.navigate().refresh();
    }
}
