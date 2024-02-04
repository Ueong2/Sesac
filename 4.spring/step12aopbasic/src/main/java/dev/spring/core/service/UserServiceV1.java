package dev.spring.core.service;

import dev.spring.core.dao.UserDao;
import dev.spring.core.model.User;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class UserServiceV1 {
    private UserDao userDao;
    private DataSource dataSource;

    public UserServiceV1(UserDao userDao, DataSource dataSource) {
        this.userDao = userDao;
        this.dataSource = dataSource;
    }

    // PlatformTransactionManager : 명시적 트랜잭션
    public void addUser(User user) {
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // DB 저장 로직
            userDao.addUser(user);

            transactionManager.commit(status);
        }
        catch(RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
