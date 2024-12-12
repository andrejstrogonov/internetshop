package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class FixPriceProduct extends Product{
    private final int FIX_PRICE;
    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public FixPriceProduct(@NotNull String title, int fixPrice) {
        super(title);
        FIX_PRICE = fixPrice;
    }

    @Override
    public @NotNull int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return "FixPriceProduct{" +
                "FIX_PRICE=" + FIX_PRICE +
                '}';
    }
}
