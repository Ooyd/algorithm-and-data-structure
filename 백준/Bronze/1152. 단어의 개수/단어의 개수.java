import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine().trim();

        if (inputValue.isEmpty()) {
            System.out.println(0);
        } else {
            int wordCount = 1; 
            for (int i = 0; i < inputValue.length(); i++) {
                if (inputValue.charAt(i) == ' ') {
                    wordCount++; 
                }
            }
            System.out.println(wordCount);
        }
    }
}
