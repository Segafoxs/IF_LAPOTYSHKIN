package ru.iFellow.steps;
import ru.iFellow.API.rickAndMorty.RickAndMortyAPI;
import ru.iFellow.models.CharacterModels.Character;
import ru.iFellow.models.CharacterModels.Root;
import ru.iFellow.models.EpisodeModels.Episode;
import java.util.ArrayList;

public class RickAndMortySteps {
    private final RickAndMortyAPI rickAndMorty = new RickAndMortyAPI();

    public Root getCharacterForName(String name) {
        Root root = rickAndMorty.getCharacterForName(name)
                .statusCode(200)
                .extract()
                .body()
                .as(Root.class);
        return root;
    }

    public ArrayList<Character> popCharacterList(Root root){
        ArrayList<Character> list = new ArrayList<>();
        list.add(root.results.get(0));
        return list;
    }

    public Episode getEpisodeForLink(String url){
        Episode episode = rickAndMorty.getItemForURL(url)
                .statusCode(200)
                .extract()
                .body()
                .as(Episode.class);
        return episode;
    }

    public Character getCharacterForLink(String url){
        Character character = rickAndMorty.getItemForURL(url)
                .statusCode(200)
                .extract()
                .body()
                .as(Character.class);
        return character;
    }
}
