package kr.or.sw.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)    // Singleton Pattern
public class DBUtil {

    private static volatile DBUtil instance;
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;

    public static DBUtil getInstance() {
        if (instance == null) {
            synchronized (DBUtil.class) {
                if (instance == null) {
                    instance = new DBUtil();
                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = connectionThreadLocal.get();
        if (connection == null || connection.isClosed()) {
            try {
                if (sqlSessionFactory == null) {
                    initSqlSessionFactory();
                }
                connection = sqlSessionFactory.openSession().getConnection();
                connectionThreadLocal.set(connection);
                log.info("JDBC 접속 성공: {}", connection);
            } catch (IOException e) {
                log.error("MyBatis SqlSessionFactory 초기화 실패", e);
                throw new SQLException("MyBatis SqlSessionFactory 초기화 실패", e);
            }
        }
        return connection;
    }

    private void initSqlSessionFactory() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
    }

    public void releaseConnection() throws SQLException {
        Connection connection = connectionThreadLocal.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("JDBC 종료 실패", e);
                throw e;
            } finally {
                connectionThreadLocal.remove();
            }
        }
    }
}
