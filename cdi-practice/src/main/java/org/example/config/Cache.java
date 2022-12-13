package org.example.config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Cache {
    private Map<String, Object> cache = new HashMap<>();

    @PostConstruct
    private void initCache() {
        // todo: init cache
    }

    public void put(String key, Object value) {
        if (!cache.containsKey(key)) {
            cache.put(key, value);
        }
    }

    public Object get(String key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return null;
        }
    }

}
