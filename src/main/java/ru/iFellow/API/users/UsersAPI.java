package ru.iFellow.API.users;
import io.restassured.response.ValidatableResponse;
import ru.iFellow.models.User.UserCreate;
import static io.restassured.RestAssured.given;

public class UsersAPI {
    private final String searchURL = "/api/users";

    public ValidatableResponse getUserForID(long id){
        return given().header("x-api-key", "reqres-free-v1")
                .when()
                .get(searchURL + "/" + id)
                .then()
                .statusCode(200);
    }

    public ValidatableResponse addUser(UserCreate user){
        return given().header("x-api-key", "reqres-free-v1")
                .when().body(user)
                .post(searchURL)
                .then()
                .statusCode(201);
    }
}
