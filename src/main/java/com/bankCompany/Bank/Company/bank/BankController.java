package com.bankCompany.Bank.Company.bank;


  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/getall")
    public List<Bank> getAll() {
        return bankService.getAll();
    }

    @GetMapping("/getbank/{id}")
    public String getBank(@PathVariable Long id) {
        return bankService.getBank(id);
    }

    @GetMapping("/getbyname/{name}")
    public String getByName(@PathVariable("name") String name) {
        return bankService.getByName(name);
    }

    @PostMapping("/addbank")
    public String addBank(@RequestBody Bank bank) {
        return bankService.addBank(bank);
    }

    @PutMapping("/updatebank/{id}")
    public String updateBank(@PathVariable("id") Long id, @RequestBody Bank updatedBank) {
        return bankService.updateBank(id, updatedBank);
    }

    @DeleteMapping("/deletebank/{id}")
    public String deleteBank(@PathVariable("id") Long id) {
        return bankService.deleteBank(id);
    }
}
