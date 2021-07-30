package com.dzq;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class SplitCompare extends AbstractCompare{

    private int i = 0;
    private int j = 0;
    private List<Data> masterDataList;
    private List<Data> slaverDataList;
    private CompareResult result = null;
    private DataRepository masterDataRepository;
    private DataRepository slaverDataRepository;

    public SplitCompare() {
        result = getCompareResult();
    }

    @Override
    public CompareResult compare(Step step) {
        result.setBatchId(step.task().batchId());
        ReconConfig reconConfig = step.task().getReconConfig();
        masterDataList = getMasterDataList(step);
        while (CollectionUtils.isEmpty(masterDataList) && !getMasterDataRepository(step).stop()) {
            masterDataList = getMasterDataList(step);
        }
        slaverDataList = getSlaverDataList(step);
        while (CollectionUtils.isEmpty(slaverDataList) && !getMasterDataRepository(step).stop()) {
            slaverDataList = getSlaverDataList(step);
        }
        while ( !(CollectionUtils.isEmpty(masterDataList) ||
                CollectionUtils.isEmpty(slaverDataList))) {
            Data masterData = getMasterData();
            Data slaverData = getSlaverData();
            if (compareBase(masterData, slaverData, reconConfig.getBaseFields()) < 0) {
                masterSingle(masterData, reconConfig, result);
                i++;
            } else if (compareBase(masterData, slaverData, reconConfig.getBaseFields()) > 0) {
                slaverSingle(slaverData, reconConfig, result);
                j++;
            } else {
                CompareFieldResult compareFieldResult = compareOtherField(masterData, slaverData, reconConfig.getCompareFields());
                if (!compareFieldResult.equally()) {
                    otherSingle(masterData, slaverData, result, compareFieldResult);
                }
                allEqually(masterData, slaverData, result);
                i++;
                j++;
            }
            if (i == masterDataList.size()) {
                masterDataList = getMasterDataList(step);
                while (CollectionUtils.isEmpty(masterDataList) && !getMasterDataRepository(step).stop()) {
                    masterDataList = getMasterDataList(step);
                }
                i = 0;
            }
            if (j == slaverDataList.size()) {
                slaverDataList = getSlaverDataList(step);
                while (CollectionUtils.isEmpty(slaverDataList) && !getMasterDataRepository(step).stop()) {
                    slaverDataList = getSlaverDataList(step);
                }
                j = 0;
            }
        }

        if (CollectionUtils.isEmpty(masterDataList)) {
            while (!CollectionUtils.isEmpty(slaverDataList)) {
                Data slaverData = getSlaverData();
                slaverSingle(slaverData, reconConfig, result);
                j++;
                if (j == slaverDataList.size()) {
                    slaverDataList = getSlaverDataList(step);
                    while (CollectionUtils.isEmpty(slaverDataList) && !getMasterDataRepository(step).stop()) {
                        slaverDataList = getSlaverDataList(step);
                    }
                    j = 0;
                }
            }
        }

        if (CollectionUtils.isEmpty(slaverDataList)) {
            while (!CollectionUtils.isEmpty(masterDataList)) {
                Data slaverData = getMasterData();
                slaverSingle(slaverData, reconConfig, result);
                i++;
                if (i == masterDataList.size()) {
                    masterDataList = getSlaverDataList(step);
                    while (CollectionUtils.isEmpty(masterDataList) && !getMasterDataRepository(step).stop()) {
                        masterDataList = getMasterDataList(step);
                    }
                    i = 0;
                }
            }
        }

        return result;
    }

    protected Data getSlaverData(){
        Data data = slaverData();
        slaverDataBegin(data);
        return data;
    }

    protected Data slaverData(){
        return slaverDataList.get(j);
    }


    protected Data getMasterData(){
        Data data = masterData();
        masterDataBegin(data);
        return data;
    }

    protected Data masterData(){
        return masterDataList.get(i);
    }

    protected void slaverDataBegin(Data data){

    }

    @Override
    protected void allEqually(Data masterData, Data slaverData, CompareResult result) {

    }

    @Override
    protected void otherSingle(Data masterData, Data slaverData, CompareResult result, CompareFieldResult compareFieldResult) {

    }

    @Override
    protected void slaverSingle(Data masterData, ReconConfig reconConfig, CompareResult result) {

    }

    @Override
    protected void masterSingle(Data masterData, ReconConfig reconConfig, CompareResult result) {

    }

    protected void masterDataBegin(Data data){

    }


    protected List<Data> getSlaverDataList(Step step){
        List<Field> whereList = new ArrayList<>();
        return getSlaverDataRepository(step).getListData(whereList);
    }

    protected List<Data> getMasterDataList(Step step) {
        List<Field> whereList = new ArrayList<>();
        return getMasterDataRepository(step).getListData(whereList);
    }

    @Override
    protected DataRepository getMasterDataRepository(Step step) {
        if (this.masterDataRepository == null) {
            this.masterDataRepository = step.task().getReconConfig().masterDataRepositoryConfig().dataRepository();
        }
        return this.masterDataRepository;
    }

    @Override
    protected DataRepository getSlaverDataRepository(Step step) {
        if (this.slaverDataRepository == null) {
            this.slaverDataRepository = step.task().getReconConfig().slaverDataRepositoryConfig().dataRepository();
        }
        return slaverDataRepository;
    }


}
