package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    UUID getId();
    String getSearchTerm();
    String getSearchType();
    default String getStringRepresentation(){
        return getSearchTerm() + " " + getSearchType();
    };
}
