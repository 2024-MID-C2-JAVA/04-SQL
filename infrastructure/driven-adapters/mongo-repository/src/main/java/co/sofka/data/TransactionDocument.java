package co.sofka.data;

import co.sofka.enums.TypeOfTransaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;

@Document(collection = "transactions")
public class TransactionDocument {

    @MongoId
    private String id;
    private BigDecimal amount;
    private BigDecimal amountCost;
    private TypeOfTransaction typeOfTransaction;
    @Field(name = "timestamp")
    private Instant timeStamp;

    public TransactionDocument() {
        this.timeStamp = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountCost() {
        return amountCost;
    }

    public void setAmountCost(BigDecimal amountCost) {
        this.amountCost = amountCost;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}