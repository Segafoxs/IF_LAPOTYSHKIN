package ru.iFellow.steps;
import ru.iFellow.API.rickAndMorty.RickAndMortyAPI;
import ru.iFellow.models.CharacterModels.Character;
import ru.iFellow.models.CharacterModels.Root;
import java.util.ArrayList;

public class RickAndMortySteps {
    private final RickAndMortyAPI rickAndMorty = new RickAndMortyAPI();

    public Root getCharacterForName(String name) {
        Root root = rickAndMorty.getCharacterForName(name)
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

    public <T> T getItemForLink(String url, Class<T> tClass) {
        return rickAndMorty.getItemForURL(url)
                .extract()
                .body()
                .as(tClass);
    }
}
