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
        List<String> userGuessedColours = new ArrayList<>(difficulty);

        while(guesses != difficulty){
            for(int i = 0; i < difficulty; i++){
                System.out.println("Please enter Colour " +i);
                userGuessedColours.add(sc.nextLine());
            }

            guesses = GetGuessedColours(userGuessedColours);
            System.out.println("You have guessed  " +guesses + " in their position");
        }
    }

    public int GetGuessedColours(List<String> userGuessedColoursList){
        int guessedColoursInTheirPositions = 0;

        for (int i=0; i < userGuessedColoursList.size(); i++){
            for(int j = 0; j<shuffeledColoursList.size(); j++){
                if(shuffeledColoursList.get(j).equals(userGuessedColoursList.get(i))){
                    guessedColoursInTheirPositions ++;
                }
            }
        }
        return guessedColoursInTheirPositions;
    }
}
