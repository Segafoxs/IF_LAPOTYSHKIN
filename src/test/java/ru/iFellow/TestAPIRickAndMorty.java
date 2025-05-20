package ru.iFellow;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.API.Specifications.Specifications;
import ru.iFellow.models.CharacterModels.Character;
import ru.iFellow.models.CharacterModels.Root;
import ru.iFellow.steps.RickAndMortySteps;
import java.util.ArrayList;
import static ru.iFellow.utill.TestProperties.getProperty;

public class TestAPIRickAndMorty {
    private final RickAndMortySteps rickAndMorty = new RickAndMortySteps();

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(getProperty("baseURLRickAndMorty"));
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }

    @Test
    @DisplayName("Получение информации персонажа по имени Morty Smith")
    public void getInfoMortySmith() {
        Root root = rickAndMorty.getCharacterForName("Morty Smith");
        ArrayList<Character> ls = rickAndMorty.popCharacterList(root);
        Assertions.assertEquals("Morty Smith", ls.get(0).name);
    }

    @Test
    @DisplayName("Получение из списка последнего эпизода последнего персонажа")
    public void getLastCharacter() {
        Root root = rickAndMorty.getCharacterForName("Morty Smith");
        ArrayList<Character> ls = rickAndMorty.popCharacterList(root);
        String lastEpisode = ls.get(0).episode.get(ls.get(0).episode.size() - 1);
        int lenListCharacterEpisode = rickAndMorty.getEpisodeForLink(lastEpisode).characters.size() - 1;
        String urlLastCharacter = rickAndMorty.getEpisodeForLink(lastEpisode).characters.get(lenListCharacterEpisode);
        int idEpisode = rickAndMorty.getEpisodeForLink(lastEpisode).id;
        Character lastCharacter = rickAndMorty.getCharacterForLink(urlLastCharacter);
        Assertions.assertEquals(51, idEpisode);
        Assertions.assertEquals("Young Jerry", lastCharacter.name);
    }

    @Test
    @DisplayName("Получение местонахождения и расы персонажа")
    public void getLocationAndRace() {
        Root root = rickAndMorty.getCharacterForName("Morty Smith");
        ArrayList<Character> ls = rickAndMorty.popCharacterList(root);
        String lastEpisode = ls.get(0).episode.get(ls.get(0).episode.size() - 1);
        int lenListCharacterEpisode = rickAndMorty.getEpisodeForLink(lastEpisode).characters.size() - 1;
        String urlLastCharacter = rickAndMorty.getEpisodeForLink(lastEpisode).characters.get(lenListCharacterEpisode);
        Character lastCharacter = rickAndMorty.getCharacterForLink(urlLastCharacter);
        String species = lastCharacter.species;
        String location = lastCharacter.location.name;
        Assertions.assertEquals("Human", species);
        Assertions.assertEquals("Earth (Unknown dimension)", location);
    }

    @Test
    @DisplayName("Проверка рассы и местоположения двух персонажей")
    public void checkLocationAndRace(){
        Root root = rickAndMorty.getCharacterForName("Morty Smith");
        ArrayList<Character> ls = rickAndMorty.popCharacterList(root);
        String lastEpisode = ls.get(0).episode.get(ls.get(0).episode.size() - 1);
        int lenListCharacterEpisode = rickAndMorty.getEpisodeForLink(lastEpisode).characters.size() - 1;
        String urlLastCharacter = rickAndMorty.getEpisodeForLink(lastEpisode).characters.get(lenListCharacterEpisode);
        Character lastCharacter = rickAndMorty.getCharacterForLink(urlLastCharacter);
        String speciesJerry = lastCharacter.species;
        String locationJerry = lastCharacter.location.name;
        String speciesMorty = ls.get(0).species;
        String locationMorty = ls.get(0).location.name;
        Assertions.assertEquals(speciesJerry, speciesMorty);
        Assertions.assertNotEquals(locationJerry, locationMorty);
    }
}

