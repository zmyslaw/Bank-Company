package com.bankCompany.Bank.Company.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/getall")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/getperson/{id}")
    public String getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @GetMapping("/getbyname/{name}")
    public String getByName(@PathVariable("name") String name) {
        return personService.getByName(name);
    }

    @PostMapping("/addperson")
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/updateperson/{id}")
    public String updatePerson(@PathVariable("id") Long id, @RequestBody Person updatedPerson) {
        return personService.updatePerson(id, updatedPerson);
    }

    @DeleteMapping("/deleteperson/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        return personService.deletePerson(id);
    }
}
