package ru.iFellow.API.Specifications;
import io.restassured.RestAssured;
import ru.iFellow.TestProperties;

public class SetBaseUrlAPI {
    public static void SetUp(String urlAPI) {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(TestProperties.getProperty(urlAPI));
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
