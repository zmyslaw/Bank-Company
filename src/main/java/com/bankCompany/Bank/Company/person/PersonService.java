package com.bankCompany.Bank.Company.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public String getAll() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ((List<Person>) personRepository.findAll()).size(); i++) {
            if (((List<Person>) personRepository.findAll()).get(i) != null) {
                result.append(((List<Person>) personRepository.findAll()).get(i)).append("</br>");
            }
        }

        return result.toString();
    }

    public String getPerson(long id) {
        return personRepository.findById(id).isPresent() ? personRepository.findById(id).get().toString() : "No data.";
    }

    public String addPerson(Person person) {
        personRepository.save(person);
        return "200. Add: " + person;
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public String deletePerson(long id) {
        String result = "No data.";

        if (personRepository.findById(id).isPresent()) {
            result = "200. Delete success: " + personRepository.findById(id).get();
            personRepository.deleteById(id);
        }

        return result;
    }
}