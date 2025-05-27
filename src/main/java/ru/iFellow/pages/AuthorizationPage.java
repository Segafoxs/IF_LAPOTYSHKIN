package ru.iFellow.pages;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.model.Parameter.Mode.MASKED;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import java.time.Duration;

public class AuthorizationPage {
    private final SelenideElement loginField = $x("//form[@id='loginform']" +
            "/div[@class='field-group']/input[@id='login-form-username']").as("Ввод логина");
    private final SelenideElement passwordField = $x("//form[@id='loginform']/" +
            "div[@class='field-group']/input[@id='login-form-password']").as("Ввод пароля");
    private final SelenideElement submitButton = $x("//form[@id='loginform']" +
            "/div[@class='buttons-container']//input[@id='login']").as("Кнопка отправки");
    private final SelenideElement h3jira = $x("//div[@id='gadget-10002-chrome']//h3[contains(text(), 'Назначенные мне')]");

    @Step("Авторизоваться на сайте с данными {login} *****")
    public void enterAuthLogin(String login, @Param(mode=MASKED)String password){
        inputLogin(login);
        inputPassword(password);
        clickLoginBtn();
    }

    @Step("Проверяем наличие заголовка НАЗНАЧЕННЫЕ МНЕ")
    public String getTextH3(){
        return h3jira.getText();
    }

    private void inputLogin(String login) {
        loginField.shouldBe(Condition.visible, Duration.ofSeconds(8));
        loginField.sendKeys(login);
    }

    private void inputPassword(String password) {
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(8));
        passwordField.sendKeys(password);
    }

    private void clickLoginBtn(){
        submitButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
        submitButton.click();
    }
}
