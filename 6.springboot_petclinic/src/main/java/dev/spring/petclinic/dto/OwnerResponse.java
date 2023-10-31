package dev.spring.petclinic.dto;

import dev.spring.petclinic.model.Owner;
import lombok.Getter;
import lombok.ToString;

// 네이밍은 취향(OwnerDTO, OwnerDto)
// Owner에 대한 응답용 객체(Response)로 사용될 클래스
@Getter
@ToString
public class OwnerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    // pet에 대한 데이터를 담을 필드 필요
    public OwnerResponse(Long id, String firstName, String lastName, String address, String city, String telephone) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    // 이펙티브 자바 item - 정적 팩토리 메서드
    public static OwnerResponse from(Owner owner) {
        final Long id = owner.getId();
        final String firstName = owner.getFirstName();
        final String lastName = owner.getLastName();
        final String address = owner.getAddress();
        final String city = owner.getCity();
        final String telephone = owner.getTelephone();

        return new OwnerResponse(id, firstName, lastName,address,city,telephone);
    }
}
