package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static final Scanner scanner = new Scanner(System.in);

    private int waterAmount = 400;
    private int milkAmount = 540;
    private int beanAmount = 120;
    private int cupAmount = 9;
    private int money = 550;
    private int counterToClean = 0;

    public void getInputAmounts() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", this.waterAmount, this.milkAmount, this.beanAmount, this.cupAmount, this.money);
    }

    public void buyCoffee(int waterAmount, int beanAmount, int money) {
        if(this.waterAmount >= waterAmount && this.beanAmount >= beanAmount && this.cupAmount > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            this.waterAmount = this.waterAmount - waterAmount;
            this.beanAmount = this.beanAmount - beanAmount;
            this.cupAmount--;
            this.counterToClean++;
            this.money = this.money + money;
        } else if (this.counterToClean >= 10) {
            System.out.println("I need cleaning");
        } else if(this.waterAmount < waterAmount) {
            System.out.println("Sorry, not enough water!");
        }  else if(this.beanAmount < beanAmount) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if(this.cupAmount == 0) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    public void buyCoffee(int waterAmount, int milkAmount, int beanAmount, int money) {
        if(this.waterAmount >= waterAmount && this.milkAmount >= milkAmount && this.beanAmount >= beanAmount && this.cupAmount > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            this.waterAmount = this.waterAmount - waterAmount;
            this.milkAmount = this.milkAmount - milkAmount;
            this.beanAmount = this.beanAmount - beanAmount;
            this.cupAmount--;
            this.counterToClean++;
            this.money = this.money + money;
        } else if (this.counterToClean >= 10) {
            System.out.println("I need cleaning");
        } else if(this.waterAmount < waterAmount) {
            System.out.println("Sorry, not enough water!");
        } else if(this.milkAmount < milkAmount) {
            System.out.println("Sorry, not enough milk!");
        } else if(this.beanAmount < beanAmount) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cupAmount == 0) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beanAmount = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int cupAmount = scanner.nextInt();
        this.waterAmount = this.waterAmount + waterAmount;
        this.milkAmount = this.milkAmount + milkAmount;
        this.beanAmount = this.beanAmount + beanAmount;
        this.cupAmount = this.cupAmount + cupAmount;
    }

    public void takeMoney() {
        System.out.printf("I gave you $%d%n", this.money);
        this.money = 0;
    }

    public boolean mainMenu() {
        Espresso espresso = new Espresso();
        Latte latte = new Latte();
        Cappuccino cappuccino = new Cappuccino();

        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
        String action = scanner.nextLine();

        System.out.println();
        switch (action) {
            case "buy" -> {
                if(this.counterToClean < 10) {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                    String coffeeChoice = scanner.nextLine();

                    switch (coffeeChoice) {
                        case "1" -> buyCoffee(espresso.getWATER(), espresso.getCOFFEE_BEANS(), espresso.getPRICE());
                        case "2" ->
                                buyCoffee(latte.getWATER(), latte.getMILK(), latte.getCOFFEE_BEANS(), latte.getPRICE());
                        case "3" ->
                                buyCoffee(cappuccino.getWATER(), cappuccino.getMILK(), cappuccino.getCOFFEE_BEANS(), cappuccino.getPRICE());
                        case "back" -> System.out.print("");
                        default -> System.err.println("Input not accepted. Please try again!");
                    }
                } else {
                    System.out.println("I need cleaning!");
                }
            }
            case "fill" -> fillMachine();
            case "take" -> takeMoney();
            case "clean" -> {
                System.out.println("I have been cleaned!");
                this.counterToClean = 0;
            }
            case "remaining" -> getInputAmounts();
            case "exit" -> {
                return false;
            }
        }
        return true;
    }


}