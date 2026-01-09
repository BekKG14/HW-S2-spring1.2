package org.skypro.skyshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.skypro.skyshop.model.SearchResult;
@ExtendWith(MockitoExtension.class)
class SearchServiceTest {
    @Mock
    private StorageService storageServiceMock;
    @InjectMocks
    private SearchService searchService;

    @Test
    void search_whenStorageIsEmpty_shouldReturnEmptyList() {
        when(storageServiceMock.getAllSearchable()).thenReturn(Collections.emptyList());
        Collection<SearchResult> actualResult = searchService.search("любой запрос");
        assertThat(actualResult).isEmpty();
    }
    @Test
    @DisplayName("Поиск должен возвращать пустой список, если совпадений не найдено")
    void search_whenNoMatchesFound_shouldReturnEmptyList() {
        Searchable item = mock(Searchable.class);
        when(item.getSearchTerm()).thenReturn("Хлеб");
        when(storageServiceMock.getAllSearchable()).thenReturn(List.of(item));
        Collection<SearchResult> results = searchService.search("Молоко");
        assertThat(results).isEmpty();
    }
    @Test
    @DisplayName("Поиск должен возвращать результат, если найдено совпадение")
    void search_whenMatchFound_shouldReturnSearchResult() {
        UUID id = UUID.randomUUID();
        String name = "Вкусное Молоко";
        String type = "PRODUCT";
        Searchable item = mock(Searchable.class);
        when(item.getId()).thenReturn(id);
        when(item.getSearchTerm()).thenReturn(name);
        when(item.getSearchType()).thenReturn(type);
        when(storageServiceMock.getAllSearchable()).thenReturn(List.of(item));
        Collection<SearchResult> results = searchService.search("молоко");
        assertThat(results).hasSize(1);
        SearchResult result = results.iterator().next();
        assertThat(result.getId()).isEqualTo(id.toString());
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getContentType()).isEqualTo(type);
    }
}
