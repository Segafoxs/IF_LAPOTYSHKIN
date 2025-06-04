package ru.iFellow.API.rickAndMorty;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import ru.iFellow.TestProperties;
import static io.restassured.RestAssured.given;

public class RickAndMortyAPI {
    public ValidatableResponse getCharacterForName(String name){
        return given()
                .when()
                .get(TestProperties.getProperty("searchURLrickANDmorty") +"?name=" + name)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse getItemForURL(String url){
        return given()
                .when()
                .get(url)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
