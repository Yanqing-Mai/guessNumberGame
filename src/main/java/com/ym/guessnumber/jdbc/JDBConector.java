package com.ym.guessnumber.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JDBConector {

    private static DataSource getDatasource() throws SQLException{
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("gamesDB");
        ds.setUser("root");
        ds.setPassword("010297");
        ds.setServerTimezone("America/Central");
        ds.setAllowPublicKeyRetrieval(true);
        return ds;
    }
}
