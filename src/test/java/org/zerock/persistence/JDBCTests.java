package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class JDBCTests {

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnectionm() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mariadb://wishket-aws.cw2h1nljbpsk.ap-northeast-2.rds.amazonaws.com:3306",
                    "admin",
                    "aa787574"
            );
            log.info(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
