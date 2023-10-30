package dev.spring.petclinic.controller;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
// bean으로 등록시키기 위한 annotation 추가
@Controller
@RequiredArgsConstructor // ####이 둘을 통해 의존성 주입이 동작한다.
public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService; // ####이 둘을 통해 의존성 주입이 동작한다.


    @GetMapping // localhost:8080/owners로 동작, 별도의 URL작성하지 않음
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        /*
         * 요구사항 - 특정 키워드로 검색 시 해당 키워드가 포함된 모든 Owner가 검색되서 목록에 출력되도록 구현
         * 필요한 API - Spring Data JPA에서 제공하는 Query Method 기능이 필요할 수 있음
         * findAll() 대신 다른 메서드를 사용해야함
         *
         */

        // 별도의 파라미터 값(lastName에 값이 없는 경우) 없이 /owners로 요청이 올 경우, 전체 owners 데이터 반환

        // 조건문을 통해 구현
        if(owner.getLastName()==null) owner.setLastName("");


        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName()+"%");
        if (results.isEmpty()) { // 해당하는 Owner 데이터가 없을 경우
            result.rejectValue("lastName", "notFound", "not Found");
            return "owners/findOwners";
        } else if (results.size() == 1) { // 일치하는 Owners 데이터가 1명일 경우
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else { // 2명 이상의 Owner가 조회될 경우
            model.addAttribute("listOwners", results); // ownersList.html에 작성된 key값과 일치하도록(listOwners)
            return "owners/ownersList";
        }
        // ownerService를 통해 전체 Owner 목록 조회 후 반환 데이터를 모델에 추가하여 view 페이지로 반환
        // ex. model.addAttribute("listOwners", 결과 객체);
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        
        mav.addObject(ownerService.findById(ownerId));
        
        return mav;
    }
    
//    public OwnerController

//    @RequestMapping(value="/find", method = RequestMethod.GET)
    @GetMapping("/find") // 위 코드의 축약 표현
    public String findOwners(Model model){

        // 서블릿에서는 request.setAttribute("key", value); 입력했었는데 이를 스프링 부트에서는 이렇게 사용
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }
    
    // Owner 등록 화면으로 렌더링해주는 메서드
    @GetMapping("/new") // GET : localhost:8080/owners/new 요청 시 렌더링할 페이지 지정
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());

        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }
    // Owner 등록 처리 메서드
    @PostMapping("/new")
    public String processCreationForm(@Validated Owner owner, BindingResult result){
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else{
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId(); //{ownerId}로 전송
        }
    }
}
