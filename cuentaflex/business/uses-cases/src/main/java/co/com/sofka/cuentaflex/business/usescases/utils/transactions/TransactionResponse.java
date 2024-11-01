package co.com.sofka.cuentaflex.business.usescases.utils.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private String payrollAccountNumber;
    private String supplierAccountNumber;
    private BigDecimal amount;
    private BigDecimal cost;
    private String type;
    private LocalDateTime timestamp;
}
