package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserSteps {

    private Response response;

    @Дано("Устанавливаем базовый URI для API")
    public void setBaseUrl() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Когда("Отправляем POST запрос на создание пользователя")
    public void requestCreateUser() {
        String requestBody = "{ \"name\": \"Tomato\", \"job\": \"Eat maket\" }";
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users");
    }

    @Тогда("Получаем ответ с кодом статуса 201")
    public void responseStatusCode() {
        assertThat(response.statusCode(), equalTo(201));
    }

    @И("Ответ должен содержать имя {string}")
    public void responseContainName(String expectedName) {
        assertThat(response.jsonPath().getString("name"), equalTo(expectedName));
        Allure.step("Ответ содержит имя " + expectedName);
    }

    @И("Ответ должен содержать должность {string}")
    public void responseContainJob(String expectedJob) {
        assertThat(response.jsonPath().getString("job"), equalTo(expectedJob));
        Allure.step("Ответ содержит должность " + expectedJob);
    }
}

