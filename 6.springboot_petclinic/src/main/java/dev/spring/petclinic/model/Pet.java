package dev.spring.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "pets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    public Pet(Long id) {
        super(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
