package org.example;

import org.example.drinks.*;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    private static void printProducts(Drinks[] products) {
        System.out.println("Список возможных напитков для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    private static void printBasket(Drinks[] products, int[] count) {
        System.out.println("Напитки в Вашей корзине: ");
        int totalSum = 0;
        for (int i = 0; i < products.length; i++) {
            if (count[i] != 0) {
                int sum = count[i] * products[i].getPrice();
                System.out.println((i + 1) + ". " + products[i] + " - " + count[i] + " шт., стоимость: " + sum + " руб.");
                totalSum += sum;
            }
        }
        System.out.println("Итого: " + totalSum + " руб.");
    }

    public static void main(String[] args) {

// L - принцип замены Барбары Лисков (Liskov Substitution Principle)
// Наследуй только тогда, когда можешь играть роль за предка

        Drinks[] products = {new AlcoholicDrinks("Вино", 1200), new AlcoholicDrinks("Водка", 650), new AlcoholicDrinks("Пиво", 150), new NonAlcoholicDrinks("Кока-кола", 160), new NonAlcoholicDrinks("Холодный чай", 120), new NonAlcoholicDrinks("Ситро", 80),};

// Правило Magic: не используй числа напрямую в коде

        int[] count = new int[products.length];

// Правило DRY (Don’t Repeat Yourself): не повторяй свой код

        printProducts(products);

        while (true) {
            System.out.println("Выберите напиток из списка и его количество или введите \"end\" для завершения");

            String input = in.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);

            count[productNumber] += productCount;
        }

        printBasket(products, count);

    }
}