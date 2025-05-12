package ru.iFellow.Pages.CloseTaskPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class CloseTask {
    private final SelenideElement searchLines = $x("//div[@class='aui-header-inner']//li[@id='quicksearch-menu']" +
            "//input[@id='quickSearchInput']").as("Строка поиска");
    private final SelenideElement filterSearchTask = $x("//div[@class='filters-content']" +
            "//div[@class='filter-panel-wrapper']//ul//li/a[contains(text(), 'Все задачи')]").as("Фильтр все задачи");

    private final SelenideElement dropWownBussines = $x("//div[@id='content']//div[@class='command-bar']//div[@class='ops-cont']" +
            "//div[@id='opsbar-opsbar-transitions']//a[@id='opsbar-transitions_more']//span").as("Выпадающее меню статуса бага");
    private final SelenideElement statusBug = $x("//div[@id='content']//div[@class='issue-body-content']" +
            "//ul[@id='issuedetails']//span[@id='status-val']/span").as("Статус бага");
    private final SelenideElement doneStatusTask = $x("//div[@id='content']" +
            "//div[@class='command-bar']//div[@class='ops-cont']//a//span[contains(text(), 'Выполнено')]").as("Статус выполнено");

    public void closeTaskJira(String lastTask) {
        searchLines.shouldBe(Condition.visible, Duration.ofSeconds(20));
        searchLines.setValue(lastTask).pressEnter();
    }

    public void openDropDown() {
        dropWownBussines.shouldBe(Condition.visible, Duration.ofSeconds(20));
        dropWownBussines.click();
        doneStatusTask.shouldBe(Condition.visible, Duration.ofSeconds(20));
        doneStatusTask.click();
        statusBug.shouldHave(Condition.text("Готово"));
    }

    public void choiceFilterTask() {
        filterSearchTask.shouldBe(Condition.visible, Duration.ofSeconds(20));
        filterSearchTask.click();
    }

    public String checkStatusBug(){
        statusBug.shouldBe(Condition.visible, Duration.ofSeconds(80));
        return statusBug.innerText();
    }
}

