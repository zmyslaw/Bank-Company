package com.bankCompany.Bank.Company.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public String getPerson(long id) {
        return personRepository.findById(id).isPresent() ? personRepository.findById(id).get().toString() : "No data.";
    }

    public String getByName(String name) {
        Optional<Person> person = personRepository.getByName(name);

        return person.isPresent() ? person.toString() : "No data.";
    }

    public String addPerson(Person person) {
        personRepository.save(person);
        return "200. Add: " + person;
    }

    public String updatePerson(Long id, Person updatedPerson) {

        //1
        personRepository.findById(updatedPerson.getId())
                .ifPresent(user1 -> {
                    user1.setName(updatedPerson.getName());

                    personRepository.save(user1);
                });

        //3
        if (personRepository.findById(id).isPresent()) {
            Person person = personRepository.findById(id).get();
            person.setName(updatedPerson.getName());
            person.setSurname(updatedPerson.getSurname());

            personRepository.deleteById(id);
            personRepository.save(updatedPerson);

            return "200. Update: " + person;
        }

        return "No data.";
    }

    public String deletePerson(long id) {
        if (personRepository.findById(id).isPresent()) {
            String result = personRepository.findById(id).get().toString();

            personRepository.deleteById(id);

            return "200. Delete success: " + result;
        }

        return "No data.";
    }
}