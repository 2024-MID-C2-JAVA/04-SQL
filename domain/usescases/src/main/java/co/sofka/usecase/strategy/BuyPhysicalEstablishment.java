package co.sofka.usecase.strategy;

import co.sofka.Transaction;

import java.math.BigDecimal;

public class BuyPhysicalEstablishment implements TypeTransaction {
    @Override
    public Transaction movement(Transaction transaction) {
        transaction.setAmount(transaction.getAmount());
        transaction.setAmountCost(new BigDecimal(0));
        return transaction;
    }
}
