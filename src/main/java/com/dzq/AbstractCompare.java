package com.dzq;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCompare implements Compare{

    private int i = 0;
    private int j = 0;
    private List<Data> masterDataList;
    private List<Data> slaverDataList;


    protected Data getSlaverData(){
        Data data = slaverData();
        slaverDataBegin(data);
        return data;
    }

    protected Data getMasterData(){
        Data data = masterData();
        masterDataBegin(data);
        return data;
    }

    protected abstract Data masterData();

    protected abstract Data slaverData();

    protected abstract void masterDataBegin(Data data);

    protected abstract void slaverDataBegin(Data data);

    protected abstract void allEqually(Data masterData, Data slaverData, CompareResult result);

    protected abstract void otherSingle(Data masterData, Data slaverData, CompareResult result, CompareFieldResult compareFieldResult);

    protected CompareFieldResult compareOtherField(Data masterData, Data slaverData, List<Field> compareFields){
        DefaultCompareFieldResult result = new DefaultCompareFieldResult();
        result.setEqually(true);
        Field master = null;
        Field slaver = null;
        Field currentField = null;
        for (Field field : compareFields) {
            currentField = field;
            master = masterData.getField(field.getKey());
            slaver = slaverData.getField(field.getKey());
            if (master == null && slaver == null) {
                continue;
            }
            if (master == null || slaver == null) {
                result.setEqually(false);
                break;
            }

            if (master.value() == null && slaver.value() == null) {
                continue;
            }
            if (master.value() == null || slaver.value() == null) {
                result.setEqually(false);
                break;
            }
            if (master.value().compareTo(slaver.value()) == 0) {
                continue;
            } else {
                result.setEqually(false);
                break;
            }

        }
        if (!result.equally()) {
            result.setField(currentField);
            result.setMasterField(master);
            result.setSlaverField(slaver);
        }
        return result;
    }

    protected abstract void slaverSingle(Data masterData, ReconConfig reconConfig, CompareResult result);

    protected abstract void masterSingle(Data masterData, ReconConfig reconConfig, CompareResult result);

    protected int compareBase(Data masterData, Data slaverData, List<Field> baseFields){
        int result = 0;
        for (Field field : baseFields) {
            Field master = masterData.getField(field.getKey());
            Field slaver = slaverData.getField(field.getKey());
            if (master == null && slaver == null) {
                continue;
            }
            if (master == null) {
                result = -1;
                break;
            }
            if (slaver == null) {
                result = 1;
                break;
            }
            if (master.value() == null && slaver.value() == null) {
                continue;
            }
            if (master.value() == null) {
                result = -1;
                break;
            }
            if (slaver.value() == null) {
                result = 1;
                break;
            }
            result = master.value().compareTo(slaver.value());
        }


        return result;
    }

    protected List<Data> getSlaverDataList(Step step){
        List<Field> whereList = new ArrayList<>();
        return getSlaverDataRepository(step).getListData(whereList);
    }

    protected List<Data> getMasterDataList(Step step) {
        List<Field> whereList = new ArrayList<>();
        return getMasterDataRepository(step).getListData(whereList);
    }

    protected abstract DataRepository getMasterDataRepository(Step step);

    protected abstract DataRepository getSlaverDataRepository(Step step);

    protected CompareResult getCompareResult(){
        return new DefaultCompareResult();
    }

}
