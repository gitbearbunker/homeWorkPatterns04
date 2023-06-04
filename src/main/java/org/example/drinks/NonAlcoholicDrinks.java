package org.example.drinks;

import org.example.interfaces.*;

// O - принцип открытости/закрытости (Open Closed Principle) -
// Программные сущности должны быть открыты для расширения, но закрыты для
//модификации.

public class NonAlcoholicDrinks extends Drinks implements AlcoVerification {
    public NonAlcoholicDrinks(String name, int price) {
        super(name, price);
    }

    @Override
    public void needToCheckForAlcoholContent() {
        System.out.println("Проверить товар на содержание алкоголя");
    }
}