package com.dzq;

public class DefaultCompareFieldResult implements CompareFieldResult{

    private boolean equally;
    private Field field;
    private Field masterField;
    private Field slaverField;

    @Override
    public boolean equally() {
        return this.equally;
    }

    @Override
    public Field field() {
        return this.field;
    }

    @Override
    public Field masterField() {
        return this.masterField;
    }

    @Override
    public Field slaverField() {
        return this.slaverField;
    }

    public void setEqually(boolean equally) {
        this.equally = equally;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setMasterField(Field masterField) {
        this.masterField = masterField;
    }

    public void setSlaverField(Field slaverField) {
        this.slaverField = slaverField;
    }
}
