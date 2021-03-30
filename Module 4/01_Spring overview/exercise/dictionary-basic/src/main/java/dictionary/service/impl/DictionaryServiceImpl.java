package dictionary.service.impl;

import dictionary.service.DictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Override
    public Map<String, String> dictionary() {
        Map<String,String> dic= new HashMap<String,String>();
        dic.put("hello","chao");
        dic.put("speaker","loa");
        dic.put("chair","ghe");
        dic.put("bottle","chai");
        return dic;
    }

    @Override
    public String search(String a) {
        if (dictionary().containsKey(a)){
            return dictionary().get(a);
        }
            return "Not found";
    }
}
