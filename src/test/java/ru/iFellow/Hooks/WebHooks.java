package ru.iFellow.Hooks;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.Configuration;

public class WebHooks {

    @Before("@ifellow")
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 10000;
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After("@ifellow")
    public void AfterTest(){
        Selenide.closeWebDriver();
    }
}
