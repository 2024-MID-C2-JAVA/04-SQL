package co.com.sofka.cuentaflex.business.usescases.customer.createaccount;

import co.com.sofka.cuentaflex.business.drivenports.repositories.AccountRepository;
import co.com.sofka.cuentaflex.business.drivenports.repositories.CustomerRepository;
import co.com.sofka.cuentaflex.business.models.Account;
import co.com.sofka.shared.business.usescases.ResultWith;
import co.com.sofka.shared.business.usescases.UseCase;

public class CreateCustomerAccountUseCase implements UseCase<CreateCustomerAccountRequest, ResultWith<CreateCustomerAccountResponse>> {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CreateCustomerAccountUseCase(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public ResultWith<CreateCustomerAccountResponse> execute(CreateCustomerAccountRequest request) {
        boolean customerExists = this.customerRepository.existsCustomer(request.getCustomerId());

        if (!customerExists) {
            return ResultWith.failure(CreateCustomerAccountErrors.CUSTOMER_NOT_FOUND);
        }

        Account account = new Account(
                null,
                0,
                request.getAmount(),
                request.getCustomerId()
        );

        Account addedAccount = this.accountRepository.createAccount(account);

        return ResultWith.success(new CreateCustomerAccountResponse(
                addedAccount.getId(),
                addedAccount.getNumber(),
                addedAccount.getAmount()
        ));
    }
}
