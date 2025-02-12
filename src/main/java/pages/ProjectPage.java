package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
    private final WebDriver driver;

    public ProjectPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By projectLink = By.xpath("//a[@id='browse_link']"); //Кнопка "Проекты"
    private final By testLink = By.xpath("//a[@id='admin_main_proj_link_lnk']"); //Кнопка "Test" в меню "Проекты"
    private final By taskLink = By.xpath("//a[@href='/projects/TEST/issues']"); //Кнопка "Задачи" на странице "Test"
    private final By taskCount = By.xpath("//div[@class='showing']/span"); //Счетчик задач
    private final By createTaskButton = By.xpath("//li[@id='create-menu']"); //Кнопка "Создать новую задачу"

    public void goToProject() {
        driver.findElement(projectLink).click();
        Selenide.sleep(2000);
        driver.findElement(testLink).click();
        Selenide.sleep(2000);
        driver.findElement(taskLink).click();
        Selenide.sleep(2000);
    }

    public int getTaskCount() {
        Selenide.sleep(2000);
        String countText = driver.findElement(taskCount).getText();
        String[] parts = countText.split(" из ");
        int number = Integer.parseInt(parts[1]);
        return number;
    }

    public void createTask() {
        driver.findElement(createTaskButton).click();
    }

}
