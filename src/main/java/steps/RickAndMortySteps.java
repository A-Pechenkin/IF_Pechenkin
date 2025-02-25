package steps;

import api.rickandmorty.RickAndMortyApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RickAndMortySteps {

    private Response mortyResponse;
    private Response lastEpisodeResponse;
    private Response lastCharacterInEpisodeResponse;

    public String getLastMortyEpisode() {
        mortyResponse = RickAndMortyApi.getCharacterByName("Morty Smith");
        JsonPath jsonPath = mortyResponse.jsonPath();
        List<String> episodes = jsonPath.getList("results[0].episode");
        return episodes.get(episodes.size() - 1);
    }

    public String getLastCharacterFromEpisode(String episode) {
        lastEpisodeResponse = RickAndMortyApi.getEpisode(episode);
        JsonPath lastEpisodeJsonPath = lastEpisodeResponse.jsonPath();
        List<String> characters = lastEpisodeJsonPath.getList("characters");
        return characters.get(characters.size() - 1);
    }

    public Map<String, String> getLastCharacterInfo(String character) {
        lastCharacterInEpisodeResponse = RickAndMortyApi.getCharacter(character);
        JsonPath lastCharacterJsonPath = lastCharacterInEpisodeResponse.jsonPath();
        Map<String, String> characterInfo = new HashMap<>();
        characterInfo.put("race", lastCharacterJsonPath.getString("species"));
        characterInfo.put("location", lastCharacterJsonPath.getString("location.name"));
        return characterInfo;
    }

    public Map<String, String> getMortyInfo() {
        JsonPath mortyJsonPath = mortyResponse.jsonPath();
        Map<String, String> mortyInfo = new HashMap<>();
        mortyInfo.put("race", mortyJsonPath.getString("results[0].species"));
        mortyInfo.put("location", mortyJsonPath.getString("results[0].location.name"));
        return mortyInfo;
    }

    public void checkRacesAndLocations(Map<String, String> mortyInfo, Map<String, String> lastCharacterInfo) {
        if (mortyInfo.get("race").equals(lastCharacterInfo.get("race"))) {
            System.out.println("Раса совпадает.");
        } else {
            System.out.println("Раса не совпадает.");
        }

        if (mortyInfo.get("location").equals(lastCharacterInfo.get("location"))) {
            System.out.println("Местоположение совпадает.");
        } else {
            System.out.println("Местоположение не совпадает.");
        }
    }
}