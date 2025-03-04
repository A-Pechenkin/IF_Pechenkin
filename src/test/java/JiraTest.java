import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Тестирование Jira")
public class JiraTest extends WebHooks {

    String username = "AT11";
    String password = "Qwerty123";

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ProjectsPage projectsPage = new ProjectsPage();
    CreateTaskPage createTaskPage = new CreateTaskPage();
    TaskPage taskPage = new TaskPage();

    @Test
    @Order(1)
    @DisplayName("Авторизация пользователя")
    @Description("Проверяет успешность авторизации пользователя")
    public void testLogin() {
        loginPage.login(username, password);
        Assertions.assertTrue(mainPage.checkLogin());
    }

    @Test
    @Order(2)
    @DisplayName("Переход в проект Test")
    @Description("Проверяет успешность перехода в проект Test")
    public void testGoToProject() {
        loginPage.login(username, password);
        mainPage.goToProject();
        Assertions.assertTrue(mainPage.checkProjectPage());
    }

    @Test
    @Order(3)
    @DisplayName("Проверка счетчика задач")
    @Description("Проверяет увеличение счетчика задач после создания новой задачи")
    public void testCheckTaskCount() {
        loginPage.login(username, password);
        mainPage.goToProject();
        int initialTaskCount = projectsPage.getTaskCount();
        projectsPage.createNewTaskButton();
        createTaskPage.createTask("Проверка счётчика");
        int updatedTaskCount = projectsPage.getTaskCount();
        Assertions.assertEquals(initialTaskCount + 1, updatedTaskCount);
    }

    @Test
    @Order(4)
    @DisplayName("Проверка информации в задаче TestSeleniumATHomework")
    @Description("Проверяет статус и версию задачи TestSeleniumATHomework")
    public void testCheckTask() {
        loginPage.login(username, password);
        taskPage.checkLogin();
        taskPage.searchTask("TestSeleniumATHomework");
        String status = taskPage.getStatus();
        String version = taskPage.getVersion();
        Assertions.assertEquals("СДЕЛАТЬ", status);
        Assertions.assertEquals("Version 2.0", version);
    }

    @Test
    @Order(5)
    @DisplayName("Создание бага")
    @Description("Проверяет создание бага и его статус")
    public void testCreateBug() {
        loginPage.login(username, password);
        projectsPage.createNewTaskButton();
        createTaskPage.createBug("Ошибка", "Баг");
        taskPage.closeBug();
        String status = taskPage.getStatus();
        Assertions.assertEquals("ГОТОВО", status);
    }

}
