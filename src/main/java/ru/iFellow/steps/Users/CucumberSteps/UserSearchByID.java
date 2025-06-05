package ru.iFellow.steps.Users.CucumberSteps;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.steps.Users.UsersSteps;

public class UserSearchByID {
    private JsonPath result;
    private final UsersSteps usersSteps = new UsersSteps();

    @Когда("^находим пользователя по id '(.*)'")
    public JsonPath enterId(int id){
        result = usersSteps.getUserForID(id);
        return result;
    }

    @Тогда("^проверяем, что пользователь имеет id '(.*)'")
    public void checkUserID(int id){
        Assertions.assertEquals(id, (Integer) result.get("data.id"));
    }
}
