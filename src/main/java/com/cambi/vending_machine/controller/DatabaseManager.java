package com.cambi.vending_machine.controller;

import com.cambi.vending_machine.dao.DatabaseMangerDao;
import com.cambi.vending_machine.model.TableSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/management")
@RestController
public class DatabaseManager {

    private final DatabaseMangerDao dataBaseMangerDao;

    DatabaseManager(DatabaseMangerDao databaseMangerDao) {
        this.dataBaseMangerDao = databaseMangerDao;
    }

    @PutMapping
    public void resetDatabase() {
        this.dataBaseMangerDao.resetDatabase();
    }

    @GetMapping
    public List<TableSize> getAllTableSizes () {
        return this.dataBaseMangerDao.getAllTableSizes();
    }


}
