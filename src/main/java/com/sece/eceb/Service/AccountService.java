package com.sece.eceb.service;

import com.sece.eceb.entity.Account;
import com.sece.eceb.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get one account
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    // Create account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Update account
    public Account updateAccount(Long id, Account accountDetails) {

        Account account = accountRepository.findById(id).orElse(null);

        if (account == null) {
            return null;
        }

        account.setName(accountDetails.getName());
        account.setEmail(accountDetails.getEmail());
        account.setPhone(accountDetails.getPhone());

        return accountRepository.save(account);
    }

    // Delete account
    public boolean deleteAccount(Long id) {

        if (!accountRepository.existsById(id)) {
            return false;
        }

        accountRepository.deleteById(id);
        return true;
    }
}