package ru.iFellow.steps;
import io.restassured.path.json.JsonPath;
import ru.iFellow.API.users.UsersAPI;
import ru.iFellow.models.User.UserCreate;
import ru.iFellow.models.User.UserResponse;
import ru.iFellow.utill.MapperUtils;
import java.io.IOException;

public class UsersSteps {
    private final UsersAPI users = new UsersAPI();
    public JsonPath getUserForID(long id){
        return users.getUserForID(id)
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
    }

    public UserResponse createUserField(String name, String job) throws IOException {
        return users.addUser(MapperUtils.readFromFile("src/test/resources/user.json", UserCreate.class, name, job))
                .statusCode(201)
                .extract()
                .body()
                .as(UserResponse.class);
    }
}



