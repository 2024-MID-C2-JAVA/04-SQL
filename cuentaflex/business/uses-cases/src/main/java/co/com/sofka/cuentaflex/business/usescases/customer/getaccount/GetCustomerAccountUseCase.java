package co.com.sofka.cuentaflex.business.usescases.customer.getaccount;

import co.com.sofka.cuentaflex.business.drivenports.repositories.AccountRepository;
import co.com.sofka.cuentaflex.business.models.Account;
import co.com.sofka.shared.business.usescases.ResultWith;
import co.com.sofka.shared.business.usescases.UseCase;

public class GetCustomerAccountUseCase implements UseCase<GetCustomerAccountRequest, ResultWith<GetCustomerAccountResponse>> {
    private final AccountRepository accountRepository;

    public GetCustomerAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResultWith<GetCustomerAccountResponse> execute(GetCustomerAccountRequest request) {
        Account account = accountRepository.getByIdAndCustomerId(request.getAccountId(), request.getCustomerId());

        if (account == null) {
            return ResultWith.failure(GetCustomerAccountErrors.ACCOUNT_NOT_FOUND);
        }

        return ResultWith.success(new GetCustomerAccountResponse(
                account.getId(),
                account.getNumber(),
                account.getAmount()
        ));
    }
}
