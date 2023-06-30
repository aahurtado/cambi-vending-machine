package com.cambi.vending_machine.model;

public class TableSize {
    private String tableName;
    private int size;

    public TableSize(){};

    public TableSize(String tableName, int size) {
        this.tableName = tableName;
        this.size = size;
    }



    public int getSize() {
        return size;
    }


    public String getTableName() {
        return tableName;
    }



    public void setTableName(String label) {
        this.tableName = label;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
