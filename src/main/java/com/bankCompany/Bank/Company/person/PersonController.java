package com.bankCompany.Bank.Company.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/getall")
    public String getAll() {
        return personService.getAll();
    }

    @GetMapping("/getperson/{id}")
    public String getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PostMapping("/addperson")
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/updateperson/{id}")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    @DeleteMapping("/deleteperson/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        return personService.deletePerson(id);
    }
}
