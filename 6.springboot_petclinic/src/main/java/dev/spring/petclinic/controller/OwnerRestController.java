package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.OwnerResponse;
import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

// owner에 대한 처리 컨트롤러이기 때문에 owners 경로의 하위 요청이 올 경우 모두 수행하도록
@RequestMapping("/api/owners") // localhost:8080/api/owners로 오는 모든 요청을 받음
@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
public class OwnerRestController {
    // GET : localhost:8080/owners - 전체 Owner 목록 조회 요청
    private final OwnerService ownerService;
    @GetMapping
    public List<Owner> listOwners() {
        // service.findAll() 호출 및 반환
        List<Owner> owners = ownerService.findAll();

        List<OwnerResponse> ownerList = owners.stream()
                .map(OwnerResponse::from).collect(Collectors.toList());
//        return owners;


        return null;
    }

    // Owner 등록 처리, 별도의 요청 객체 처리용 DTO를 활용해서 유효성 처리, 해당 메서드의 반환 타입은 ResponseEntity 사용해보기
    // -> Postman or TalendAPI Testing(Chrome Extension)
}
