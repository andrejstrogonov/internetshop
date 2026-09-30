package org.skypro.skyshop.search.engine;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.tools.StringTools;

import java.util.*;
import java.util.stream.Collectors;


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
        return searchableItems.stream()
                .filter(Objects::nonNull)
                .filter(searchable -> searchable.getSearchableTerm().contains(query))
                .limit(MAX_RESULTS)
                .collect(Collectors.toCollection(() -> new TreeSet<>(new CustomComparator())));
    }
}

public static class CustomComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int result = Integer.compare(o1.getSearchableName().length(),
                o2.getSearchableName().length());
        if (result != 0) {
            return o1.getSearchableTerm().compareTo(o2.getSearchableTerm());
        }
        return result;
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
