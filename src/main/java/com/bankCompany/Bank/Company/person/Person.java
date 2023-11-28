package com.bankCompany.Bank.Company.person;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="Person")
@Table(name="Person")
 public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    public String toString() {
        return "Index: " + id + ", name: " + name + ", surname: " + surname + ".";
    }
}