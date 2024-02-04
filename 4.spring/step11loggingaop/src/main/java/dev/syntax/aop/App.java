package dev.syntax.aop;

import dev.syntax.aop.config.BeanConfig;
import dev.syntax.aop.controller.CoffeeController;
import dev.syntax.aop.model.Coffee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

        CoffeeController controller = ctx.getBean(CoffeeController.class);
        System.out.println(controller);

//        controller.getCoffee();
        Coffee coffee = new Coffee(1, "페퍼민트");
        controller.saveCoffee(coffee);
    }
}
