import org.junit.jupiter.api.Test;
import steps.RickAndMortySteps;

import java.util.Map;

public class RickAndMortyTest {

    @Test
    public void testMortyAndLastCharacter() {
        RickAndMortySteps steps = new RickAndMortySteps();

        String lastEpisode = steps.getLastMortyEpisode();
        String lastCharacter = steps.getLastCharacterFromEpisode(lastEpisode);

        Map<String, String> mortyInfo = steps.getMortyInfo();
        Map<String, String> lastCharacterInfo = steps.getLastCharacterInfo(lastCharacter);

        steps.checkRacesAndLocations(mortyInfo, lastCharacterInfo);
    }
}