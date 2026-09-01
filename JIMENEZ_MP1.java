import java.util.*;

public class JIMENEZ_MP1 {
    static Scanner read = new Scanner (System.in);

    public static void main (String[] args) {
        // Initialization of string array containing the string manipulation tools
        String[] arrTools = {
            "String Reversal",  
            "Palindrome Checker",
            "Anagram Checker",
            "Word Count",
            "Character Count",
            "Substring Finder",
            "Lower Case Converter",
            "Upper Case Converter",
            "Vowel Remover",
            "Consonant Remover"
        };

        System.out.println("String Manipulation Toolkit");
        System.out.println("Kindly choose a tool from the selection:");

        // Displays the menu for string manipulation tools
        for (int i = 0; i < arrTools.length; i++) {
            System.out.println((i + 1) + ". " + arrTools[i]);
        }

        // Asking the user to choose a tool
        System.out.print("\nEnter your chosen tool(1-10): ");
        int intMenu = read.nextInt();
        read.nextLine(); // Consumes the newline character

        // Condition to validate user input
        if (intMenu < 1 || intMenu > 10) {
            System.out.println("Invalid input. Choose from the options only.\nExiting...");
            return;
        }

        // Asking the user to enter a string
        System.out.print("Enter string with three(3) sentences: ");
        String strUserInput = read.nextLine();

        switch (intMenu) {
        case 1:
            // Calls the method 'stringReverse' directly to display result
            System.out.println("\nBefore reversing: " + strUserInput);
            System.out.println("After reversing: " + stringReverse(strUserInput));
            break;
        case 2:
            // Calls the method 'checkPalindrome' directly to store its result to variable
            boolean blnPalindrome = checkPalindrome(strUserInput); 

            // Displays palindrome status based on the boolean variable
            if (blnPalindrome) {
                System.out.println("A palindome");
            } else {
                System.out.println("Not palindrome");
            }
            break;
        case 3:
            // Asking the user to enter another string for anagram checking
            System.out.print("Enter another string: ");
            String strUserInput2 = read.nextLine();

            // Calls the method 'checkAnagram' directly to store its result to variable
            boolean blnAnagram = checkAnagram(strUserInput, strUserInput2);

            // Displays anagram status based on the boolean variable
            if (blnAnagram) {
                System.out.println("Two strings are anagrams");
            } else {
                System.out.println("Two strings are not anagrams");
            }
            break;
        case 4: 
            // Calls the method 'wordCounter' directly to display result
            System.out.println("Number of words: " + wordCounter(strUserInput));
            break;
        case 5:
            // Calls the method 'charCounter' directly to display result
            System.out.println("Number of characters excluding spaces: " + charCounter(strUserInput)); 
            break;
        case 6: 
            // Asking the user to enter substring 
            System.out.print("Enter substring to find: ");
            String strSub = read.nextLine();

            // Calls the method 'findSubOccur' directly to display result
            System.out.println("Number of entered substring occurence: " + findSubOccur(strUserInput, strSub));
            break;
        case 7:
            // Calls the method 'makeItLow' directly to display result
            System.out.println("After converting to lower case: " + makeItLow(strUserInput));
            break;
        case 8: 
            // Calls the method 'makeItUp' directly to display result
            System.out.println("After converting to upper case: " + makeItUp(strUserInput));
            break;
        case 9:
            // Calls the method 'removeVowel' directly to display result
            System.out.println("After removing the vowels: " + removeVowel(strUserInput));
            break;
        case 10:
            // Calls the method 'removeConsonant' directly to display result
            System.out.println("After removing the consonants: " + removeConsonant(strUserInput)); 
            break;
        }
    }

    // Method for string reversal
    public static String stringReverse(String strUserString) {
        // Converts the input string to character array
        char[] arrUserInput = strUserString.toCharArray();
        // Creates an array to get the array length and store the reversed string
        char[] arrReversedString = new char[arrUserInput.length]; 

        // Reverses the array
        for (int i = 0; i < arrUserInput.length; i++) {
            arrReversedString[i] = arrUserInput[arrUserInput.length - 1 - i];
        } 

        // Converts the reversed char array to a string and returns it
        return new String(arrReversedString);
    }

    // Method for palindrome checker
    public static boolean checkPalindrome(String strUserString) {
        // Converts the input string to lowercase and removes all non-alphanumeric chars
        String strAlphaNumeric = strUserString.replaceAll("[^a-zA-z0-9]", "").toLowerCase();

        // Reverses the alphanumeric string by calling the method 'stringReverse'
        String strReversedString = stringReverse(strAlphaNumeric);

        // Checks if the original and reversed string are equal then returns its value 
        return strAlphaNumeric.equals(strReversedString);
    }

    // Method for anagram checker
    public static boolean checkAnagram(String strUserInput, String strUserInput2) {
        // Removes non-alphanumeric chars, and converts to lowercase and to character array for both input strings
        char[] arrUserInput = strUserInput.replaceAll("[^a-zA-z0-9]", "").toLowerCase().toCharArray();
        char[] arrUserInput2 = strUserInput2.replaceAll("[^a-zA-z0-9]", "").toLowerCase().toCharArray();

        // Sorts the character arrays
        Arrays.sort(arrUserInput);
        Arrays.sort(arrUserInput2);

        // Checks if the sorted arrays are equal then returns its value
        return Arrays.equals(arrUserInput, arrUserInput2);
    }

    // Method for word count
    public static int wordCounter(String strUserString) {
        // Splits the input string into an array of words based on whitespace
        String[] arrWords = strUserString.split("\\s+");

        // Returns the count of words in the array
        return arrWords.length;
    }

    // Method for character count
    public static int charCounter(String strUserString) {
        // Removes whitespaces from the input string
        String strNoSpace = strUserString.replaceAll("\\s", "");

        // Returns the count of characters in the modified string
        return strNoSpace.length();
    }

    // Method for substring finder
    public static int findSubOccur(String strUserString, String strUserSub) {
        // Initialization of variables for count and starting index
        int intCount = 0, intIndex = -1;

        // Iterates through the string to find substring occurrences
        while ((intIndex = strUserString.indexOf(strUserSub, intIndex + 1)) != -1) {
            intCount++;
        }

        // Returns the count of substring occurence
        return intCount;
    }

    // Method for lower case converter
    public static String makeItLow(String strUserString) {
        // Returns the input string converted to lowercase
        return strUserString.toLowerCase();
    }

    // Method for upper case converter
    public static String makeItUp(String strUserString) {
        // Returns the input string converted to uppercase
        return strUserString.toUpperCase();
    }

    // Method for vowel remover
    public static String removeVowel(String strUserString) {
        // Removes vowels from the input string and returns it
        return strUserString.replaceAll("[aeiouAEIOU]", "");
    }

    // Method for consonant remover
    public static String removeConsonant(String strUserString) {
        // Removes consonants from the input string and returns it
        return strUserString.replaceAll("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]", "");
    }
}