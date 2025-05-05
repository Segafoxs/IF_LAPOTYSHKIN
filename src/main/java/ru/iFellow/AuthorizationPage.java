package ru.iFellow;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class AuthorizationPage {
    private final SelenideElement loginField = $x("//form[@id='loginform']" +
            "/div[@class='field-group']/input[@id='login-form-username']").as("Ввод логина");
    private final SelenideElement passwordField = $x("//form[@id='loginform']/" +
            "div[@class='field-group']/input[@id='login-form-password']").as("Ввод пароля");
    private final SelenideElement submitButton = $x("//form[@id='loginform']" +
            "/div[@class='buttons-container']//input[@id='login']").as("Кнопка отправки");
    private final SelenideElement h3jira = $x("//div[@id='gadget-10002-chrome']//h3[contains(text(), 'Назначенные мне')]");

    public void enterAuthLogin(String login, String password){
        inputLogin(login);
        inputPassword(password);
        clickLoginBtn();
    }

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
