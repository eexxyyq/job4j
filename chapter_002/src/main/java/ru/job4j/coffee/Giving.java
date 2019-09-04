package ru.job4j.coffee;


import java.util.Scanner;

public class Giving implements GivingCoins {
    private static final int[] GIVING_COINS = new int[] {10, 5, 2, 1};
    private int value;
    private int price;

    Giving(int value, int price) {
        while (value < price) {
            System.out.println("Give me more!");
            Scanner scanner = new Scanner(System.in);
            int dop = scanner.nextInt();
            value += dop;
        }
        this.value = value;
        this.price = price;
    }

    @Override
    public void changes() {
        int[] result = forChanges(value, price);
        if (result.length != 0) {
            System.out.println("Your giving is: ");
            for (int i : result) {
                System.out.format("%d$ ", i);
            }
            System.out.println("\nYou're WELCOME!");
        } else {
            System.out.println("Pay without giving. You're WELCOME!");
        }
    }

    private int[] forChanges(int value , int price) {
        int change = value - price;
        int count = 0;
        int[] tmp = new int[change];
        for (int givingCoin : GIVING_COINS) {
            while (change >= givingCoin) {
                change -= givingCoin;
                tmp[count++] = givingCoin;
            }
            if (change == 0) {
                break;
            }
        }
        int[] result = new int[count];
        System.arraycopy(tmp, 0, result, 0, count);
        return result;
    }
}