package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;

    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public DiscountedProduct(@NotNull String title, int basePrice, int discountPercentage) {
        super(title);
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public @NotNull int getPrice() {
        return basePrice/discountPercentage;
    }
}
