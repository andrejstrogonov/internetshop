package org.skypro.skyshop.search.engine;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.arrays.ArrayTools;

import java.util.Arrays;

public final class SearchEngine {
    private final Searchable[] searchableItems;

    /**
     * Конструктор.
     *
     * @param size размер массива.
     */
    public SearchEngine(int size) {
        this.searchableItems = new Searchable[size];
        clear();
    }

    /**
     * Очистка массива.
     */
    public void clear() {
        Arrays.fill(searchableItems, null);
    }

    /**
     * Добавление элемента в массив.
     *
     * @param searchable элемент для добавления.
     */
    public void add(@NotNull Searchable searchable) {
        int freeIndex = ArrayTools.getFirsIndex(searchableItems, true);
        if (freeIndex == ArrayTools.NOT_FOUND) {
            System.out.println("Невозможно добавить элемент для поиска");
            return;
        }
        searchableItems[freeIndex] = searchable;
    }

    /**
     * Количество результатов поиска.
     */
    public static final int MAX_RESULTS = 5;

    /**
     * Поиск.
     *
     * @param query запрос.
     */
    @NotNull
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[MAX_RESULTS];
        Arrays.fill(results, null);

        int i = 0;
        for (Searchable searchable : searchableItems) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchableTerm().contains(query)) {
                results[i++] = searchable;
                if (i >= MAX_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }
}
