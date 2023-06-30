package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.model.TableSize;

import java.util.List;

public interface DatabaseMangerDao {

    void resetDatabase ();

    List<TableSize> getAllTableSizes();
}
