package dev.syntax.aop.controller;

import dev.syntax.aop.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller // @Component
@Slf4j
public class CoffeeController {

    public void getCoffee(){
        log.info("-- getCoffees() called");
    }

    public void saveCoffee(Coffee coffee){
        log.info("-- saveCoffee() called");
        log.info("-- coffee: {}",coffee);
    }

}
