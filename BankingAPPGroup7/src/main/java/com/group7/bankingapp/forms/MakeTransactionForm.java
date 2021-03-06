package com.group7.bankingapp.forms;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Component
public class MakeTransactionForm {

    @NotEmpty
    @Length(min = 20, max = 22)
    private String acctnumber;

    @NotEmpty
    @DecimalMin("0.00")
    @DecimalMax("99999999999.00")
    private double sum;

    @NotEmpty
    @Length(min = 3, max = 250)
    private String purpose;

    private long cardId;

    public String getacctnumber() {
        return acctnumber;
    }

    public void setacctnumber(String acctnumber) {
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

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }
}
