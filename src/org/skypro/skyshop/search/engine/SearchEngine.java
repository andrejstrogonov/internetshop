package org.skypro.skyshop.search.engine;
import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.tools.StringTools;

import java.util.*;


public final class SearchEngine {
    private final HashSet<Searchable> searchableItems;

    /**
     * Конструктор.
     */
    public SearchEngine() {
        this.searchableItems = new HashSet<>();
        clear();
    }

    /**
     * Очистка массива.
     */
    public void clear() {
        searchableItems.clear();
    }

    /**
     * Добавление элемента в массив.
     *
     * @param searchable элемент для добавления.
     */
    public void add(@NotNull Searchable searchable) {
        searchableItems.add(searchable);
    }

    /**
     * Количество результатов поиска.
     */
    public static final int MAX_RESULTS = 10_000;

    /**
     * Поиск.<br>
     * Ограничение по количеству результатов оставлено для безопасности,<br>
     * но предел увеличен до очень большого значения.
     *
     * @param query запрос.
     */
    @NotNull
    public Set<Searchable> search(@NotNull String query) {
        Set<Searchable> results = new TreeSet<>(new CustomComparator());

        int i = 0;
        for (Searchable searchable : searchableItems) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchableTerm().contains(query)) {
                results.put(searchable.getSearchableName(), searchable);
                if (i++ >= MAX_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }
    public static class CustomComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            return o1.getSearchableName().compareTo(o2.getSearchableName());
        }
        public boolean compareLines(Searchable o1, Searchable o2) {
            return Integer.compare(o1.getSearchableName().length(), o2.getSearchableName().length()) == 0;
        }
    }

    /**
     * Поиск наиболее частого результата.
     *
     * @param query запрос.
     * @throws BestResultNotFound если не найдено совпадений.
     */
    @NotNull
    public Searchable searchMostFrequent(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("Массив элементов для поиска пуст");
        }

        Searchable mostFrequent = searchableItems.getFirst();
        int maxCount = StringTools.countMatches(mostFrequent.getSearchableTerm(), query);

        for (Searchable searchable : searchableItems) {
            int count = StringTools.countMatches(searchable.getSearchableTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = searchable;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("Не найдено совпадений");
        }

        return mostFrequent;
    }
}