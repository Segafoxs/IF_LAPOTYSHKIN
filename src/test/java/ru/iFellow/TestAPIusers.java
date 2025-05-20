package ru.iFellow;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.API.Specifications.Specifications;
import ru.iFellow.models.User.UserResponse;
import ru.iFellow.steps.UsersSteps;
import java.io.IOException;
import static ru.iFellow.utill.TestProperties.getProperty;

public class TestAPIusers {
    private final UsersSteps users = new UsersSteps();

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(getProperty("baseURLusers"));
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }

    @Test
    @DisplayName("Поиск пользователя по id")
    public void searchUserForID() {
        int id = 2;
        JsonPath body = users.getUserForID(id);
        Assertions.assertEquals("Janet", body.get("data.first_name"));
        Assertions.assertEquals(id, (Integer) body.get("data.id"));
    }

    @Test
    @DisplayName("Добавление пользователя")
    public void createUsers() throws IOException {
        UserResponse us = users.createUserField("Tomato", "Eat maket");
        Assertions.assertEquals("Tomato", us.name);
        Assertions.assertEquals("Eat maket", us.job);
    }
}
