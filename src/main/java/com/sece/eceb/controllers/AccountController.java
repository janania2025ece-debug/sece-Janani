package com.sece.eceb.controller;

import com.sece.eceb.entity.Account;
import com.sece.eceb.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // 1. Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // 2. Get one account
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(account);
    }

    // 3. Create account
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // 4. Update account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable Long id,
            @RequestBody Account accountDetails) {

        Account updatedAccount =
                accountService.updateAccount(id, accountDetails);

        if (updatedAccount == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedAccount);
    }

    // 5. Delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {

        boolean deleted = accountService.deleteAccount(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Account deleted successfully");
    }
}