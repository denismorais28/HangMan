
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */

public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        //catch our txt file

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1 or 2 players?");
        String players = keyboard.nextLine();
        String word;

        if (players.equals("1")) {
            Scanner scanner = new Scanner(new File("C:\\Users\\denis\\OneDrive\\Documentos\\NetBeansProjects\\words_alpha.txt"));

            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                words.add(scanner.nextLine()); //to add a word to our list
            }
            
            Random rand = new Random();

            //this function is used to get a random word
            word = words.get(rand.nextInt(words.size()));
            }else{
                System.out.println("Player 1, please enter your word: ");
                word = keyboard.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Ready for player 2! Good luck!");
                       

        }

        //System.out.println(word); this fuction will give the correct word 

        List<Character> playerGuesses = new ArrayList<>();

        int wrongCount = 0;
        while (true) {

            printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
                break;
            }

            printWordState(word, playerGuesses);
            if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                wrongCount++;
            }

            if (printWordState(word, playerGuesses)) {
                break;
            }

            System.out.println("Please enter your guess for the word: ");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("You win");
                break;
            } else {
                System.out.println("Nope! Try again");
            }
        }

    }

    //to create the methods after made the whole function must click Alt + Shift + M and insert the name of the method into the box
    private static void printHangedMan(int wrongCount) {
        System.out.println(" --------");
        System.out.println(" |      |");
        if (wrongCount >= 1) {
            System.out.println("  o");
        }
        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println(" /");

            }
            if (wrongCount >= 4) {
                System.out.println(" |");
            }
            if (wrongCount >= 5) {
                System.out.print("/ ");
                if (wrongCount >= 6) {
                    System.out.println("\\");

                }
            } else {
                System.out.println("");
                System.out.println("");
            }
        }
    }

    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    //gonna return a boolean value not void here
    private static boolean printWordState(String word, List<Character> playerGuesses) {
        //loup
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }

}
