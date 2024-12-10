package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class SimpleProduct extends Product{
    private final int price;
    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public SimpleProduct(@NotNull String title, int price) {
        super(title);
        this.price = price;
    }

    @Override
    public @NotNull int getPrice() {
        return price;
    }
}
