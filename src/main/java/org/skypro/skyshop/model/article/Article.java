package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Article implements Searchable {
    private final String title;
    private final String text;
    private final UUID id;

    public Article(UUID id,String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.text = text;
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @JsonIgnore
    public String getSearchTerm() {
        return title + " " + text;
    }
    @JsonIgnore
    public String getSearchType() {
        return "ARTICLE";
    }
}
