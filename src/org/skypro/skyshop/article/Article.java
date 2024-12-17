package org.skypro.skyshop.article;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;

@SuppressWarnings("all")
public class Article implements Searchable {
    @NotNull
    private final String title;
    @NotNull
    private final String content;

    /**
     * Конструктор.
     *
     * @param title   заголовок статьи
     * @param content текст статьи
     */
    public Article(@NotNull String title, @NotNull String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * Получение заголовка статьи.
     *
     * @return заголовок статьи
     */
    @NotNull
    public String getTitle() {
        return title;
    }

    /**
     * Получение текста статьи.
     *
     * @return текст статьи
     */
    @NotNull
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @NotNull
    public String getSearchableName() {
        return this.getClass().getSimpleName() + "-" + SEARCHABLE_CONTENT_KIND + "-" + this.hashCode();
    }

    @Override
    public @NotNull String getSearchableTerm() {
        return toString();
    }

    public static final String SEARCHABLE_CONTENT_KIND = "ARTICLE";

    @Override
    public @NotNull String getSearchableContentKind() {
        return SEARCHABLE_CONTENT_KIND;
    }
}
