import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    //рандом
    private static final Random random = new Random();
    //словарь
    private List<String> words;
    //загаданное слово
    public String word;

    //инициализация игры со словарем
    public Game(List<String> words) {
        this.words = words;
    }

    //выбор загаданного слова
    private String chooseSecretWord() {
        return words.get(random.nextInt(words.size()));
    }

    //загадать слово
    public void SetSecretWord (String word){
        this.word = word;
    }

    //расчет быков
    public int calcBulls(String analiseWord) {
        int bulls = 0;
        for (int i = 0; i < analiseWord.length(); i++) {
            if (analiseWord.charAt(i) == word.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    //расчет коров
    public int calcCows(String analiseWord) {
        int cows = 0;
        for (int i = 0; i < analiseWord.length(); i++) {
            int pos = word.indexOf(analiseWord.charAt(i));
            if (pos != -1)
                cows++;
        }
        return cows;
    }

    //старт игры
    public void start() {
        System.out.println("Здравствуйте!");
        String playAgain = "Yes";
        Scanner scanner = new Scanner(System.in);
        do {
            word = chooseSecretWord();
            System.out.println("Я загадал " + word.length() + "-буквенное слово. Отгадывайте.");
            playRound(scanner);
            System.out.println("Хотите сыграть еще? Yes/No");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("Yes"));
    }

    //один круг
    private void playRound(Scanner scanner) {
        int losses = 0;
        while (losses < 15) {
            String guess = scanner.next();
            if (guess.length() != word.length()) {
                System.out.println("Неверная длина слова.");
                continue;
            }
            if (guess.equals(word)) {
                System.out.println("Вы выйграли!");
                return;
            }
            System.out.println("Тестовое слово - " + word);
            System.out.println("Быки: " + calcBulls(guess));
            System.out.println("Коровы: " + calcCows(guess));
            losses++;
        }
        System.out.println("Вы проиграли");
    }


}