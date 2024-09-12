import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int difficulty;
    private List<String> colours;
    private List<String> shuffeledColoursList;

    public Game(int _difficulty, List<String> _colours){
        difficulty = _difficulty;
        colours = _colours;
        generatePreDeterminedColours();
    }

    private void generatePreDeterminedColours(){
        shuffeledColoursList = new ArrayList<String>(difficulty);
        shuffeledColoursList = colours;
        Collections.shuffle(shuffeledColoursList);
    }

    public void PlayGame(Scanner sc){
        int guesses = 0;
        int retries = 0;
        List<String> userGuessedColours = new ArrayList<>(difficulty);

        while(guesses != difficulty && retries < 10){
            guesses = 0;
            userGuessedColours.clear();
            for(int i = 0; i < difficulty; i++){
                System.out.println("Please enter Colour " +i);
                userGuessedColours.add(sc.nextLine());
            }

            guesses = GetGuessedColours(userGuessedColours);
            System.out.println("You have guessed  " +guesses + " in their position");
            System.out.println(10 - retries + " retries remaining");
            retries ++;
        }
    }

    public int GetGuessedColours(List<String> userGuessedColoursList){
        int guessedColoursInTheirPositions = 0;

        for (int i=0; i < userGuessedColoursList.size(); i++){
            if(shuffeledColoursList.get(i).equals(userGuessedColoursList.get(i))){
                guessedColoursInTheirPositions ++;
            }
        }
        return guessedColoursInTheirPositions;
    }
}
