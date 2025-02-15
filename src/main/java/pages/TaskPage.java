package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class TaskPage {

    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка 'Проекты'");
    private final SelenideElement taskLink = $x("//input[@id='quickSearchInput']").as("Поле 'Поиск'");
    private final SelenideElement status = $x("//span[@id='status-val']//span").as("Поле 'Статус'");
    private final SelenideElement version = $x("//span[@id='fixfor-val']//a").as("Поле 'Исправить в версиях'");
    private final SelenideElement statusInProgress = $x("//a[@id='action_id_21']//span[text()='В работе']").as("Кнопка'В работе'");
    private final SelenideElement statusBusProc = $x("//a[@id='opsbar-transitions_more']").as("Кнопка 'Бизнес-процесс'");
    private final SelenideElement statusResolved = $x("//*[@id='action_id_31']").as("Кнопка 'Выполнено'");

    public void checkLogin()
    {
        projectButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void searchTask(String task)
    {
        taskLink.shouldBe(Condition.visible, Duration.ofSeconds(20)).setValue(task);
        taskLink.shouldBe(Condition.visible, Duration.ofSeconds(20)).sendKeys(Keys.ENTER);
    }

    public String getStatus() {
        return status.getText();
    }

    public String getVersion() {
        return version.getText();
    }

    public void closeBug()
    {
        statusInProgress.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        sleep(1000);
        statusBusProc.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        sleep(1000);
        statusResolved.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        sleep(1000);
    }
}