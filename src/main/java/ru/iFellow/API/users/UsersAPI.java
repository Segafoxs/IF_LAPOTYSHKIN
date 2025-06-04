package ru.iFellow.API.users;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import ru.iFellow.models.User.UserCreate;
import ru.iFellow.TestProperties;

import static io.restassured.RestAssured.given;

public class UsersAPI {

    public ValidatableResponse getUserForID(long id){
        return given().header(TestProperties.getProperty("typeApiKey"), TestProperties.getProperty("apiKey"))
                .when()
                .get(TestProperties.getProperty("searchURLusers") + "/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse addUser(UserCreate user){
        return given().header(TestProperties.getProperty("typeApiKey"), TestProperties.getProperty("apiKey"))
                .when().body(user)
                .post(TestProperties.getProperty("searchURLusers"))
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
