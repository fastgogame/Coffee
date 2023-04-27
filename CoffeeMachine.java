package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scn = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int coffee = 120;
    private static int cups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        while (true){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scn.next();
            if (action.equals("exit")) {
                break;
            }
            menu(action);
        }
    }

    private static void menu(String action){
        switch (action) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            default -> System.out.println("Unknown command");
        }
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int w = scn.nextInt();
        water += w;
        System.out.println("Write how many ml of milk you want to add:");
        int m = scn.nextInt();
        milk += m;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int f = scn.nextInt();
        coffee += f;
        System.out.println("Write how many disposable cups you want to add:");
        int c = scn.nextInt();
        cups += c;
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String cofType = scn.next();
        switch (cofType) {
            case "1" -> {
                if (water >= 250 && coffee >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffee -= 16;
                    money += 4;
                    cups -= 1;
                } else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
            case "2" -> {
                if (water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1){
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    money += 7;
                    cups -= 1;
                } else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffee < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
            case "3" -> {
                if (water >= 200 && milk >= 100 && coffee >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    money += 6;
                    cups -= 1;
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffee < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
            case "back" -> {
                System.out.println("Returning to main menu");
            }
            default -> {
                System.out.println("Unknown cofType");
            }
        }
    }

    private static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
