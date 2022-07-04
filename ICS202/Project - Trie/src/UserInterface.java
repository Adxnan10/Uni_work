import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Trie dictionary = new Trie();
        Scanner input = new Scanner(System.in);
        showMenu();
        String userInput = input.nextLine();
        while (!userInput.equals("7")) {
            switch (userInput) {
                case "1" -> {
                    dictionary = new Trie();
                    System.out.println("An empty trie was created successfully.");
                    showMenu();
                    userInput = input.nextLine();
                }
                case "2" -> {
                    System.out.println("Enter your list of letters: ");
                    String letters = input.nextLine().replace(" ", "");
                    if (letters.matches("[A-Z]*")) {
                        dictionary.clear(); // this is here so that if the user enters an invalid letters, the previous trie does not get cleared.
                        String[] listOfLetters = letters.split("");
                        try {
                            ArrayList<String> wordsToInsert = fetchDictionary(listOfLetters);
                            for (String word: wordsToInsert) {
                                dictionary.insert(word);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("The Path of the dictionary is wrong. Please correct the path then run the program again. ");
                        }
                    } else {
                        System.out.println("You entered an invalid letter. Please make sure all letters are alphabetic and in UPPERCASE. ");
                    }
                    showMenu();
                    userInput = input.nextLine();
                }
                case "3" -> {
                    System.out.println("Enter a word to insert: ");
                    String insertedWord = input.nextLine();
                    dictionary.insert(insertedWord);
                    showMenu();
                    userInput = input.nextLine();
                }
                case "4" -> {
                    System.out.println("Enter a word to Delete: ");
                    String deletedWord = input.nextLine();
                    dictionary.delete(deletedWord);
                    showMenu();
                    userInput = input.nextLine();
                }
                case "5" -> {
                    System.out.println("Enter a prefix: ");
                    String prefix = input.nextLine();
                    if (prefix.matches("[A-Z]*")) {
                        String[] words = dictionary.allWordsPrefix(prefix);
                        if (words != null) {
                            for (String word : words) {
                                System.out.print(word + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid Input. Please make sure all letters are alphabetic and in UPPERCASE. ");
                    }
                    showMenu();
                    userInput = input.nextLine();
                }
                case "6" -> {
                    int trieSize = dictionary.size();
                    System.out.println("Size = " + trieSize);
                    showMenu();
                    userInput = input.nextLine();
                }
                default -> {
                    System.out.println("Please choose a valid number: ");
                    showMenu();
                    userInput = input.nextLine();
                }
            }
        }

        System.out.println("======== See you later :) ========");
    }
    public static void showMenu() {
        System.out.println("""
                TRIE PROJECT: Enter your choice?
                1) Create an empty trie
                2) Create a trie with initial letters
                3) Insert a word
                4) Delete a word
                5) List all words that begin with a prefix
                6) Size of the trie
                7) End"""
        );
    }
    public static ArrayList<String> fetchDictionary(String[] letters) throws FileNotFoundException {

        // Prepare the file for reading
        File dictionaryFile = new File("dictionary.txt");
        Scanner input = new Scanner(dictionaryFile);

        ArrayList<String> matchedWords = new ArrayList<>();

        // for each word in the file, check that its length is less than the number of letters and
        while(input.hasNextLine()) {
            ArrayList<String> lettersAsList = new ArrayList<>(Arrays.asList(letters));
            String word = input.nextLine();
            int wordLength = word.length();
            boolean flag = false;


            if(wordLength <= lettersAsList.size()) {
                for(int i = 0; i < wordLength; i++) {
                    flag = false;
                    for(int j = 0; j < lettersAsList.size(); j++) {
                        if((word.charAt(i)+"").equals(lettersAsList.get(j).toUpperCase())) {
                            flag = true;
                            lettersAsList.remove(j);
                            break;
                        }
                    }
                    if(!flag)
                        break;
                }
                if(flag)
                    matchedWords.add(word);
            }
        }
        return matchedWords;
    }
}
