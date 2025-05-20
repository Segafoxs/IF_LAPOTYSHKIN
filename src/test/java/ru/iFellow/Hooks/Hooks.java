package ru.iFellow.Hooks;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.iFellow.API.Specifications.Specifications;
import static ru.iFellow.utill.TestProperties.getProperty;

public class Hooks {
    private static String urlAPI;

    @ParameterizedTest
    @ValueSource(strings = { "baseURLRickAndMorty", "baseURLusers" })
    public static void setUrl(String url){
        urlAPI = url;
    }

    @BeforeEach
    public void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(getProperty(urlAPI));
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
