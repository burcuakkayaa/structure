import dataStructure.CharactersInPlay;
import org.testng.annotations.Test;

public class CharacterInPlayTest {

    @Test
    void CharacterTest() {
        CharactersInPlay charactersInPlay = new CharactersInPlay("/Users/burcuakkaya/Downloads/likeit.txt");
        charactersInPlay.findAllCharacters();
    }
}
