package com.dzq;

import java.util.List;

public class MysqlDataRepositoryConfig implements DataRepositoryConfig{

    private List<Filter> filters;
    private Condition condition;
    private DataSourceConfig dataSourceConfig;

    @Override
    public DataRepository dataRepository() {
        return new MysqlDataRepository((DbDataSourceConfig) dataSourceConfig(), (MysqlCondition) condition(), filter());
    }

    @Override
    public List<Filter> filter() {
        return this.filters;
    }

    @Override
    public Condition condition() {
        return this.condition;
    }

    @Override
    public DataSourceConfig dataSourceConfig() {
        return this.dataSourceConfig;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public DataSourceConfig getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }
}
