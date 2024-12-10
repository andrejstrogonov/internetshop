package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class FixPriceProduct extends Product{
    private final int fixPrice;
    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public FixPriceProduct(@NotNull String title, int fixPrice) {
        super(title);
        this.fixPrice = fixPrice;
    }

    @Override
    public @NotNull int getPrice() {
        return fixPrice;
    }
}
