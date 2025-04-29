package ru.iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CreateNewBug {
    private final SelenideElement createButton = $x("//header[@id='header']//nav[contains(@class, 'aui-header')]" +
            "//div[@class='aui-header-primary']/ul[@class='aui-nav']//li[@id='create-menu']//a");

    private final SelenideElement buttonVisual = $x("//form[@name='jiraform']/div/div[@class='content']/div[@class='field-group']//div[@id='description-wiki-edit']" +
            "//ul[@class='aui-nav']//button[contains(text(),'Визуальный')]");

    private final SelenideElement inputTopicBug = $x("//div[@class='qf-container']//form[@name='jiraform']" +
            "//div[@class='content']//input[@id='summary']");

    private final SelenideElement descriptionFieldIframe = $x("//div[@id='description-wiki-edit']" +
            "//div[@class='rte-container']//iframe[@id='mce_0_ifr']");

    private final SelenideElement inputVersion = $x("//form[@name='jiraform']//select[@id='fixVersions']//option[contains(text(), 'Version 2.0')]");

    private final SelenideElement textAriaBug = $x("//form[@name='jiraform']//div[@class='content']" +
            "//div[@id='labels-multi-select']//textarea");

    private final SelenideElement envFieldIframe = $x("//form[@name='jiraform']//div[@class='content']" +
            "//div[@id='environment-wiki-edit']//div[@class='rte-container']//iframe");

    private final SelenideElement choiceVersion = $x("//form[@name='jiraform']//div[@class='content']//" +
            "select[@id='versions']//option[contains(text(), 'Version 2.0')]");
    private SelenideElement connectTask = $x("//form[@name='jiraform']//div[@class='content']" +
            "//textarea[@id='issuelinks-issues-textarea']");

    private SelenideElement linkApic = $x("//form[@name='jiraform']//div[@class='content']//input[@id='customfield_10100-field']");

    private SelenideElement sprint = $x("//form[@name='jiraform']//div[@class='content']//input[@id='customfield_10104-field']");

    private SelenideElement listPrioretyBug = $x("//form[@name='jiraform']//div[@class='content']" +
            "//select[@name='customfield_10400']");
    private SelenideElement prioretyBug = $x("//form[@name='jiraform']//div[@class='content']" +
            "//select[@name='customfield_10400']//option[contains(text(), 'S0 Тривиальный/Trivial')]");

    private SelenideElement buttonInputBug = $x("//footer[@class='aui-dialog2-footer']//div[@class='buttons']//input[@name='Edit']");

    private final SelenideElement pDesription = $("p");
    private final SelenideElement pEnv = $("p");
    private final String topicBug = "New Bug AT13";
    private final String markerBug = "bugfix";
    private final String description = "FIX FIX FIX";
    private final String searchTask = "TEST-182096";
    private final String board = "Доска Спринт 1";




    public void clckButton(){
        createButton.click();
    }

    public void clckButtonVisual(){
        buttonVisual.click();
    }

    public void clckInputTopicBugField(){
        inputVersion.shouldBe(Condition.visible, Duration.ofSeconds(8));
        inputTopicBug.click();
        inputTopicBug.sendKeys(topicBug);
    }

    public void writeFieldDesription(){
        switchTo().frame(descriptionFieldIframe);
        pDesription.sendKeys(description);
        switchTo().defaultContent();
    }

    public void chooseVersionFix(){
        inputVersion.click();
    }

    public void sendTextInTextAriaBug(){
        textAriaBug.click();
        textAriaBug.setValue(markerBug).pressEnter();
    }

    public void writeEnvField(){
        switchTo().frame(envFieldIframe);
        pEnv.sendKeys(description);
        switchTo().defaultContent();
    }

    public void choiceVersionBug(){
        choiceVersion.click();
    }

    public void connetTaskNewBug()
    {
        connectTask.click();
        connectTask.setValue(searchTask).pressEnter();
    }

    public void linkApicBug(){
        linkApic.click();
        linkApic.setValue(markerBug).pressEnter();
    }

    public void choiceSprintBug(){
        sprint.click();
        sprint.setValue(board).pressEnter();
    }

    public void choicePrioretyBug(){
        listPrioretyBug.click();
        prioretyBug.click();

    }

    public void createNewBugButtonClick()
    {
        buttonInputBug.click();
    }
}
