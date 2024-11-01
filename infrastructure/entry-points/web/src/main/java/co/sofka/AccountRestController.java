package co.sofka;

import co.sofka.data.account.*;
import co.sofka.handler.AccountHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {

    private final AccountHandler accountHandler;

    public AccountRestController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<String>createAccount(@RequestBody CreateAccountDTO dto) {
        try{
            System.out.println("ID CLIENTE : "+dto.getCustomerId());
            accountHandler.createAccount(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Account created");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the account: "+e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteAccount(@RequestBody DeleteAccountDTO dto) {
        try{
            accountHandler.deleteAccount(dto);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the account: "+e.getMessage());
        }
    }

    @PostMapping("/get")
    public ResponseEntity<AccountResponseDTO> getAccountById(@RequestBody GetAccountByIdDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(accountHandler.getAccountById(dto));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateAccountAmount(@RequestBody AccountUpdateDTO dto){
        try{
            accountHandler.updateAccount(dto);
            return ResponseEntity.status(HttpStatus.OK).body("Account updated");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the account: "+e.getMessage());
        }
    }

}
