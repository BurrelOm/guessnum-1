package lv.tsi.guessnum;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int myNum = random.nextInt(100) + 1;

        System.out.println("I'm thinking of number from 1 to 100. Try to guess it!");
        System.out.println("Spoiler: " + myNum);

        System.out.print("Your guess:");
        int userNum = scanner.nextInt();

    }
}
