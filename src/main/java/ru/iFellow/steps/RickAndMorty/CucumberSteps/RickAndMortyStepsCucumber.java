package ru.iFellow.steps.RickAndMorty.CucumberSteps;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.dto.CharacterModels.Character;
import ru.iFellow.dto.CharacterModels.Root;
import ru.iFellow.dto.EpisodeModels.Episode;
import ru.iFellow.steps.RickAndMorty.RickAndMortySteps;
import java.util.ArrayList;

public class RickAndMortyStepsCucumber {
    private final RickAndMortySteps rickAndMorty = new RickAndMortySteps();
    Root root;
    ArrayList<Character> ls;
    Character lastCharacter;

    @Когда("^ищем информацию по персонажу '(.*)'")
    public void searchInfoCharacter(String name){
        root = rickAndMorty.getCharacterForName(name);
        ls = rickAndMorty.popCharacterList(root);
    }

    @Тогда("^проверим, что его зовут '(.*)'")
    public void checkName(String name){
        Assertions.assertEquals(name, ls.get(0).name);
    }

    @И("получим из списка последнего эпизода последнего персонажа")
    public void getLastCharacter(){
        String lastEpisode = ls.get(0).episode.get(ls.get(0).episode.size() - 1);
        int lenListCharacterEpisode = rickAndMorty.getItemForLink(lastEpisode, Episode.class).characters.size() - 1;
        String urlLastCharacter = rickAndMorty.getItemForLink(lastEpisode, Episode.class).characters.get(lenListCharacterEpisode);
        lastCharacter = rickAndMorty.getItemForLink(urlLastCharacter, Character.class);
    }

    @И("сверим рассы и местоположения двух персонажей")
    public void checkRaceAndLoctation(){
        Assertions.assertEquals(lastCharacter.species, ls.get(0).species);
        Assertions.assertNotEquals(lastCharacter.location.name, ls.get(0).location.name);
    }
}
