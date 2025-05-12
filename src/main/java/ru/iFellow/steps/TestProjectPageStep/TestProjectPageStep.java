package ru.iFellow.steps.TestProjectPageStep;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.Pages.TestProjectPage.TestProjectPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProjectPageStep {
    private final TestProjectPage testProjectPage = new TestProjectPage();
    int numberTaskBefore;

    @И("включили фильтр СООБЩЕННЫЕ МНОЙ")
    public void filterTask(){
        testProjectPage.FilterTask();
        assertEquals("Сообщенные мной", testProjectPage.checkAllTask(), "Неверный фильтр поиска задач");
    }

    @Тогда("смотрим номер последней задачи")
    public void checkNumTask(){
        assertEquals("Сообщенные мной", testProjectPage.checkAllTask());
        numberTaskBefore = testProjectPage.checkNumberTask();
    }

    @И("создали новую задачу и обновили страницу")
    public void createNewTask(){
        testProjectPage.CreateTask();
        testProjectPage.pageReload();
    }

    @Тогда("проверяем номер последней задачи")
    public void checkLastTaskNum(){
        testProjectPage.pageReload();
        int numberTaskAfter = testProjectPage.checkNumberTask();
        assertEquals(numberTaskBefore+ 1, numberTaskAfter, "Неверное количество задач");
    }
}
