package ru.iFellow.steps.CloseBugStep;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.Pages.CloseTaskPage.CloseTask;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloseBugStep {
    private final CloseTask closeTask = new CloseTask();

    @И("^нашли созданный баг '(.*)'")
    public void searchLastBug(String lastTask){
        closeTask.closeTaskJira(lastTask);
        closeTask.choiceFilterTask();
        assertEquals("Сделать", closeTask.checkStatusBug());
    }

    @Тогда("меняем статус у бага")
    public void closeBug(){
        closeTask.openDropDown();
        assertEquals("Готово", closeTask.checkStatusBug());
    }
}
