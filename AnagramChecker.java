import java.util.Scanner;

public class AnagramChecker {

    static char[] sortArray(char[] chars) {
        // Manual Bubble Sort to avoid built in methods
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        char[] word1 = scanner.next().toLowerCase().toCharArray();

        System.out.print("Enter second string: ");
        char[] word2 = scanner.next().toLowerCase().toCharArray();

        // If lengths are different, they cannot be anagrams
        if (word1.length != word2.length) {
            System.out.println("NO");
            return;
        }

        sortArray(word1);
        sortArray(word2);

        // Compare each character
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        scanner.close();
    }
}