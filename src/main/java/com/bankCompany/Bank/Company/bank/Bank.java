package com.bankCompany.Bank.Company.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bank {
    public Long index;
    public String name;
    public String city;

    public String toString() {
        return "Index: " + index + ", name: " + name + ", City: " + city + ".";
    }
}