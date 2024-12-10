package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class SimpleProduct extends Product{
    private final int PRICE;
    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public SimpleProduct(@NotNull String title, int PRICE) {
        super(title);
        this.PRICE = PRICE;
    }

    @Override
    public @NotNull int getPrice() {
        return PRICE;
    }
}
