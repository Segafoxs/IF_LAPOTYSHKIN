package ru.iFellow;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;


public class WebHooks {


    private WebDriver driver;

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;

        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa"
        );
        System.out.println(Configuration.pageLoadStrategy);
        System.out.println("!!!!!");

    }



    @AfterEach
    public void AfterTest(){
        Selenide.closeWebDriver();
    }
}
