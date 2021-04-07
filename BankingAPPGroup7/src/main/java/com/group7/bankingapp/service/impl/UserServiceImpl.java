package com.group7.bankingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.group7.bankingapp.constants.GeneralConstants;
import com.group7.bankingapp.domain.entity.Card;
import com.group7.bankingapp.domain.entity.Role;
import com.group7.bankingapp.domain.entity.Transaction;
import com.group7.bankingapp.domain.entity.User;
import com.group7.bankingapp.forms.UserCreateForm;
import com.group7.bankingapp.repository.CardRepository;
import com.group7.bankingapp.repository.RoleRepository;
import com.group7.bankingapp.repository.TransactionRepository;
import com.group7.bankingapp.repository.UserRepository;
import com.group7.bankingapp.service.CardService;
import com.group7.bankingapp.service.RoleService;
import com.group7.bankingapp.service.TransactionService;
import com.group7.bankingapp.service.UserService;

import static com.group7.bankingapp.constants.GeneralConstants.ROLE_USER;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CardService cardService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<Card> findUserCardsById(long id) {
        return cardService.findCardsByUserId(id);
    }

    @Override
    public List<Transaction> findTransactionsByCardId(long id) {
        return transactionService.findTransactionsByCardId(id);
    }

    public User registerUser(UserCreateForm userCreateForm) {
        User user = new User();

        user.setUsername(userCreateForm.getUsername());
        user.setEmail(userCreateForm.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateForm.getPassword()));

        Set<Role> roles = generateRolesSet();
        user.setRoles(roles);
        user.setCards(new ArrayList<>());

        return userRepository.save(user);
    }

    private Set<Role> generateRolesSet() {
        Role role = roleService.findByRoleName(ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    public boolean hasValidPassword(User user, String pwd) {
        return passwordEncoder.matches(pwd, user.getPassword());
    }
}
