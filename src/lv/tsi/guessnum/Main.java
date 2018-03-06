package lv.tsi.guessnum;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        // example how to get current time
        long t = System.currentTimeMillis();
        System.out.println("Current time is " + t);
        // ---------
        ArrayList<GameResult> leaderboard = new ArrayList<>();
        try {
            String repeatAnswer;
            do {
                System.out.print("What is your name? ");
                String name = scanner.next();
                GameResult r = doGame(name);
                if (r != null) {
                    leaderboard.add(r);
                }
                System.out.print("Do you want to play once more? (yes / no): ");
                repeatAnswer = askYesOrNo();
            } while ("yes".equalsIgnoreCase(repeatAnswer));
        } catch (NoSuchElementException e) {
            System.out.println("User cancels the game");
        }
        for (GameResult r : leaderboard) {
            System.out.println(r.userName + "\t" + r.attempts);
        }
        System.out.println("Good bye!");
    }

    private static GameResult doGame(String userName) {
        int myNum = random.nextInt(100) + 1;

        System.out.println("Hello, " + userName);
        System.out.println("I'm thinking of number from 1 to 100. Try to guess it!");
        System.out.println("Spoiler: " + myNum);

        GameResult result = new GameResult();
        result.userName = userName;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Attempt " + i + ". Your guess: ");

            int userNum = askNumber();

            if (userNum > myNum) {
                System.out.println("Your number is greater than mine!");
            } else if (userNum < myNum) {
                System.out.println("Your number is less than mine!");
            } else {
                System.out.println("Congrats! You won in " + i + " attempts!");
                result.attempts = i;
                return result;
            }
        }
        System.out.println("Sorry, you lost, my friend! The number was " + myNum);
        return null;
    }

    static String askYesOrNo() {
        for (; ; ) {
            String answer = scanner.next();
            if ("yes".equalsIgnoreCase(answer) || "no".equalsIgnoreCase(answer)) {
                return answer;
            }
            System.out.print("Please enter yes or no: ");
        }
    }

    static int askNumber() {
        for (; ; ) {
            try {
                int num = scanner.nextInt();
                if (num <= 100 && num >= 1) {
                    return num;
                }
            } catch (InputMismatchException e) {
                System.out.println("oops! it should be a number!");
                scanner.next();
            } catch (NoSuchElementException e) {
                System.out.println("Hello");
                scanner.next();
            }
            System.out.print("Oh no! Wrong number. Try again:");
        }
    }

//    static int askNumber() {
//        int num;
//        do {
//            num = scanner.nextInt();
//            if (num > 100 || num < 1) {
//                System.out.print("Oh no! Wrong number. Try again:");
//            }
//        } while (num > 100 || num < 1);
//        return num;
//    }
}
