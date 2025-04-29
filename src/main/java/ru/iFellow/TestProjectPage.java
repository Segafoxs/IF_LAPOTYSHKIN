package ru.iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPage {

    private final String newTask = "TestTask AT13";

    private final SelenideElement btnCreateTask = $x("//div[@class='details-layout']//div[@class='iic-trigger']//button");

    private final SelenideElement txtArea = $x("//div[@class='details-layout']" +
            "//div[@class='iic-widget']//textarea[@name='summary']");

    private final SelenideElement listOil = $x("//div[@class='aui-item list-results-panel']" +
            "//div[@class='list-content']/ol[@class='issue-list']");

    private final SelenideElement dropDownFilter = $x("//div[@class='aui-page-panel-inner']//header[@class='aui-page-header issue-search-header']//button[@id='subnav-trigger']");

    private final SelenideElement checkBoxFilter = $x("//div[@class='issue-search']" +
            "//div[contains(@class, 'subnavigation')]//div[@class='aui-dropdown2-section']//ul//a[contains(text(), 'Все задачи')]");

    private final SelenideElement searchLine = $x("//div[@class='aui-header-inner']//input[@id='quickSearchInput']");

    private final SelenideElement statusTask = $x("//main[@id='main']//div[@class='navigator-group']//div[contains(@class, 'detail-panel')]//div[contains(@class, 'issue-body-content')]//div[contains(@class, 'issue-main-column')]//ul[@id='issuedetails']//span[contains(text(), 'Сделать')]");

    private SelenideElement version = $x("//div[@class='navigator-group']//div[@class='details-layout']" +
            "//ul[@id='issuedetails']//span[@id='fixfor-val']//a");




    public void CreateTask()
    {
        btnCreateTask.click();
        txtArea.setValue(newTask).pressEnter();

    }

    public void FilterTask()
    {
        dropDownFilter.click();
        checkBoxFilter.click();

    }

    public void searchLineRequest()
    {
        searchLine.setValue("TestSeleniumATHomework").pressEnter();
    }

    public String popItemList()
    {
        return listOil.innerText();
    }

    public String checkNumberTask(String str)
    {

        return str.substring(5, 11);

    }

    public String checkStatusTask(){
        return statusTask.shouldBe(Condition.visible).innerText();
    }

    public String checkVersion(){
        return version.shouldBe(Condition.visible).innerText();
    }
}
