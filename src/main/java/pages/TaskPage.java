package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TaskPage {

    private final WebDriver driver;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By taskLink = By.id("quickSearchInput"); //Поле "Поиск"
    private final By status = By.xpath("//span[@id='status-val']//span"); //Поле "Статус"
    private final By version = By.xpath("//span[@id='fixfor-val']//a"); //Поле "Исправить в версиях"
    private final By statusInProgress = By.xpath("//a[@id='action_id_21']//span[text()='В работе']"); //Кнопка "В работе"
    private final By statusBusProc = By.xpath("//a[@id='opsbar-transitions_more']"); //Кнопка "Бизнес-процесс"
    private final By statusResolved = By.xpath("//*[@id='action_id_31']"); //Кнопка "Выполнено"

    public void searchTask(String task)
    {
        driver.findElement(taskLink).sendKeys(task);
        driver.findElement(taskLink).sendKeys(Keys.ENTER);
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

    public String getVersion() {
        return driver.findElement(version).getText();
    }

    public void closeBug()
    {
        driver.findElement(statusInProgress).click();
        Selenide.sleep(2000);
        driver.findElement(statusBusProc).click();
        Selenide.sleep(2000);
        driver.findElement(statusResolved).click();
        Selenide.sleep(2000);
    }
}