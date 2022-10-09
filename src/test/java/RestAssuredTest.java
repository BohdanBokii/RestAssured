import data.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import specRest.SpecificationsRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredTest {
    static final String URL="http://localhost:8080/";
    @BeforeClass
    public static void init() {
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setReqSpec(URL), SpecificationsRest.setResponceSpec200());
    }
    @Test
    @DisplayName("System test")
    @Description("Allure work check test")
    public void userTest() {
        User user = given()
                .when()
                .get( "users/7865942")
                .then().log().all()
                .extract().as(User.class);
        System.out.println(user.username);
    }

    @Test
    @DisplayName("Logs")
    @Description("Take a browser logs")
    public void getConnectionLogs() {
        String str = given()
                .when()
                .get( "users")
                .then().log().all()
                .extract().body().jsonPath().get().toString();
        System.out.println("Json Body " + str);
    }
    @Test
    @DisplayName("Not null email")
    @Description(" Check the email field is not empty")
    public void IsNotNullEmailField() {
        given()
                .when()
                .get( "users")
                .then().log().all()
                .body("email", notNullValue());
    }
    @Test
    @DisplayName("User of username")
    @Description("Find user of the username")
    public void getUserToUsername() {
         given()
                .when()
                .get( "users/findByUsername/Amy")
                .then().log().all();
    }
}
