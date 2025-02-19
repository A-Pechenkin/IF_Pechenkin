package steps;

import pages.*;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class CheckTaskCountSteps {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private ProjectsPage projectsPage = new ProjectsPage();
    private CreateTaskPage createTaskPage = new CreateTaskPage();
    private TaskPage taskPage = new TaskPage();

    private int initialTaskCount;
    private int updatedTaskCount;

    @Дано("пользователь авторизуется для проверки счетчика")
    public void userIsLoggedInToCheckCount() {
        loginPage.login("AT11", "Qwerty123");
    }

    @И("пользователь авторизован для проверки счетчика")
    public void userLogInToCheckCount() {
        taskPage.checkLogin();
    }

    @Дано("пользователь переходит к проекту")
    public void goToProject() {
        mainPage.clickToProject();
        mainPage.clickToTest();
        initialTaskCount = projectsPage.getTaskCount();
    }

    @Когда("^пользователь создает новую задачу с названием (.*)")
    public void createNewTask(String taskName) {
        projectsPage.createNewTaskButton();
        createTaskPage.createTask(taskName);
        updatedTaskCount = projectsPage.getTaskCount();
    }

    @Тогда("счетчик задач должен увеличиться на 1")
    public void checkTaskCount() {
        Assert.assertEquals(initialTaskCount + 1, updatedTaskCount);
    }
}
