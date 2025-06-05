package ru.iFellow.steps.RickAndMorty;
import io.qameta.allure.Step;
import ru.iFellow.API.rickAndMorty.RickAndMortyAPI;
import ru.iFellow.dto.CharacterModels.Character;
import ru.iFellow.dto.CharacterModels.Root;
import java.util.ArrayList;

public class RickAndMortySteps {
    private final RickAndMortyAPI rickAndMorty = new RickAndMortyAPI();

    @Step("Ищем персонажа по имени {name}")
    public Root getCharacterForName(String name) {
        Root root = rickAndMorty.getCharacterForName(name)
                .extract()
                .body()
                .as(Root.class);
        return root;
    }

    @Step("Формируем информацию о персонаже в список")
    public ArrayList<Character> popCharacterList(Root root){
        ArrayList<Character> list = new ArrayList<>();
        list.add(root.results.get(0));
        return list;
    }

    @Step("Получение информации о эпизоде, либо персонаже по ссылке")
    public <T> T getItemForLink(String url, Class<T> tClass) {
        return rickAndMorty.getItemForURL(url)
                .extract()
                .body()
                .as(tClass);
    }
}
