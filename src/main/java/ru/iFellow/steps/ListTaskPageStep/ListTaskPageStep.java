package ru.iFellow.steps.ListTaskPageStep;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.Pages.ListTaskPage.ListTaskPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListTaskPageStep {

    private final ListTaskPage listTaskPage = new ListTaskPage();

    @И("открыли выпадающее меню")
    public void openDropDown(){
        listTaskPage.clickDropList();
    }

    @Тогда("увидели url")
    public void checkUrl(){
        listTaskPage.getHrefProjectTest();
        assertTrue(listTaskPage.getHrefProjectTest(), "Неверный URL");
    }
}
