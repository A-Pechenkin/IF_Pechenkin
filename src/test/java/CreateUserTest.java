import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    @Test
    public void testCreateUser() {

        RestAssured.baseURI = "https://reqres.in/api";

        File jsonFile = new File("src/test/resources/user.json");

        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Tomato\", \"job\": \"Eat maket\"}")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Tomato"))
                .body("job", equalTo("Eat maket"))
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }
}
