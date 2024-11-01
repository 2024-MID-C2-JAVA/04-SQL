package co.sofka;

import co.sofka.data.transaction.CreateTransactionDTO;
import co.sofka.data.transaction.GetTransactionDTO;
import co.sofka.data.transaction.TransactionResponseDTO;
import co.sofka.handler.TransactionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {

    private final TransactionHandler transactionHandler;

    public TransactionRestController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTransaction(@RequestBody CreateTransactionDTO dto) {
        try{
            transactionHandler.createTransaction(dto);
            return ResponseEntity.ok("Transaction created");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the transaction: "+e.getMessage());
        }
    }

    @PostMapping("/get")
    public ResponseEntity<TransactionResponseDTO> getTransaction(@RequestBody GetTransactionDTO dto) {
        try{
            return ResponseEntity.ok(transactionHandler.getTransactionById(dto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
