package ru.iFellow;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoTest extends WebHooks {
    private final AuthorizationPage authPage = new AuthorizationPage();
    private final ListTaskPage listTaskPage = new ListTaskPage();
    private final TestProjectPage testProjectPage = new TestProjectPage();
    private final CreateNewBug createNewBug = new CreateNewBug();
    private final CloseTask closetask = new CloseTask();
    private final String login = "AT13";
    private final String password = "Qwerty123";


    @Test
    public void TestAuth(){
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickLoginBtn();
    }

    @Test
    public void goTestProject(){
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickLoginBtn();
        listTaskPage.clickDropList();
    }

    @Test
    public void checkCountTask(){
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickLoginBtn();
        listTaskPage.clickDropList();
        testProjectPage.FilterTask();
        String result = testProjectPage.popItemList();
        String numberTask = testProjectPage.checkNumberTask(result);
        testProjectPage.CreateTask();
        Selenide.refresh();
        String result2 = testProjectPage.popItemList();
        String numberTask2 = testProjectPage.checkNumberTask(result2);
        Assertions.assertEquals(Integer.parseInt(numberTask2), Integer.parseInt(numberTask) + 1);
    }

    @Test
    public void checkTaskSelehiumHW(){
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickLoginBtn();
        listTaskPage.clickDropList();
        testProjectPage.FilterTask();
        testProjectPage.CreateTask();
        testProjectPage.searchLineRequest();
        Assertions.assertEquals("Сделать", testProjectPage.checkStatusTask());
        Assertions.assertEquals("Version 2.0", testProjectPage.checkVersion());
    }

    @Test
    public void createNewBugJira(){
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickLoginBtn();
        listTaskPage.clickDropList();
        testProjectPage.FilterTask();
        testProjectPage.CreateTask();
        Selenide.refresh();
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
        createNewBug.linkApicBug();
        createNewBug.choiceSprintBug();
        createNewBug.choicePrioretyBug();
        createNewBug.createNewBugButtonClick();
        closetask.closeTaskJira();
        closetask.choiceFilterTask();
        String result = testProjectPage.popItemList();
        String numberTask = testProjectPage.checkNumberTask(result);
        closetask.openDropDown();
    }
}
