import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CreateBugPage;
import pages.ProjectPage;
import pages.TaskPage;


public class CreateBugTest extends CheckTaskPageTest {

    @Test
    @DisplayName("Создание бага")
    public void testCreateBug() {
        ProjectPage projectPage = new ProjectPage(WebHooks.driver);
        projectPage.createTask();

        Selenide.sleep(2000);

        CreateBugPage createTaskPage = new CreateBugPage(WebHooks.driver);
        createTaskPage.createBug("Ошибка","Баг");

        TaskPage taskPage = new TaskPage(WebHooks.driver);
        taskPage.closeBug();
        String status = taskPage.getStatus();

        Assertions.assertEquals("ГОТОВО", status);
    }
}
