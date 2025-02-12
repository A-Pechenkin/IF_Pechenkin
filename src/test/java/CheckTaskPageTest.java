import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TaskPage;

public class CheckTaskPageTest extends CheckCountTaskTest {

    @Test
    @DisplayName("Проверка информации в задаче TestSeleniumATHomework")
    public void testCheckTask() {
        TaskPage taskPage = new TaskPage(WebHooks.driver);
        taskPage.searchTask("TestSeleniumATHomework");
        Selenide.sleep(3000);
        String status = taskPage.getStatus();
        String version = taskPage.getVersion();
        Selenide.sleep(2000);

        Assertions.assertEquals("СДЕЛАТЬ", status);
        Assertions.assertEquals("Version 2.0", version);
    }
}
