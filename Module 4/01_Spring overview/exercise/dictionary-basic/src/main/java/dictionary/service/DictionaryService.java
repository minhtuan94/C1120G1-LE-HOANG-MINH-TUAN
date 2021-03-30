package dictionary.service;

import java.util.Map;

public interface DictionaryService {
    Map<String, String> dictionary();
    String search(String a);
}
