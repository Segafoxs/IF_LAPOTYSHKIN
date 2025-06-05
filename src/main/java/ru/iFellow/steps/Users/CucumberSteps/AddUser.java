package ru.iFellow.steps.Users.CucumberSteps;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.steps.Users.UsersSteps;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddUser {
    private final UsersSteps users = new UsersSteps();
    private Response response;

    @Когда("^создаем нового пользователя, меняем name '(.*)'  и добавляем поле job:'(.*)'")
    public void createUser(String name, String job) throws IOException {
        response = users.createUserField(name, job);
    }

    @Тогда("^проверяем статус код '(.*)'")
    public void checkStatuseCode(int code){
        Assertions.assertEquals(code, response.statusCode());
    }

    @И("^проверяем имя '(.*)'")
    public void checkName(String name){
        response.then().body("name", equalTo(name));
    }

    @И("^проверяем job '(.*)'")
    public void checkJob(String job) {
        response.then().body("job", equalTo(job));
    }

}
