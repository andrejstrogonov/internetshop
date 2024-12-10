package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class SimpleProduct extends Product{
    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public SimpleProduct(@NotNull String title) {
        super(title);
    }

    @Override
    public @NotNull int getPrice() {
        return 0;
    }
}
