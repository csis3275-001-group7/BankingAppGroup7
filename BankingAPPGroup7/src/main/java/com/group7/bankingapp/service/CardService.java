package com.group7.bankingapp.service;

import java.util.List;

import com.group7.bankingapp.domain.entity.Card;

public interface CardService {

    List<Card> findCardsByUserId(long id);
    Card findCardById(long id);
}
