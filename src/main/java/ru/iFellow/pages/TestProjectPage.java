package ru.iFellow.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class TestProjectPage {
    private final SelenideElement btnCreateTask = $x("//div[@class='details-layout']//div[@class='iic-trigger']" +
            "//button[contains(text(), 'Создать задачу')]").as("Кнопка создания задачи");
    private final SelenideElement txtArea = $x("//div[@class='details-layout']" +
            "//div[@class='iic-widget']//textarea[@name='summary']").as("Текстовое поле создания новой задачи");
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
    private SelenideElement countTask = $x("//div[@class='showing']/span").as("Количество задач");

    @Step("Создаем задачу")
    public void CreateTask(String newTask)
    {
        btnCreateTask.shouldBe(Condition.visible, Duration.ofSeconds(40));
        btnCreateTask.click();
        txtArea.shouldBe(Condition.visible, Duration.ofSeconds(40));
        txtArea.setValue(newTask).pressEnter();
    }

    @Step("Сортируем задачи по фильтру '{filter}'")
    public void FilterTask(String filter)
    {
        dropDownFilter.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        checkBoxFilter.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        checkTextFilter.shouldHave(Condition.text(filter));
    }

    @Step("Проверяем текст у фильтра")
    public String checkFilterText(String txt)
    {
        checkTextFilter.shouldHave(Condition.text(txt));
        return checkTextFilter.innerText();
    }

    @Step("Ищем задачу с заголовком '{search}'")
    public void searchLineRequest(String search)
    {
        searchLine.shouldBe(Condition.visible);
        searchLine.setValue(search).pressEnter();
    }

    @Step("Проверяем номер последней задачи")
    public int checkNumTask()
    {
        String result = countTask.innerText();
        return Integer.parseInt(result.substring(result.indexOf("из") + 3));
    }

    public void waitUpdateCountTask(int count){
        countTask.shouldBe(Condition.visible, Duration.ofSeconds(40));
        countTask.shouldHave(Condition.text("1 из " + String.valueOf(count + 1)));
    }

    @Step("Проверяем статус у задачи")
    public String checkStatusTask(){
        return statusTask.shouldBe(Condition.visible).innerText();
    }

    @Step("Проверяем версию у задачи")
    public String checkVersion(){
        return version.shouldBe(Condition.visible).innerText();
    }
}
