package com.dzq;

import java.util.HashMap;
import java.util.Map;

public class MapData implements Data<Map<String, Field>> {

    private Map<String, Field> map = new HashMap();

    public Field put(String key,Field value) {
        return map.put(key, value);
    }

    @Override
    public String dataType() {
        return "Map";
    }

    @Override
    public Map<String, Field> getData() {
        return this.map;
    }

    @Override
    public Field getField(String property) {
        return map.get(property);
    }

}
