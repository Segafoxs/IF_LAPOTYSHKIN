package ru.iFellow.API.rickAndMorty;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class RickAndMortyAPI {

    private final String searchURL = "/character/";

    public ValidatableResponse getCharacterForName(String name){
        return given()
                .when()
                .get(searchURL+"?name=" + name)
                .then()
                .statusCode(200);
    }

    public ValidatableResponse getItemForURL(String url){
        return given()
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }
}
