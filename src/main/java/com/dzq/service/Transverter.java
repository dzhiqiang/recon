package com.dzq.service;

import java.util.Map;

public interface Transverter {

    public boolean filter(String msg);

    public Map<String, Object> tran(String msg);

    public Map<String, Object> tranToList(String msg);

}
