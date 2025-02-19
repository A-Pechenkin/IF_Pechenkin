package steps;

import pages.LoginPage;
import pages.MainPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();


    @Когда("^ввели логин (.*) и пароль (.*) на главной странице")
    public void inputLoginAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @И("нажали кнопку 'Вход'")
    public void pressButton() {
        loginPage.pressLoginButton();
    }

    @Тогда("произведен вход на сайт")
    public void checkLog() {
        mainPage.checkLogin();
    }
}
