package ru.iFellow.Pages.CreateNewBugPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class CreateNewBug {
    private final SelenideElement createButton = $x("//header[@id='header']//nav[contains(@class, 'aui-header')]" +
            "//div[@class='aui-header-primary']/ul[@class='aui-nav']//li[@id='create-menu']//a").as("Кнопка создать");
    private final SelenideElement buttonVisual = $x("//form[@name='jiraform']/div/div[@class='content']/div[@class='field-group']//div[@id='description-wiki-edit']" +
            "//ul[@class='aui-nav']//button[contains(text(),'Визуальный')]").as("Кнопка визуальный");
    private final SelenideElement buttonVisualTwo = $x("//form[@name='jiraform']//div[@class='content']//div[@id='environment-wiki-edit']" +
            "//ul[@class='aui-nav']//button[contains(text(), 'Визуальный')]").as("Кнопка визуальный");
    private final SelenideElement inputTopicBug = $x("//div[@class='qf-container']//form[@name='jiraform']" +
            "//div[@class='content']//input[@id='summary']");
    private final SelenideElement descriptionFieldIframe = $x("//div[@id='description-wiki-edit']" +
            "//div[@class='rte-container']//iframe[@id='mce_0_ifr']").as("Фрейм описания бага");
    private final SelenideElement inputVersion = $x("//form[@name='jiraform']//select[@id='fixVersions']").as("Исправлено в версии");
    private final SelenideElement textAriaBug = $x("//form[@name='jiraform']//div[@class='content']" +
            "//div[@id='labels-multi-select']//textarea").as("Метки");
    private final SelenideElement envFieldIframe = $x("//form[@name='jiraform']//div[@class='content']" +
            "//div[@id='environment-wiki-edit']//div[@class='rte-container']//iframe").as("Фрейм окружение");
    private final SelenideElement choiceVersion = $x("//form[@name='jiraform']//div[@class='content']//" +
            "select[@id='versions']").as("Затронуты версии");
    private SelenideElement connectTask = $x("//form[@name='jiraform']//div[@class='content']" +
            "//textarea[@id='issuelinks-issues-textarea']").as("Связать задачу");
    private SelenideElement sprint = $x("//form[@name='jiraform']//div[@class='content']//input[@id='customfield_10104-field']").as("Спринт");
    private SelenideElement listPrioretyBug = $x("//form[@name='jiraform']//div[@class='content']" +
            "//select[@name='customfield_10400']").as("Список приоритетов бага");
    private SelenideElement prioretyBug = $x("//form[@name='jiraform']//div[@class='content']" +
            "//select[@name='customfield_10400']//option[contains(text(), 'S0 Тривиальный/Trivial')]").as("Приоритет бага");
    private SelenideElement buttonInputBug = $x("//footer[@class='aui-dialog2-footer']//div[@class='buttons']//input[@name='Edit']").as("Отправка формы создания бага");
    private final SelenideElement pDesription = $("p");
    private final SelenideElement pEnv = $("p");

    public void clckCreateBugButton(){
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
        createButton.click();
    }

    public void clckButtonVisual(){
        buttonVisual.shouldBe(Condition.visible, Duration.ofSeconds(8));
        buttonVisual.click();
        buttonVisualTwo.shouldBe(Condition.visible, Duration.ofSeconds(8));
        buttonVisualTwo.click();
    }

    public void clckInputTopicBugField(String topicBug){
        inputVersion.shouldBe(Condition.visible, Duration.ofSeconds(8));
        inputTopicBug.click();
        inputTopicBug.sendKeys(topicBug);
    }

    public void writeFieldDesription(String description){
        descriptionFieldIframe.shouldBe(Condition.visible, Duration.ofSeconds(8));
        switchTo().frame(descriptionFieldIframe);
        pDesription.shouldBe(Condition.visible, Duration.ofSeconds(8));
        pDesription.sendKeys(description);
        switchTo().defaultContent();
    }

    public void chooseVersionFix(String version){
        inputVersion.shouldBe(Condition.visible, Duration.ofSeconds(8));
        inputVersion.selectOption(version);
    }

    public void sendTextInTextAriaBug(String marker){
        textAriaBug.shouldBe(Condition.visible, Duration.ofSeconds(8));
        textAriaBug.click();
        textAriaBug.setValue(marker).pressEnter();
    }

    public void writeEnvField(String env){
        switchTo().frame(envFieldIframe);
        pEnv.sendKeys(env);
        switchTo().defaultContent();
    }

    public void choiceVersionBug(String version){
        choiceVersion.shouldBe(Condition.visible, Duration.ofSeconds(8));
        choiceVersion.selectOption(version);
    }

    public void connetTaskNewBug(String task)
    {
        connectTask.shouldBe(Condition.visible, Duration.ofSeconds(8));
        connectTask.click();
        connectTask.setValue(task).pressEnter();
    }

    public void choiceSprintBug(String boardSprint){
        sprint.shouldBe(Condition.visible, Duration.ofSeconds(8));
        sprint.click();
        sprint.setValue(boardSprint).pressEnter();
    }

    public void choicePrioretyBug(){
        listPrioretyBug.shouldBe(Condition.visible, Duration.ofSeconds(8));
        listPrioretyBug.click();
        prioretyBug.shouldBe(Condition.visible, Duration.ofSeconds(8));
        prioretyBug.click();

    }

    public void createNewBugButtonClick()
    {
        buttonInputBug.shouldBe(Condition.visible, Duration.ofSeconds(8));
        buttonInputBug.click();
    }
}
