package model.service;

import model.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService {
    private static Map<Integer,Dictionary> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new Dictionary("hello", "xin chào"));
        dictionaryMap.put(2, new Dictionary("rose", "hoa hồng"));
        dictionaryMap.put(3, new Dictionary("banana", "quả chuối"));
        dictionaryMap.put(4, new Dictionary("life", "cuộc sống"));
        dictionaryMap.put(5, new Dictionary("health", "sức khỏe"));

    }
    @Override
    public List<Dictionary> findALl() {
        return new ArrayList<>(dictionaryMap.values());
    }
}
