package org.zerock.persistence;

import static org.junit.Assert.fail;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;

    @Test
    public void testConnection() {

        try( Connection con = dataSource.getConnection()) {

            log.info(con);

        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

}
