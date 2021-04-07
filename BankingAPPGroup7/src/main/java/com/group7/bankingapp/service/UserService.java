package com.group7.bankingapp.service;

import java.util.List;
import java.util.Optional;

import com.group7.bankingapp.domain.entity.Card;
import com.group7.bankingapp.domain.entity.Transaction;
import com.group7.bankingapp.domain.entity.User;
import com.group7.bankingapp.forms.UserCreateForm;

public interface UserService {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<Card> findUserCardsById(long id);
    List<Transaction> findTransactionsByCardId(long id);
    User registerUser(UserCreateForm userCreateForm);
    boolean hasValidPassword(User user, String pwd);
}
