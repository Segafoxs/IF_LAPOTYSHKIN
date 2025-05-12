package ru.iFellow.steps.CheckStatusAndVersionStep;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.Pages.TestProjectPage.TestProjectPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckStatusAndVersionStep {
    private final TestProjectPage testProjectPage = new TestProjectPage();

    @И("^ввели в поисковую строку '(.*)'")
    public void openSearchLine(String searchTask){
        testProjectPage.searchLineRequest(searchTask);
        assertEquals(testProjectPage.checkSearchRes(), searchTask);
    }

    @Тогда("^проверяем статус задачи '(.*)'")
    public void checkStatusTsk(String status){
        assertEquals(status, testProjectPage.checkStatusTask(), "Неверный статус");
    }

    @Тогда("^проверяем версию '(.*)'")
    public void checkVersionTask(String version){
        assertEquals(version, testProjectPage.checkVersion(), "Неверная версия");
    }
}
