import java.util.Scanner;

public class Palindrome {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word or sentence : ");
        String word = sc.next();
        sc.close();  

        int i = 0, j = word.length() - 1;
        boolean isPalindrome = true;

        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        if (isPalindrome) {
            System.out.println("The given Word or a Sentence is a Palindrome!!");
        } else {
            System.out.println("The given Word or a Sentence is not a Palindrome!!");
        }
    }
}