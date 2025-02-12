import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProjectPage;

public class GoToProjectTest extends AuthTest {

    @Test
    @DisplayName("Переход в проект Test")
    public void testGoToProject() {
        ProjectPage projectPage = new ProjectPage(WebHooks.driver);
        projectPage.goToProject();

        Assertions.assertTrue(driver.getCurrentUrl().contains("projects/TEST"));
    }
}