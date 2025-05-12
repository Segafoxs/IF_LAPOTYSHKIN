package ru.iFellow.steps.CreateNewBugStep;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.Pages.CreateNewBugPage.CreateNewBug;

public class CreateNewBugStep {
    private final CreateNewBug createNewBug = new CreateNewBug();

    @И("нажали кнопку создать")
    public void clickCreateButton(){
        createNewBug.clckCreateBugButton();
    }

    @И("прожали кнопки ВИЗУАЛЬНЫЙ")
    public void clickVisuall(){
        createNewBug.clckButtonVisual();
    }

    @И("^заполнили поле ТЕМА '(.*)'")
    public void enterFieldThemBug(String thems){
        createNewBug.clckInputTopicBugField(thems);
    }

    @И("^заполнили текстовое поле ОПИСАНИЕ '(.*)'")
    public void enterDescriptionFieldBug(String description){
        createNewBug.writeFieldDesription(description);
    }

    @И("^выбрали испраленную версию  '(.*)'")
    public void chooseVersionBugFix(String version){
        createNewBug.chooseVersionFix(version);
    }

    @И("^заполнили поле МЕТКА '(.*)'")
    public void enterMarkerField(String marker){
        createNewBug.sendTextInTextAriaBug(marker);
    }

    @И("^заполнили текстовое поле ОКРУЖЕНИЕ '(.*)'")
    public void enterEnvField(String env){
        createNewBug.writeEnvField(env);
    }

    @И("^выбрали версию ЗАТРОНУТЫ ВЕРСИИ '(.*)'")
    public void choiceVersionBug(String version){
        createNewBug.choiceVersionBug(version);
    }

    @И("^связали с задачей '(.*)'")
    public void connectTaskBug(String task){
        createNewBug.connetTaskNewBug(task);
    }

    @И("^выбрали доску спринта '(.*)'")
    public void chooseSprint(String boardSprint){
        createNewBug.choiceSprintBug(boardSprint);
    }

    @И("указали серьезность бага")
    public void choosePriorety(){
        createNewBug.choicePrioretyBug();
    }

    @Тогда("прожали кнопку СОЗДАТЬ")
    public void clickButtonCreate(){
        createNewBug.createNewBugButtonClick();
    }
}
