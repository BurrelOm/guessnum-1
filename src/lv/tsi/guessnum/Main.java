package lv.tsi.guessnum;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random random = new Random();
        String repeatAnswer;
        do {
            int myNum = random.nextInt(100) + 1;

            System.out.println("I'm thinking of number from 1 to 100. Try to guess it!");
            System.out.println("Spoiler: " + myNum);

            boolean userLost = true;
            for (int i = 1; i <= 10; i++) {
                System.out.print("Attempt " + i + ". Your guess: ");
                int userNum = askNumber();
                if (userNum > myNum) {
                    System.out.println("Your number is greater than mine!");
                } else if (userNum < myNum) {
                    System.out.println("Your number is less than mine!");
                } else {
                    System.out.println("Congrats! You won in " + i + " attempts!");
                    userLost = false;
                    break;
                }
            }
            if (userLost) {
                System.out.println("Sorry, you lost, my friend! The number was " + myNum);
            }
            System.out.print("Do you want to play once more? (yes / no): ");
            repeatAnswer = scanner.next();
        } while ("yes".equals(repeatAnswer));

        System.out.println("Good bye!");
    }

    static int askNumber() {
        for (; ; ) {
            try {
                int num = scanner.nextInt();
                if (num >= 1 && num <= 100) {
                    return num;
                }
                System.out.print("Wrong number! It should be a number between 1 and 100. Try again: ");
            } catch (InputMismatchException e) {
                System.out.print("Wrong input! It should be a number! Try again: ");
                scanner.next();
            }
        }
    }
}
