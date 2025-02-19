package steps;

import pages.CreateTaskPage;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.TaskPage;
import io.cucumber.java.ru.*;
import org.junit.Assert;

public class CreateBugSteps {
    private LoginPage loginPage = new LoginPage();
    private ProjectsPage projectsPage = new ProjectsPage();
    private CreateTaskPage createTaskPage = new CreateTaskPage();
    private TaskPage taskPage = new TaskPage();

    @Дано("пользователь авторизуется для создания бага")
    public void userIsLoggedInToCreateBug() {
        loginPage.login("AT11", "Qwerty123");
    }

    @И("пользователь авторизован для создания бага")
    public void userLogInToCreateBug() {
        taskPage.checkLogin();
    }

    @Когда("пользователь нажал на кнопку создания задачи")
    public void userIsOnCreateTaskPage() {
        projectsPage.createNewTaskButton();
    }

    @И("^пользователь создает баг с названием (.*) и типом (.*)")
    public void createBug(String title, String type) {
        createTaskPage.createBug(title, type);
    }

    @Если("пользователь закрывает баг")
    public void closeBug() {
        taskPage.closeBug();
    }

    @Тогда("^статус бага должен быть (.*)")
    public void checkBugStatus(String expectedStatus) {
        String actualStatus = taskPage.getStatus();
        Assert.assertEquals(expectedStatus, actualStatus);
    }
}
