package ru.iFellow.steps.AuthStep;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.Pages.AuthPage.AuthorizationPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationStep {
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final String checkTextH3 = "Назначенные мне";

    @Когда("ввели данные {string} {string}")
    public void enterLog(String login, String password){
        authorizationPage.enterAuthLogin(login, password);
    }

    @Тогда("увидели заголовок")
    public void checkH(){
        authorizationPage.getTextH3();
        assertEquals(checkTextH3, authorizationPage.getTextH3(), "Авторизация не пройдена");
    }
}
