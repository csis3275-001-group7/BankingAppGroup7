package com.group7.bankingapp.service;

import java.util.List;
import java.util.Optional;

import com.group7.bankingapp.domain.entity.Card;
import com.group7.bankingapp.domain.entity.Transaction;
import com.group7.bankingapp.domain.entity.User;
import com.group7.bankingapp.forms.UserCreateForm;

public interface TransactionService {

    List<Transaction> findTransactionsByCardId(long id);
}
