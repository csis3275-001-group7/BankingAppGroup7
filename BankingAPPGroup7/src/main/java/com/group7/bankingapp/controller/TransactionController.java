package com.group7.bankingapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.group7.bankingapp.auth.CustomUserDetails;
import com.group7.bankingapp.domain.entity.Card;
import com.group7.bankingapp.domain.entity.Transaction;
import com.group7.bankingapp.forms.MakeTransactionForm;
import com.group7.bankingapp.repository.CardRepository;
import com.group7.bankingapp.repository.TransactionRepository;
import com.group7.bankingapp.service.CardService;
import com.group7.bankingapp.service.UserService;

import java.util.List;

@Controller
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private MakeTransactionForm makeTransactionForm;

    @ModelAttribute("currentUserCards")
    public List<Card> getCurrentUserCards(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return userService.findUserCardsById(customUserDetails.getId());
    }

    @ModelAttribute("addTransactionForm")
    public MakeTransactionForm getTransactionForm() {
        return makeTransactionForm;
    }

    @GetMapping("/transactions")
    public String getTransactions() {
        return "transactions";
    }


    @GetMapping("/transactions/card/{cid}")
    public String getCardTransactions(@PathVariable("cid") long cardId,
                                      Model model) {
        List<Transaction> cardTransactions = userService.findTransactionsByCardId(cardId);
        model.addAttribute("cardTransactions", cardTransactions);
        makeTransactionForm.setCardId(cardId);
        return "card-transactions";
    }

    @PostMapping("/add-transaction")
    public String processAddTransaction(@ModelAttribute("addTransactionForm") MakeTransactionForm makeTransactionForm,
                                        Model model) {
        long cardId = makeTransactionForm.getCardId();
        String acctnumber = makeTransactionForm.getacctnumber();
        double sum = makeTransactionForm.getSum();

        String purpose = makeTransactionForm.getPurpose();

        Card card = cardService.findCardById(cardId);

        if (card != null &&  card.getCardBalance() >= sum) {
            Transaction transaction = new Transaction(card, acctnumber, sum, purpose);
            card.setCardBalance(card.getCardBalance() - sum);

            cardRepository.save(card);
            transactionRepository.save(transaction);

            model.addAttribute("successfulTransaction", "successfulTransaction");
        } else {
            model.addAttribute("insufficientFundsError", "insufficientFundsError");
        }

        return "transactions";
    }


}
