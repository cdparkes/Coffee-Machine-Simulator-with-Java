package machine;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean repeat = true;

        while (repeat) {
            repeat = coffeeMachine.mainMenu();
            System.out.println();
        }

    }
}
