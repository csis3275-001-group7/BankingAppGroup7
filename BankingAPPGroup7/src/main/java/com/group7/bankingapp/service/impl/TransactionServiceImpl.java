package com.group7.bankingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.bankingapp.domain.entity.Transaction;
import com.group7.bankingapp.repository.TransactionRepository;
import com.group7.bankingapp.service.TransactionService;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findTransactionsByCardId(long id) {
        return transactionRepository.findTransactionsByCardId(id);
    }
}
