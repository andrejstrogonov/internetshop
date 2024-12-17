package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    /**
     * Название продукта.
     */
    @NotNull
    private final String title;


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

    @NotNull
    public abstract int getPrice();

    public boolean isSpecial(){
        return false;
    }
}
