import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CreateTaskPage;
import pages.ProjectPage;


public class CheckCountTaskTest extends GoToProjectTest {

    @Test
    @DisplayName("Проверка счетчика задач")
    public void testCheckTaskCount() {
        ProjectPage projectPage = new ProjectPage(WebHooks.driver);
        int initialTaskCount = projectPage.getTaskCount();

        projectPage.createTask();

        Selenide.sleep(1000);

        CreateTaskPage createTaskPage = new CreateTaskPage(WebHooks.driver);
        createTaskPage.taskForm("Проверка счётчика");

        Selenide.sleep(1000);
        int updatedTaskCount = projectPage.getTaskCount();
        Selenide.sleep(2000);

        Assertions.assertEquals(initialTaskCount + 1, updatedTaskCount);
    }
}
