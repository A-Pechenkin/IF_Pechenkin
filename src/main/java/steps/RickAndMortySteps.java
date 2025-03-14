package steps;

import api.rickandmorty.RickAndMortyApi;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RickAndMortySteps {

    private Response mortyResponse;
    private Response lastEpisodeResponse;
    private Response lastCharacterInEpisodeResponse;
    private Map<String, String> mortyInfo;
    private Map<String, String> lastCharacterInfo;

    @Дано("Получаем информацию о последнем эпизоде с Морти")
    public void get_last_morty_episode() {
        mortyResponse = RickAndMortyApi.getCharacterByName("Morty Smith");
        JsonPath jsonPath = mortyResponse.jsonPath();
        List<String> episodes = jsonPath.getList("results[0].episode");
        String lastEpisode = episodes.get(episodes.size() - 1);
        lastEpisodeResponse = RickAndMortyApi.getInfoAboutCharacter(lastEpisode);
    }

    @Когда("Получаем информацию о последнем персонаже из этого эпизода")
    public void get_last_character_from_episode() {
        JsonPath lastEpisodeJsonPath = lastEpisodeResponse.jsonPath();
        List<String> characters = lastEpisodeJsonPath.getList("characters");
        String lastCharacter = characters.get(characters.size() - 1);
        lastCharacterInEpisodeResponse = RickAndMortyApi.getInfoAboutCharacter(lastCharacter);
    }

    @И("Получаем информацию о Морти")
    public void get_morty_info() {
        JsonPath mortyJsonPath = mortyResponse.jsonPath();
        mortyInfo = new HashMap<>();
        mortyInfo.put("Раса", mortyJsonPath.getString("results[0].species"));
        mortyInfo.put("Местонахождение", mortyJsonPath.getString("results[0].location.name"));
    }

    @И("Получаем информацию о последнем персонаже")
    public void get_last_character_info() {
        JsonPath lastCharacterJsonPath = lastCharacterInEpisodeResponse.jsonPath();
        lastCharacterInfo = new HashMap<>();
        lastCharacterInfo.put("Раса", lastCharacterJsonPath.getString("species"));
        lastCharacterInfo.put("Местонахождение", lastCharacterJsonPath.getString("location.name"));
    }

    @Тогда("Проверяем совпадение расы и местоположения")
    public void check_races_and_locations() {
        checkAttribute("Раса", mortyInfo, lastCharacterInfo);
        checkAttribute("Местонахождение", mortyInfo, lastCharacterInfo);
    }

    private void checkAttribute(String attribute, Map<String, String> mortyInfo, Map<String, String> lastCharacterInfo) {
        String mortyValue = mortyInfo.get(attribute);
        String lastCharacterValue = lastCharacterInfo.get(attribute);

        if (mortyValue.equals(lastCharacterValue)) {
            Allure.step(attribute + " совпадает: " + mortyValue);
        } else {
            Allure.step(attribute + " не совпадает: Морти - " + mortyValue + ", Найденный персонаж - " + lastCharacterValue);
        }
    }
}