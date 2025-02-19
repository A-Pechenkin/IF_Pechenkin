package steps;

import pages.LoginPage;
import pages.TaskPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class CheckTaskInfoSteps {

    private LoginPage loginPage = new LoginPage();
    private TaskPage taskPage = new TaskPage();

    @Дано("пользователь авторизуется для просмотра информации о задаче")
    public void userIsLoggedInToCheckTask() {
        loginPage.login("AT11", "Qwerty123");
    }

    @И("пользователь авторизован для просмотра информации о задаче")
    public void userLogInToCheckTask() {
        taskPage.checkLogin();
    }

    @Когда("^пользователь ищет задачу (.*)")
    public void searchTask(String taskName) {
        taskPage.searchTask(taskName);
    }

    @Тогда("^статус задачи должен быть (.*)")
    public void checkTaskStatus(String expectedStatus) {
        String actualStatus = taskPage.getStatus();
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @И("^версия задачи должна быть (.*)")
    public void checkTaskVersion(String expectedVersion) {
        String actualVersion = taskPage.getVersion();
        Assert.assertEquals(expectedVersion, actualVersion);
    }
}
