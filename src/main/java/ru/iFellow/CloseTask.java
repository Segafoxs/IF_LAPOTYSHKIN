package ru.iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CloseTask {
    private final SelenideElement searchLines = $x("//div[@class='aui-header-inner']//li[@id='quicksearch-menu']" +
            "//input[@id='quickSearchInput']");

    private final SelenideElement filterSearchTask = $x("//div[@class='filters-content']" +
            "//div[@class='filter-panel-wrapper']//ul//li/a[contains(text(), 'Все задачи')]");

    private final String lastTask = "TestTask AT13";
    private final SelenideElement dropWownBussines = $x("//div[@id='content']//div[@class='command-bar']//div[@class='ops-cont']" +
            "//div[@id='opsbar-opsbar-transitions']//a[@id='opsbar-transitions_more']//span");

    private final SelenideElement doneStatusTask = $x("//div[@id='content']" +
            "//div[@class='command-bar']//div[@class='ops-cont']//a//span[contains(text(), 'Выполнено')]");

    public void closeTaskJira(){
        searchLines.setValue(lastTask).pressEnter();
    }

    public void openDropDown(){
        dropWownBussines.shouldBe(Condition.visible, Duration.ofSeconds(8));
        dropWownBussines.click();
        doneStatusTask.shouldBe(Condition.visible, Duration.ofSeconds(20));
        doneStatusTask.click();
    }

    public void choiceFilterTask()
    {
        filterSearchTask.click();
    }

//    public String checkStatusTask()
//    {
//        return statusTask.shouldBe(Condition.visible).innerText();
//    }
}

