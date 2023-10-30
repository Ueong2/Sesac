package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public Owner save(Owner owner) {
        // DB 등록 처리 로직 구현
        return ownerRepository.save(owner);
    }

    public Owner findById(Long id) {
        // JPA - manager.find(Owner.class, 1);
        // Optional : 테이블을 select했을 때 null인 경우 nullPointer 에러가 발생하는데, Optional을 통해 이를 처리할 수 있다.
        Optional<Owner> optionalOwner =  ownerRepository.findById(id);

        if(optionalOwner.isPresent()) { // optional 내부의 값이 유효하면 optional 내부에서 해당 객체를 꺼냄
            return optionalOwner.get();
        }
        else {
            // 예외 던지기
            return null;
        }
        // 위 코드를 한 줄로 표현하면
        // ownerRepository.findById(id).orElse(null); // orElseThrow(람다 형태) 활용 권장
    }
    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

}
