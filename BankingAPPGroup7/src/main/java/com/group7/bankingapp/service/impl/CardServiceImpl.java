package com.group7.bankingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.bankingapp.domain.entity.Card;
import com.group7.bankingapp.repository.CardRepository;
import com.group7.bankingapp.service.CardService;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> findCardsByUserId(long id) {
        return cardRepository.findCardsByUserId(id);
    }

    @Override
    public Card findCardById(long id) {
        return cardRepository.findCardById(id);
    }


}
