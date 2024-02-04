package dev.spring.core.service;

import dev.spring.core.model.User;
import org.hibernate.Transaction;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserServiceV3Tx implements UserServiceV3{

    private UserServiceV3 userServiceV3;
    private PlatformTransactionManager transactionManager;

    public UserServiceV3Tx(UserServiceV3 userServiceV3, PlatformTransactionManager transactionManager) {
        this.userServiceV3 = userServiceV3;                 // new UserServiceV3Impl();
        this.transactionManager = transactionManager;       // new DataSourceTransactionManager();
    }

    public void addUser(User user) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            userServiceV3.addUser(user);
            transactionManager.commit(status);
        }
        catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
