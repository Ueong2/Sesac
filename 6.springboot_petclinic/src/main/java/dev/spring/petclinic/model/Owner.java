package dev.spring.petclinic.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // jpa도 xml 없이 자동으로 잡아주는 것인가?
@Getter
@Table(name = "owners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner extends Person {
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    // TODO: pets 맵
    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, List<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "pets=" + pets +
                '}';
    }
}