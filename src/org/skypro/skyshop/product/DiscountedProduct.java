package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public final class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    /**
     * Конструктор.
     *
     * @param title название продукта
     */
    public DiscountedProduct(@NotNull String title, int basePrice, int discountPercentage) {
        super(title);
        this.basePrice = basePrice;
        this.discount = discountPercentage;
        assert discountPercentage >= 0 && discountPercentage <= 100;
    }

    @Override
    public @NotNull int getPrice() {
        return basePrice - (int)((double)(basePrice * discount) / 100.0);
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice() + " (скидка "+ discount + "%)";
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}
