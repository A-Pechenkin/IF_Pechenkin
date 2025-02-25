package api.rickandmorty;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RickAndMortyApi {


    private static final String BASE_URI = "https://rickandmortyapi.com/api";

    public static Response getCharacterByName(String name) {
        return RestAssured
                .given()
                .baseUri(BASE_URI)
                .param("name", name)
                .get("/character");
    }

    public static Response getEpisode(String url) {
        return RestAssured
                .given()
                .get(url);
    }

    public static Response getCharacter(String url) {
        return RestAssured
                .given()
                .get(url);
    }
}