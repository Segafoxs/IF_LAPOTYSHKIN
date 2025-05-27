package ru.iFellow;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.Configuration;
import ru.iFellow.utill.TestProperties;
import io.qameta.allure.selenide.AllureSelenide;

public class WebHooks {
    private final String baseURL = TestProperties.getProperty("baseURL");
    private static final Boolean addScrin = Boolean.valueOf(TestProperties.getProperty("addScreenshot"));
    private static final Boolean savePageSrc = Boolean.valueOf(TestProperties.getProperty("savePageSource"));

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 10000;
        Selenide.open(baseURL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void AfterTest() {
        Selenide.closeWebDriver();
    }

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(addScrin)
                .savePageSource(savePageSrc));
    }
}

