package com.example.banco_hex_yoder.postgresql_repository.postgresql_repository;

import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.model.Transaction;
import com.example.banco_hex_yoder.postgresql_repository.data.entidades.CuentaEntity;
import com.example.banco_hex_yoder.postgresql_repository.data.entidades.TransaccionEntity;
import com.example.banco_hex_yoder.postgresql_repository.data.entidades.TransactionAccountDetailEntity;
import com.example.banco_hex_yoder.postgresql_repository.data.repositorios.AccountRepository;
import com.example.banco_hex_yoder.postgresql_repository.data.repositorios.TransactionAccountDetailRepository;
import com.example.banco_hex_yoder.postgresql_repository.data.repositorios.TransactionRepository;
import com.example.banco_hex_yoder.gateway.AccountGateway;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PostgreSQLAccountRepository implements AccountGateway {


    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionAccountDetailRepository transactionAccountDetailRepository;

    public PostgreSQLAccountRepository(AccountRepository accountRepository,
                                       TransactionRepository transactionRepository,
                                       TransactionAccountDetailRepository transactionAccountDetailRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.transactionAccountDetailRepository = transactionAccountDetailRepository;
    }
    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id).map(this::toDomain);
    }


    @Override
    public Optional<Account> findByNumber(Integer number) {
        return accountRepository.findByNumber(number).map(this::toDomain);
    }

    @Override
    public Account save(Account account) {
        CuentaEntity entity = toEntity(account);
        return toDomain(accountRepository.save(entity));
    }

    @Override
    public void updateBalance(Integer accountId, BigDecimal newBalance) {
        accountRepository.findById(accountId).ifPresent(entity -> {
            entity.setAmount(newBalance);
            accountRepository.save(entity);
        });
    }


    @Override
    public void registrarTransaccion(BigDecimal monto, BigDecimal costo, String tipoTransaccion, Integer cuentaOrigenNumber, Integer cuentaDestinoNumber) {
        TransaccionEntity transaccion = new TransaccionEntity();
        transaccion.setAmountTransaction(monto);
        transaccion.setTransactionCost(costo);
        transaccion.setTypeTransaction(tipoTransaccion);
        transaccion.setTimeStamp(LocalDateTime.now());

        // Guarda la transacción en la base de datos
        try {
            System.out.println("Intentando guardar transacción: " + transaccion);
            transactionRepository.save(transaccion);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar la transacción: " + e.getMessage());
        }

        // Busca las entidades de cuenta
        CuentaEntity cuentaOrigen = accountRepository.findByNumber(cuentaOrigenNumber)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada"));
        CuentaEntity cuentaDestino = accountRepository.findByNumber(cuentaDestinoNumber)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta destino no encontrada"));

        // Registra el detalle de la transacción para la cuenta origen
        TransactionAccountDetailEntity detalleOrigen = new TransactionAccountDetailEntity(
                transaccion, cuentaOrigen, "ordenante");



        transactionAccountDetailRepository.save(detalleOrigen);

        // Registra el detalle de la transacción para la cuenta destino
        TransactionAccountDetailEntity detalleDestino = new TransactionAccountDetailEntity(
                transaccion, cuentaDestino, "beneficiario");
        transactionAccountDetailRepository.save(detalleDestino);
    }
    private Transaction toDomain(TransaccionEntity entity) {
        return new Transaction(entity.getId(), entity.getAmountTransaction(), entity.getTransactionCost(),
                entity.getTypeTransaction(), entity.getTimeStamp());
    }

    private Account toDomain(CuentaEntity entity) {
        return new Account(entity.getId(), entity.getNumber(), entity.getAmount(),
                entity.getCreatedAt(), entity.getIsDeleted());
    }

    private CuentaEntity toEntity(Account account) {
        CuentaEntity entity = new CuentaEntity();
        entity.setId(account.getId());
        entity.setNumber(account.getNumber());
        entity.setAmount(account.getAmount());
        entity.setCreatedAt(account.getCreatedAt());
        entity.setIsDeleted(account.getIsDeleted());
        return entity;
    }
}
