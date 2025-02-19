package steps;

import pages.LoginPage;
import pages.MainPage;
import pages.TaskPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;


public class MainPageSteps {

    private LoginPage loginPage = new LoginPage();
    private TaskPage taskPage = new TaskPage();
    private MainPage mainPage = new MainPage();


    @Дано("пользователь авторизуется для перехода в проект")
    public void userIsLoggedInToProject() {
        loginPage.login("AT11", "Qwerty123");
    }

    @И("пользователь авторизован для перехода в проект")
    public void userLogInToProject() {
        taskPage.checkLogin();
    }

    @Когда("выбрали в верхнем меню кнопку 'Проекты'")
    public void selectProjectButton() {
        mainPage.clickToProject();
    }

    @И("выбрали в выпавшем окне кнопку 'Test'")
    public void selectTestButton() {
        mainPage.clickToTest();
    }

    @Тогда("пользователь переходит в проект 'Test'")
    public void checkProjectPage() {
        mainPage.checkProjectPage();
    }

}
