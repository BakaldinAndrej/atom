import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    private static List<String> getWords(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException ex) {
            //logger.error(ex.getMessage(), ex);
        }
        return words;
    }

    public static void main(String[] args) {
        Logger log = LogManager.getLogger(Main.class);
        log.info("Logger work!");
        List<String> words = getWords("dictionary.txt");
        Game game = new Game(words);
        game.start();
    }
}