package co.com.sofka.cuentaflex.accountservice.configuration;

import co.com.sofka.InMemoryAccountRepository;
import co.com.sofka.InMemoryFeesRepository;
import co.com.sofka.gateway.AccountRepository;
import co.com.sofka.gateway.FeesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public AccountRepository getAccountRepository() {
        return new InMemoryAccountRepository();
    }

    @Bean
    public FeesRepository getFeeRepository() {
        return new InMemoryFeesRepository();
    }
}
