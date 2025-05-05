package ru.iFellow;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.Configuration;

public class WebHooks {

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 10000;

        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa"
        );
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @AfterEach
    public void AfterTest(){
        Selenide.closeWebDriver();
    }
}
