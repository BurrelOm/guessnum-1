package lv.tsi.guessnum;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String repeatAnswer;
        do {
            int myNum = random.nextInt(100) + 1;

            System.out.println("I'm thinking of number from 1 to 100. Try to guess it!");
            System.out.println("Spoiler: " + myNum);

            for (int i = 1; i <= 10; i++) {
                System.out.print("Attempt " + i + ". Your guess: ");
                int userNum = scanner.nextInt();
                if (userNum > myNum) {
                    System.out.println("Your number is greater than mine!");
                } else if (userNum < myNum) {
                    System.out.println("Your number is less than mine!");
                } else {
                    System.out.println("Congrats! You won in " + i + " attempts!");
                    break;
                }
                if (i == 10) {
                    System.out.println("Sorry, you lost, my friend! The number was " + myNum);
                }
            }
            System.out.print("Do you want to play once more? (yes / no): ");
            repeatAnswer = scanner.next();
        } while ("yes".equals(repeatAnswer));

        System.out.println("Good bye!");
    }
}
