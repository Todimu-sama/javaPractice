package com.beginner.project;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// code to check if string contains same letters
        if (args.length == 0) {
            System.out.println("===================================================");
            System.out.println("Welcome to the word  comparing app !!!");
            System.out.println("Checks to see if words contain same string elements");
            System.out.println("===================================================");
            System.out.println("                                                   ");

            String runAgain = "y";
            while (runAgain.equals("y") || runAgain.equals("Y")) {
                // Get user inputs from terminal
                String[] userInputs = getUserInputs();

                // Remove all spaces in the user inputs
                String[] noSpaces = stringStripper(userInputs[0], userInputs[1]);

                // sort the input elements in alphabetical order
                String sortedInputOne = stringSorter(noSpaces[0]);
                String sortedInputTwo = stringSorter(noSpaces[1]);

                // Check to see if the inputs contain the same elements
                boolean containSameValues = wordCompare(sortedInputOne, sortedInputTwo);

                // displays the final output to the user
                resultOfApplication(userInputs[2], userInputs[3], containSameValues);

                System.out.println("Do yo want to check other words/phrases? (Y/N) :");
                Scanner scanner = new Scanner(System.in);
                runAgain = scanner.nextLine().toLowerCase();
            }
        } else if (args.length == 2) {
            handleCommandline(args); // running from the command line.
        } else {
            System.out.println("please provide two words separated by a space");
        }
    }

    private static void handleCommandline(String[] args) {
        String wordOne = args[0];
        String wordTwo = args[1];
        String wordOneLower = wordOne.toLowerCase();
        String wordTwoLower = wordTwo.toLowerCase();
        String[] noSpaces = stringStripper(wordOneLower, wordTwoLower);
        String sortedInputOne = stringSorter(noSpaces[0]);
        String sortedInputTwo = stringSorter(noSpaces[1]);
        boolean containSameValues = wordCompare(sortedInputOne, sortedInputTwo);
        resultOfApplication(wordOne, wordTwo, containSameValues);
    }

    private static String[] getUserInputs() {
        // Get the two words or phrases from the user
        String[] userInputs = new String[4];

        // Get first phrase
        System.out.println("Enter first word/phrase :");
        Scanner scannerOne = new Scanner(System.in);
        String firstInput = scannerOne.nextLine();
        String firstInputLower = firstInput.toLowerCase();

        // Get second phrase
        System.out.println("Enter second word/phrase :");
        Scanner scannerTwo = new Scanner(System.in);
        String secondInput = scannerTwo.nextLine();
        String secondInputLower = secondInput.toLowerCase();

        // Appending inputs to the string array
        userInputs[0] = firstInputLower;
        userInputs[1] = secondInputLower;
        userInputs[2] = firstInput;
        userInputs[3] = secondInput;

        return userInputs;
    }

    private static void resultOfApplication(String wordOne, String wordTwo, boolean result) {
        if (result) {
            String output = String.format("The strings '%s' and '%s' have the same characters ", wordOne, wordTwo);
            System.out.println(output);
        } else {
            String output;
            output = String.format("The strings '%s' and '%s' don't have the same characters ", wordOne, wordTwo);
            System.out.println(output);
        }
    }

    // compares two strings to see if they contain the same elements
    private static boolean wordCompare(String wordOne, String wordTwo) {
        boolean result = wordOne.equals(wordTwo);
        return result;
    }

    // method to strip all white spaces from strings
    public static String[] stringStripper(String stringOne, String stringTwo) {
        // removing all spaces from the strings, if any
        String noSpaceStringOne = stringOne.replaceAll("\\s", "");
        String noSpaceStringTwo = stringTwo.replaceAll("\\s", "");

        // creating an array so we can return on array value
        String[] noSpaceArray = new String[2];
        noSpaceArray[0] = noSpaceStringOne;
        noSpaceArray[1] = noSpaceStringTwo;

        return noSpaceArray;
    }

    // method to arrange all elements in a string alphabetically
    public static String stringSorter(String word) {
        char[] tempArray = word.toCharArray();
        Arrays.sort(tempArray);
        String sortedWord = new String(tempArray);

        return sortedWord;
    }
}
