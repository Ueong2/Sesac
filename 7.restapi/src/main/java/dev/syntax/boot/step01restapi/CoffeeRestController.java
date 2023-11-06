package dev.syntax.boot.step01restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeRestController {
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeRestController() {
        coffees.addAll(List.of(
                new Coffee("아메리카노", "medium"),
                new Coffee("카페라떼","medium"),
                new Coffee("페퍼민트","small"),
                new Coffee("유자레몬티","large")
        ));
    }
    // GET : localhost:8080/coffees
    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    // GET : localhost:8080/coffees/1
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee c:coffees) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    Coffee addCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);

        return coffee;
    }

    // PUT 메서드 활용, pathVariable로 전달받은 id값에 해당하는 Coffee 데이터 변경
    // 2개의 파라미터 받기
    // 1. id값
    // 2. 변경할 Coffee 객체
    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                // setId() 사용해서 수정할 데이터에 id값 추가
                coffees.set(coffeeIndex, coffee);
            }
        }
        return (coffeeIndex == -1) ? new ResponseEntity<>(addCoffee(coffee), HttpStatus.CREATED)
                : new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    // DELETE 메서드 활용
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
