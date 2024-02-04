package dev.syntax.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("info");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        UserController controller = (UserController) ctx.getBean("userController");
        controller.getUsers();

        // Proxy가 먼저 호출되도록
        UserController withAopController = (UserController) ctx.getBean("proxyFactoryBean");
        withAopController.getUsers();

        // 이렇게 되면 UserController의 Sout가 없어도 디버그가 가능하다.
    }
}
