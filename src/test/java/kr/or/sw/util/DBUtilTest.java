package kr.or.sw.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class DBUtilTest {

    private static DBUtil dbUtil;

    @Before
    public void setUp() {

        dbUtil = DBUtil.getInstance();
    }

    @After
    public void tearDown() throws SQLException {

        if (dbUtil != null) {
            dbUtil.releaseConnection();
            log.info("tearDown");
        }
    }

    @Test
    public void testGetConnection() throws SQLException {

        Connection connection = dbUtil.getConnection();
        Assert.assertNotNull(connection);
        connection.close();
    }
}