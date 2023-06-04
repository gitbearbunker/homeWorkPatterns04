package org.example.drinks;

import org.example.interfaces.*;

// O - принцип открытости/закрытости (Open Closed Principle) -
// Программные сущности должны быть открыты для расширения, но закрыты для
//модификации.

//I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
// Много интерфейсов, специально предназначенных для клиентов, лучше, чем один
// интерфейс общего назначения.

//D - принцип инверсии зависимостей (Dependency Inversion Principle)
// Всё зависит от абстракций (интерфейсов), а не от деталей реализации друг друга.

public class AlcoholicDrinks extends Drinks implements AlcoVerification, AgeVerification {
    public AlcoholicDrinks(String name, int price) {
        super(name, price);
    }

    @Override
    public void needToCheckForAlcoholContent() {
        System.out.println("Проверить напиток на содержание алкоголя");
    }

    @Override
    public void needToCheckTheAge () {
        System.out.println("Проверить напиток покупателя");
    }
}
