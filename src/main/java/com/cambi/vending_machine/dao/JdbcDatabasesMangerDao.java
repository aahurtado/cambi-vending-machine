package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.model.Nutrient.Nutrient;
import com.cambi.vending_machine.model.TableSize;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDatabasesMangerDao implements DatabaseMangerDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcDatabasesMangerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void resetDatabase() {
        jdbcTemplate.execute("SET CONSTRAINTS ALL DEFERRED");

        // Truncate each table in the database
//        jdbcTemplate.execute("TRUNCATE TABLE unit CASCADE");
//        jdbcTemplate.execute("TRUNCATE TABLE nutrient_group CASCADE");
        jdbcTemplate.execute("TRUNCATE TABLE nutrient CASCADE");
        jdbcTemplate.execute("TRUNCATE TABLE product CASCADE");
        jdbcTemplate.execute("TRUNCATE TABLE product_nutrient CASCADE");
    }
    @Override
    public List<TableSize> getAllTableSizes() {
        String sql = "SELECT table_name, pg_total_relation_size('\"' || table_schema || '\".\"' || table_name || '\"') AS size" +
                " FROM information_schema.tables" +
                " WHERE table_type = 'BASE TABLE'" +
                " AND table_schema NOT IN ('pg_catalog', 'information_schema')" +
                " UNION ALL" +
                " SELECT 'total' AS table_name, SUM(pg_total_relation_size('\"' || table_schema || '\".\"' || table_name || '\"')) AS total_size" +
                " FROM information_schema.tables" +
                " WHERE table_type = 'BASE TABLE'" +
                " AND table_schema NOT IN ('pg_catalog', 'information_schema')";

        List<TableSize> tableSizes = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            TableSize tableSize = mapRowToTableSize(results);
            tableSizes.add(tableSize);
        }
        return tableSizes;
    }
    private TableSize mapRowToTableSize (SqlRowSet rs) {
        TableSize tableSize = new TableSize();
        tableSize.setSize(rs.getInt("size"));
        tableSize.setTableName(rs.getString("table_name"));
        return tableSize;
    }
}
