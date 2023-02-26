import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class projectZero {
    public static void main(String[] args) throws FileNotFoundException{

        Scanner scnr = new Scanner(new File("text.txt"));
        String words[] = new String[10000];
        
        //store words in text.txt file in variable then read them to user.
        String line = scnr.nextLine();
        words = line.split(" ");
        System.out.println("Unsorted List... " + line);
      
        //using bubbleSort method, the words are now in order and are read back to the user.
        String[] sortedWords = bubbleSort(words);
        System.out.print("After sorting... ");
        for(int i = 0; i < sortedWords.length; i++){
            System.out.print(sortedWords[i] + " ");
        }
        System.out.println();
        
        //prompts user to enter a word and will tell user if that word is in the sorted array. The user may end the program when they press 0.
        Scanner scnr2 = new Scanner(System.in);
        System.out.println("Enter words to search for...enter 0 to quit.");
        String str = scnr2.nextLine();
        while(!str.equals("0")){
            int result = binarySearch(sortedWords, str);
            if (result == -1) {
                System.out.println(str + " is not in the list");
            } else {
                System.out.println(str + " is in the list at index " + result);
            }
            str = scnr2.nextLine();
        }
       
    }

    //takes an array of Strings and sorts them by comparing them lexicographically 
    public static String[] bubbleSort(String[] words){
        String temp;
        for(int j = 0; j < words.length; j++){
            for(int i = j + 1; i < words.length; i++){
                if(words[i].compareTo(words[j]) < 0){
                    temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }
        return words;
    }

    //allows the user to enter a string and responds to the user telling them if their string is in the sorted array or not
    public static int binarySearch(String[] words, String word){
        int l = 0, r = words.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = word.compareTo(words[m]);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        return -1;
    }
}