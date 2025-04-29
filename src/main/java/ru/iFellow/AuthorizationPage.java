package ru.iFellow;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;


public class AuthorizationPage {

    private final SelenideElement loginField = $x("//form[@id='loginform']" +
            "/div[@class='field-group']/input[@id='login-form-username']").as("Ввод логина");

    private final SelenideElement passwordField = $x("//form[@id='loginform']/" +
            "div[@class='field-group']/input[@id='login-form-password']").as("Ввод пароля");

    private final SelenideElement submitButton = $x("//form[@id='loginform']" +
            "/div[@class='buttons-container']//input[@id='login']").as("Кнопка отправки");

    private final String nextPage = "https://edujira.ifellow.ru/secure/Dashboard.jspa";


    public SelenideElement checkLogin(String login){
        return loginField.shouldHave(text(login));
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {

        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        submitButton.click();

    }
}
