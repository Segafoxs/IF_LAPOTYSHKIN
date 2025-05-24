package ru.iFellow;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.Hooks.Hooks;
import ru.iFellow.models.User.UserResponse;
import ru.iFellow.steps.UsersSteps;
import java.io.IOException;

public class TestAPIusers extends Hooks {
    private final UsersSteps users = new UsersSteps();

    public TestAPIusers() {
        Hooks.setUrl("baseURLusers");
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
