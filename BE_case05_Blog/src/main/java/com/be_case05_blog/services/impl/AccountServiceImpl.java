package com.be_case05_blog.services.impl;

import com.be_case05_blog.models.Account;
import com.be_case05_blog.repositories.AccountRepo;
import com.be_case05_blog.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements UserDetailsService {
//    @Autowired
//    AccountRepo accountRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountRepo.findAccountByUsername(username);
//        return new User(account.getUsername(),account.getPassword(),account.getRoles());
//    }
//
//    @Override
//    public Account findAccountByUsername(String username) {
//        return accountRepo.findAccountByUsername(username);
//    }

    @Autowired
    AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUsername(username);
        return new User(account.getUsername(),account.getPassword(),account.getRoles());
    }

    public Account findAccountByUsername(String username){
        return accountRepo.findAccountByUsername(username);
    }
}
