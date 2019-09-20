package com.simao.common;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class MapUtil {
    public static Object find(Map<String, Object> map, String path) {
        return find(map, path, null);
    }

    public static Object find(Map<String, Object> map, String path, Object defaultValue) {
        try {
            return JsonPath.parse(map).read(path);
        } catch (PathNotFoundException e) {
            return defaultValue;
        }
    }

    public static void put(Map<String, Object> map, String path, String key, Object value) {
        DocumentContext parse = JsonPath.parse(map);
        JsonPath jsonPath = JsonPath.compile(path);
        parse.put(jsonPath, key, value);
    }

    public static Map<String, Object> $(String key, Object value) {
        Map<String, Object> target = new HashMap<>();
        target.put(key, value);
        return target;
    }

    public static Map<String, Object> $(Map<String, Object>... value) {
        Map<String, Object> target = new HashMap<>();
        asList(value).forEach(target::putAll);
        return target;
    }

    public static String toJsonString(Map<String, Object> map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    public static <K, V> HashMap<K, V> newHashMap(K k, V v) {
        HashMap<K, V> result = new HashMap<>();
        result.put(k, v);
        return result;
    }

    public static <K, V> HashMap<K, V> newHashMap(K k1, V v1, K k2, V v2) {
        HashMap<K, V> result = new HashMap<>();
        result.put(k1, v1);
        result.put(k2, v2);
        return result;
    }

    public static <K, V> HashMap<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        HashMap<K, V> result = new HashMap<>();
        result.put(k1, v1);
        result.put(k2, v2);
        result.put(k3, v3);
        return result;
    }

    public static <K, V> HashMap<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        HashMap<K, V> result = new HashMap<>();
        result.put(k1, v1);
        result.put(k2, v2);
        result.put(k3, v3);
        result.put(k4, v4);
        return result;
    }
}
