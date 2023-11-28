package com.bankCompany.Bank.Company.bank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;

    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    public String getBank(long id) {
        return bankRepository.findById(id).isPresent() ? bankRepository.findById(id).get().toString() : "No data.";
    }

    public String getByName(String name) {
        Optional<Bank> bank = bankRepository.getByName(name);

        return bank.isPresent() ? bank.toString() : "No data.";
    }

    public String addBank(Bank bank) {
        bankRepository.save(bank);
        return "200. Add: " + bank;
    }

    public String updateBank(Long id, Bank updatedBank) {

        //1
        bankRepository.findById(updatedBank.getIndex())
                .ifPresent(user1 -> {
                    user1.setName(updatedBank.getName());

                    bankRepository.save(user1);
                });

        //3
        if (bankRepository.findById(id).isPresent()) {
            Bank bank = bankRepository.findById(id).get();
            bank.setName(updatedBank.getName());
            bank.setCity(updatedBank.getCity());

            bankRepository.deleteById(id);
            bankRepository.save(updatedBank);

            return "200. Update: " + bank;
        }

        return "No data.";
    }

    public String deleteBank(long id) {
        if (bankRepository.findById(id).isPresent()) {
            String result = bankRepository.findById(id).get().toString();

            bankRepository.deleteById(id);

            return "200. Delete success: " + result;
        }

        return "No data.";
    }
}