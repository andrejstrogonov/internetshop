package org.skypro.skyshop.basket;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> basket;

    /**
     * Конструктор.
     */
    public ProductBasket() {
        basket = new HashMap<>();
        clear();
        // Сейчас не нужна упорядоченность товаров в корзине - важны
        // только базовые операции. Поэтому достаточно HashMap.
    }

    /**
     * Очистка корзины.
     */
    public void clear() {
        basket.clear();
    }

    /**
     * Добавление товара в корзину.
     *
     * @param product добавляемый товар
     */
    public void add(@NotNull Product product) {
        // готовим ссылку на ассоциированный список продуктов
        List<Product> products;

        // если в корзине нет такого товара, то создаем список
        if (!basket.containsKey(product.getTitle())) {
            products = new LinkedList<>();
            basket.put(product.getTitle(), products);
        } else {
            // иначе получаем ссылку на список
            products = basket.get(product.getTitle());
        }

        // добавляем товар в список
        products.add(product);
    }

    /**
     * Удаление товара из корзины.
     *
     * @param title наименование удаляемого товара
     */
    @NotNull
    public List<Product> remove(@NotNull String title) {
        List<Product> removed = new LinkedList<>();
        if (basket.isEmpty()) {
            return removed;
        }

        if (basket.containsKey(title)) {
            removed = basket.remove(title);
        }
        return removed;
    }

    /**
     * Получение общей стоимости корзины.
     *
     * @return общая стоимость корзины
     */
    public int getTotalPrice() {
        return basket.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    /**
     * Получение количества специальных товаров в корзине.
     *
     * @return количество специальных товаров в корзине
     */
    public int getSpecialProductCount() {
        return basket.values().stream()
                .flatMap(List::stream)
                .filter(product -> product instanceof DiscountedProduct)
                .mapToInt(product -> 1)
                .sum();
    }

    /**
     * Получение общего количества товаров в корзине.
     *
     * @return общее количество товаров в корзине
     */
    @SuppressWarnings("unused")
    private int getProductCount() {
        return (int) basket.values().stream()
                .flatMap(Collection::stream)
                .count();
    }

    /**
     * Печать корзины.
     */
    public void print() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        basket.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }
}