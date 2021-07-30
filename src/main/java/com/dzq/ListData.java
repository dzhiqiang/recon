package com.dzq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListData implements Data<List<Field>>{

    private List<Field> fieldList = new ArrayList<>();

    private Map<String, Field> map = new HashMap<>();

    public boolean add(Field field) {
        map.put(field.getKey(), field);
        return fieldList.add(field);
    }

    @Override
    public String dataType() {
        return "List";
    }

    @Override
    public List<Field> getData() {
        return fieldList;
    }

    @Override
    public Field getField(String property) {
        return map.get(property);
    }
}
