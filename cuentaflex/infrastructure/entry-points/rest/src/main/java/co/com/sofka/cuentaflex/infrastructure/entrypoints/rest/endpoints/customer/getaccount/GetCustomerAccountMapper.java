package co.com.sofka.cuentaflex.infrastructure.entrypoints.rest.endpoints.customer.getaccount;

import co.com.sofka.cuentaflex.business.usecases.customer.getaccount.GetCustomerAccountRequest;
import co.com.sofka.cuentaflex.business.usecases.customer.getaccount.GetCustomerAccountResponse;

public final class GetCustomerAccountMapper {
    public static GetCustomerAccountRequest fromDtoToUseCaseRequest(GetCustomerAccountRequestDto dto) {
        return new GetCustomerAccountRequest(dto.getCustomerId(), dto.getAccountId());
    }

    public static GetCustomerAccountResponseDto fromUseCaseToDtoResponse(GetCustomerAccountResponse response) {
        return new GetCustomerAccountResponseDto(response.getAccountId(), response.getNumber(), response.getAmount());
    }
}
