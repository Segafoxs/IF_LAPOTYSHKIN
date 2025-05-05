package ru.iFellow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AutoTest extends WebHooks {
    private final AuthorizationPage authPage = new AuthorizationPage();
    private final ListTaskPage listTaskPage = new ListTaskPage();
    private final TestProjectPage testProjectPage = new TestProjectPage();
    private final CreateNewBug createNewBug = new CreateNewBug();
    private final CloseTask closetask = new CloseTask();
    private final String login = "AT13";
    private final String password = "Qwerty123";
    private final String checkTextH3 = "Назначенные мне";

    @Test
    @DisplayName("Авторизация в Jira")
    public void TestAuth(){
        authPage.enterAuthLogin(login, password);
        assertEquals(checkTextH3, authPage.getTextH3(), "Авторизация не пройдена");
    }

    @Test
    @DisplayName("Открытие проекта TEST")
    public void goTestProject(){
        authPage.enterAuthLogin(login, password);
        listTaskPage.clickDropList();
        assertTrue(listTaskPage.getHrefProjectTest(), "Неверный URL");
    }

    @Test
    @DisplayName("Проверка счетчика задания")
    public void checkCountTask(){
        authPage.enterAuthLogin(login, password);
        listTaskPage.clickDropList();
        testProjectPage.FilterTask();
        assertEquals("Все задачи", testProjectPage.checkAllTask());
        int numberTaskBefore = testProjectPage.checkNumberTask();
        testProjectPage.CreateTask();
        testProjectPage.pageReload();
        int numberTaskAfter = testProjectPage.checkNumberTask();
        assertEquals(numberTaskBefore + 1, numberTaskAfter, "Неверное количество задач");
    }

    @Test
    @DisplayName("Проверка статуса и версии задачи TestSeleniumATHomework")
    public void checkTaskSelehiumHW(){
        authPage.enterAuthLogin(login, password);
        listTaskPage.clickDropList();
        testProjectPage.FilterTask();
        testProjectPage.CreateTask();
        testProjectPage.searchLineRequest();
        assertEquals("Сделать", testProjectPage.checkStatusTask(), "Неверный статус");
        assertEquals("Version 2.0", testProjectPage.checkVersion(), "Неверная версия");
    }

    @Test
    @DisplayName("Создание и закрытие бага")
    public void createNewBugJira(){
        authPage.enterAuthLogin(login, password);
        listTaskPage.clickDropList();
        testProjectPage.FilterTask();
        testProjectPage.CreateTask();
        testProjectPage.searchLineRequest();
        createNewBug.clckButton();
        createNewBug.clckButtonVisual();
        createNewBug.clckInputTopicBugField();
        createNewBug.writeFieldDesription();
        createNewBug.chooseVersionFix();
        createNewBug.sendTextInTextAriaBug();
        createNewBug.writeEnvField();
        createNewBug.choiceVersionBug();
        createNewBug.connetTaskNewBug();
        createNewBug.choiceSprintBug();
        createNewBug.choicePrioretyBug();
        createNewBug.createNewBugButtonClick();
        closetask.closeTaskJira();
        closetask.choiceFilterTask();
        assertEquals("Сделать", closetask.checkStatusBug(), "Неверный статус задачи");
        closetask.openDropDown();
        assertEquals("Готово", closetask.checkStatusBug(), "Задача не закрыта");
    }
}
