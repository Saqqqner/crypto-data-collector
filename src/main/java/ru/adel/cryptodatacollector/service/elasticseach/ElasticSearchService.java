package ru.adel.cryptodatacollector.service.elasticseach;

import java.util.List;

public interface ElasticSearchService<T> {
    List<T> getData(int start, int limit);
    void saveData(T data);
    void saveAllData(List<T> dataList);
}
