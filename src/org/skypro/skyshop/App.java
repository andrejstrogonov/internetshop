package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // создадим продукты
        Product product1 = new SimpleProduct("Молоко", 80);
        Product product2 = new SimpleProduct("Хлеб", 120);
        Product product3 = new SimpleProduct("Сыр", 420);
        Product product4 = new SimpleProduct("Масло", 400);
        Product product5 = new SimpleProduct("Яйца", 140);
        Product product6 = new SimpleProduct("Мясо", 900);
        Product product7 = new SimpleProduct("Бластер", 200);

        // создадим корзину
        var basket = new ProductBasket();

        // Добавление продукта в корзину.
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);


        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.add(product6);

        // Печать содержимого корзины с несколькими товарами.
        basket.print();

        // Получение стоимости корзины с несколькими товарами.
        int price = basket.getTotalPrice();
        System.out.println("Стоимость корзины с несколькими товарами: " + price);
        System.out.println("Итого: " + price);

        // Получение количества специальных товаров в корзине
        int specialProductCount = basket.getSpecialProductCount();
        System.out.println("Специальных товаров: " + specialProductCount);

        System.out.println();

        // Поиск товара, который есть в корзине.
        boolean exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);

        // Поиск товара, которого нет в корзине.
        exists = basket.contains(product7.getTitle());
        System.out.println("Товар " + product7.getTitle() + " есть в корзине: " + exists);

        System.out.println();

        // Очистка корзины.
        System.out.println("Очистка корзины...");
        basket.clear();
        System.out.println("Корзина очищена");
        System.out.println();

        // Печать содержимого пустой корзины.
        basket.print();

        // Получение стоимости пустой корзины.
        price = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + price);

        // Получение количества специальных товаров в корзине
        specialProductCount = basket.getSpecialProductCount();
        System.out.println("Специальных товаров в пустой корзине: " + specialProductCount);

        System.out.println();

        // Поиск товара по имени в пустой корзине.
        exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);
    }
}