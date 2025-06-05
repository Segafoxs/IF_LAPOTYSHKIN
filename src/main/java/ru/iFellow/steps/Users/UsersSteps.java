package ru.iFellow.steps.Users;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import ru.iFellow.API.users.UsersAPI;
import ru.iFellow.dto.User.UserCreate;
import ru.iFellow.utill.MapperUtils;
import java.io.IOException;

public class UsersSteps {
    private final UsersAPI users = new UsersAPI();

    @Step("Получение пользователя по id")
    public JsonPath getUserForID(long id){
        return users.getUserForID(id)
                .extract()
                .body()
                .jsonPath();
    }

    @Step("Создание нового пользователя name:{name} job:{job}")
    public Response createUserField(String name, String job) throws IOException {
        return users.addUser(MapperUtils.readFromFile("src/test/resources/user.json", UserCreate.class, name, job))
                .extract()
                .response();
    }
}



