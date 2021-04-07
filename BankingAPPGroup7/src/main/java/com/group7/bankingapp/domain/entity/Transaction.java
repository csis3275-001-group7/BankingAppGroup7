package com.group7.bankingapp.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SEQ")
    @SequenceGenerator(name="T_SEQ", sequenceName="T_SEQ",initialValue = 999000, allocationSize=100)
	@Column(name = "transaction_id")
    
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "acctnumber", nullable = false)
    private String acctnumber;

    @Column(name = "sum")
    private double sum;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    public Transaction() { }



    public Transaction(Card card, String acctnumber, double sum, String purpose) {
        this.card = card;
        this.acctnumber = acctnumber;
        this.sum = sum;
        this.purpose = purpose;
    }

    public long getId() {
        return id;
    }

    public void seId(long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getAcctnumber() {
        return acctnumber;
    }

    public void setAcctnumber(String acctnumber) {
        this.acctnumber = acctnumber;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
