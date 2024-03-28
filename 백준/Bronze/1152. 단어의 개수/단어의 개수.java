import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            int wordCount = 1; 
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    wordCount++; 
                }
            }
            System.out.println(wordCount);
        }

        scanner.close();
    }
}
