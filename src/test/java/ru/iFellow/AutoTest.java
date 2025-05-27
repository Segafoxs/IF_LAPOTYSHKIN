package ru.iFellow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.iFellow.pages.*;
import ru.iFellow.utill.TestProperties;

public class AutoTest extends WebHooks {
    private final AuthorizationPage authPage = new AuthorizationPage();
    private final ListTaskPage listTaskPage = new ListTaskPage();
    private final TestProjectPage testProjectPage = new TestProjectPage();
    private final CreateNewBug createNewBug = new CreateNewBug();
    private final CloseTask closetask = new CloseTask();

    @Test
    @DisplayName("Авторизация в Jira")
    public void TestAuth() {
        authPage.enterAuthLogin(TestProperties.getProperty("login"), TestProperties.getProperty("password"));
        assertEquals("Назначенные мне", authPage.getTextH3(), "Авторизация не пройдена");
    }

    @Test
    @DisplayName("Открытие проекта TEST")
    public void goTestProject() {
        authPage.enterAuthLogin(TestProperties.getProperty("login"), TestProperties.getProperty("password"));
        listTaskPage.clickDropList();
        assertTrue(listTaskPage.getHrefProjectTest("TEST"), "Неверный URL");
    }

    @Test
    @DisplayName("Проверка счетчика задания")
    public void checkCountTask() {
        authPage.enterAuthLogin(TestProperties.getProperty("login"), TestProperties.getProperty("password"));
        listTaskPage.clickDropList();
        testProjectPage.FilterTask(TestProperties.getProperty("filterTaskMe"));
        assertEquals(TestProperties.getProperty("filterTaskMe"), testProjectPage.checkFilterText(TestProperties.getProperty("filterTaskMe")));
        int numberTaskBefore = testProjectPage.checkNumTask();
        testProjectPage.CreateTask(TestProperties.getProperty("newTask"));
        testProjectPage.FilterTask(TestProperties.getProperty("filterTaskMe"));
        assertEquals(TestProperties.getProperty("filterTaskMe"), testProjectPage.checkFilterText(TestProperties.getProperty("filterTaskMe")));
        testProjectPage.waitUpdateCountTask(numberTaskBefore);
        int numberTaskAfter = testProjectPage.checkNumTask();
        assertEquals(numberTaskAfter, numberTaskBefore + 1, "Неверное количество задач");
    }

    @Test
    @DisplayName("Проверка статуса и версии задачи TestSeleniumATHomework")
    public void checkTaskSelehiumHW() {
        authPage.enterAuthLogin(TestProperties.getProperty("login"), TestProperties.getProperty("password"));
        listTaskPage.clickDropList();
        testProjectPage.FilterTask(TestProperties.getProperty("filterTaskMe"));
        testProjectPage.CreateTask(TestProperties.getProperty("newTask"));
        testProjectPage.searchLineRequest(TestProperties.getProperty("searchTask"));
        assertEquals("Сделать", testProjectPage.checkStatusTask(), "Неверный статус");
        assertEquals("Version 2.0", testProjectPage.checkVersion(), "Неверная версия");
    }

    @Test
    @DisplayName("Создание и закрытие бага")
    public void createNewBugJira() {
        authPage.enterAuthLogin(TestProperties.getProperty("login"), TestProperties.getProperty("password"));
        listTaskPage.clickDropList();
        testProjectPage.FilterTask(TestProperties.getProperty("filterTaskMe"));
        testProjectPage.CreateTask(TestProperties.getProperty("newTask"));
        testProjectPage.searchLineRequest(TestProperties.getProperty("searchTask"));
        createNewBug.clckButton();
        createNewBug.clckButtonVisual();
        createNewBug.clckInputTopicBugField(TestProperties.getProperty("topicBug"));
        createNewBug.writeFieldDesription(TestProperties.getProperty("description"));
        createNewBug.chooseVersionFix();
        createNewBug.sendTextInTextAriaBug(TestProperties.getProperty("markerBug"));
        createNewBug.writeEnvField(TestProperties.getProperty("description"));
        createNewBug.choiceVersionBug();
        createNewBug.connetTaskNewBug(TestProperties.getProperty("task"));
        createNewBug.choiceSprintBug(TestProperties.getProperty("board"));
        createNewBug.choicePrioretyBug();
        createNewBug.createNewBugButtonClick();
        closetask.closeTaskJira();
        closetask.choiceFilterTask(TestProperties.getProperty("filterTaskAll"));
        assertEquals("Сделать", closetask.checkStatusBug(), "Неверный статус задачи");
        closetask.openDropDown();
        assertEquals("Готово", closetask.checkStatusBug(), "Задача не закрыта");
    }
}

