package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']").as("Поле 'Имя пользователя'");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Поле 'Пароль'");
    private final SelenideElement loginButton = $x("//input[@id='login']").as("Кнопка 'Войти'");

    public void login(String username, String password) {
       setFieldLogin(username, password);
       pressLoginButton();
    }

    public void setFieldLogin(String username, String password){
        usernameField.shouldBe(Condition.exist, Duration.ofSeconds(10));
        usernameField.setValue(username);
        passwordField.shouldBe(Condition.exist, Duration.ofSeconds(10));
        passwordField.setValue(password);
    }

    public void pressLoginButton(){
        loginButton.shouldBe(Condition.clickable, Duration.ofSeconds(10)).click();
    }
}
