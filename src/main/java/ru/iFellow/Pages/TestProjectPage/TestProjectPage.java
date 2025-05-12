package ru.iFellow.Pages.TestProjectPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPage {

    private final String newTask = "TestTask AT13";
    private final SelenideElement btnCreateTask = $x("//div[@class='details-layout']//div[@class='iic-trigger']" +
            "//button[contains(text(), 'Создать задачу')]").as("Кнопка создания задачи");
    private final SelenideElement txtArea = $x("//div[@class='details-layout']" +
            "//div[@class='iic-widget']//textarea[@name='summary']").as("Текстовое поле создания новой задачи");
    private final ElementsCollection listLi = $$x("//div[@class='aui-item list-results-panel']" +
            "//div[@class='list-content']/ol[@class='issue-list']/li").as("Результат поиска");
    private final SelenideElement dropDownFilter = $x("//div[@class='aui-page-panel-inner']" +
            "//header[@class='aui-page-header issue-search-header']//button[@id='subnav-trigger']").as("Выпадающее меню");
    private final SelenideElement checkBoxFilter = $x("//div[@class='issue-search']" +
            "//div[contains(@class, 'subnavigation')]//div[@class='aui-dropdown2-section']//ul//a[contains(text(), 'Сообщенные мной')]").as("Фильтр задач");
    private final SelenideElement searchLine = $x("//div[@class='aui-header-inner']" +
            "//input[@id='quickSearchInput']").as("Строка поиска");
    private final SelenideElement statusTask = $x("//main[@id='main']//div[@class='navigator-group']//div[contains(@class, 'detail-panel')]//div[contains(@class, 'issue-body-content')]//div[contains(@class, 'issue-main-column')]" +
            "//ul[@id='issuedetails']//span[@id='status-val']//span[contains(@class, 'aui-lozenge')]").as("Статус задачи");
    private SelenideElement version = $x("//div[@class='navigator-group']//div[@class='details-layout']" +
            "//ul[@id='issuedetails']//span[@id='fixfor-val']//a[contains(text(), 'Version 2.0')]").as("Исправить в версиях");
    private SelenideElement checkTextFilter = $x("//div[@class='content']//header[@class='aui-page-header issue-search-header']" +
            "//span[@id='issues-subnavigation-title']").as("Текст фильтра");
    private SelenideElement checkSearchResult = $x("//div[@class='navigator-group']//div[@class='details-layout']" +
            "//div[@class='list-content']//span[@class='issue-link-summary']");

    public void CreateTask()
    {
        btnCreateTask.shouldBe(Condition.visible, Duration.ofSeconds(40));
        btnCreateTask.click();
        txtArea.shouldBe(Condition.visible, Duration.ofSeconds(40));
        txtArea.setValue(newTask).pressEnter();
    }

    public void FilterTask()
    {
        dropDownFilter.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        checkBoxFilter.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        checkTextFilter.shouldHave(Condition.text("Сообщенные мной"));
    }

    public void pageReload()
    {
        Selenide.refresh();
    }

    public String checkAllTask()
    {
        checkTextFilter.shouldHave(Condition.text("Сообщенные мной"));
        return checkTextFilter.innerText();
    }

    public void searchLineRequest(String search)
    {
        searchLine.shouldBe(Condition.visible);
        searchLine.setValue(search).pressEnter();
    }

    public int checkNumberTask()
    {
        checkTextFilter.shouldHave(Condition.text("Сообщенные мной"));
        SelenideElement liElement = listLi.first();
        String temp = liElement.innerText();
        return Integer.parseInt(temp.substring(5, 11));
    }

    public String checkSearchRes(){
        return checkSearchResult.innerText();
    }

    public String checkStatusTask(){
        return statusTask.shouldBe(Condition.visible).innerText();
    }

    public String checkVersion(){
        return version.shouldBe(Condition.visible).innerText();
    }
}
