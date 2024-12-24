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
        if (PRICE <= 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной или быть равной нулю");
        }
        this.PRICE = PRICE;
    }

    @Override
    public @NotNull int getPrice() {
        return PRICE;
    }
    @Override
    public String toString() {
        return getTitle() + ": " + getPrice();
    }
}
