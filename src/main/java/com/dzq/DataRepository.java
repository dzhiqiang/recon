package com.dzq;

import java.sql.SQLException;
import java.util.List;

public interface DataRepository {

    public List<Data> getListData(List<Field> whereList);

    public int saveList(List<Data> dataList);

    public int save(Data data);

    public Data getData(Field field);

    public int update(Field field);

    public int updateMultiple(List<Field> fieldList);

    public boolean stop();

}
