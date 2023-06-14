package kr.or.sw.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SqlSessionFactoryUtilTest {

    @Test
    public void testGetSession() {
        log.info("getSession()");
        SqlSessionFactoryUtil.getSession();
    }
}