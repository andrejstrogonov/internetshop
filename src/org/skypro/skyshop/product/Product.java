package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public abstract class Product {
    /**
     * Название продукта.
     */
    @NotNull
    private final String title;

    /**
     * Цена продукта.
     */

    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public Product(@NotNull String title) {
        this.title = title;
    }

    /**
     * Получить название продукта.
     *
     * @return название продукта.
     */
    @NotNull
    public String getTitle() {
        return title;
    }

    /**
     * Получить цену продукта.
     *
     * @return цена продукта.
     */
}
