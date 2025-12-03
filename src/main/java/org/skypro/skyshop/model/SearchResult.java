package org.skypro.skyshop.model;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;



    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        SearchResult product = new SearchResult(searchable.getId().toString(), searchable.getSearchTerm(), searchable.getSearchType());
        return product;
    }

}
