package co.com.sofka.cuentaflex.accountservice.configuration;

import co.com.sofka.common.TransactionManager;
import co.com.sofka.common.UseCase;
import co.com.sofka.factories.TransactionFactory;
import co.com.sofka.gateway.AccountRepository;
import co.com.sofka.gateway.FeesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "co.com.sofka",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = UseCase.class)
        }
)
public class UseCaseConfiguration {
    @Bean
    public TransactionFactory getTransactionFactory() {
        return new TransactionFactory();
    }

    @Bean
    public TransactionManager getTransactionManager(AccountRepository accountRepository, FeesRepository feesRepository, TransactionFactory transactionFactory) {
        return new TransactionManager(accountRepository, feesRepository, transactionFactory);
    }
}
