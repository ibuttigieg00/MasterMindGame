import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("----- WELCOME AND HELLO TO -----");
        System.out.println("----- MASTERMIND -----");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter game difficulty");
        int difficulty = sc.nextInt();

        List<String> colours = new ArrayList<>(difficulty);

        for(int i = 0; i < difficulty; i++){
            System.out.println("Please enter Colour " +i);
            if (i == 0) {
                sc.nextLine();
            }
            String colour = sc.nextLine();
            colours.add(colour);
        }

        Game game1 = new Game(difficulty, colours);

        System.out.println("--- Game will start now ---");
        game1.PlayGame(sc);
    }
}