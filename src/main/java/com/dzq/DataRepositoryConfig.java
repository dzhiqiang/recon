package com.dzq;

import java.util.List;

public interface DataRepositoryConfig {

    public DataRepository dataRepository();

    public List<Filter> filter();

    public Condition condition();

    public DataSourceConfig dataSourceConfig();


}
