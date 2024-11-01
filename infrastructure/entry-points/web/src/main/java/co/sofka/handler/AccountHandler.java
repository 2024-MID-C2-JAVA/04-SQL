package co.sofka.handler;

import co.sofka.Account;
import co.sofka.data.account.*;
import co.sofka.encryption.AESUtilAdapter;
import co.sofka.usecase.account.CreateAccountUseCase;
import co.sofka.usecase.account.DeleteAccountUseCase;
import co.sofka.usecase.account.GetAccountByIdUseCase;
import co.sofka.usecase.account.UpdateAccountUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AccountHandler {

    private final CreateAccountUseCase createAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;


    public AccountHandler(CreateAccountUseCase createAccountUseCase, DeleteAccountUseCase deleteAccountUseCase, GetAccountByIdUseCase getAccountByIdUseCase, UpdateAccountUseCase updateAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
    }

    public void createAccount(CreateAccountDTO accountDTO) {
        Account account = new Account();
        account.setNumber(accountDTO.getNumber());
        account.setAmount(accountDTO.getAmount());
        account.setCustomerId(accountDTO.getCustomerId());
        account.setCreatedAt(LocalDate.now());
        createAccountUseCase.apply(account);
    }

    public void deleteAccount(DeleteAccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        deleteAccountUseCase.apply(account);
    }

    public AccountResponseDTO getAccountById(GetAccountByIdDTO accountDTO) {
        try {
            Account account = getAccountByIdUseCase.apply(new Account(accountDTO.getId()));
            AESUtilAdapter adapter = new AESUtilAdapter();
            return new AccountResponseDTO(
                    account.getCustomerId(),
                    adapter.encrypt(String.valueOf(account.getNumber())),
                    account.getAmount(),
                    account.getCustomerId(),
                    account.getCreatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(AccountUpdateDTO accountDTO) {
        Account account =new Account();
        account.setId(accountDTO.getId());
        account.setNumber(accountDTO.getNumber());
        account.setAmount(accountDTO.getAmount());
        account.setCustomerId(accountDTO.getCustomerId());
        account.setCreatedAt(accountDTO.getCreatedAt());
        updateAccountUseCase.apply(account);
    }
}
