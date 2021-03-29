package dictionary.service;

import java.util.HashMap;
import java.util.Map;

public interface DictionaryService {
    Map<String, String> dic();
    String search(String a);
}
