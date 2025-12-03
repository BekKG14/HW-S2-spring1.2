package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }



        public Collection<SearchResult> search(String searchTerm) {
       return storageService.getAllSearchable().stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
               .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
