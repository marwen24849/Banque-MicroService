package fsb.ucar.ClientService;

import fsb.ucar.ClientService.entites.BankAccount;
import fsb.ucar.ClientService.enums.AccountType;
import fsb.ucar.ClientService.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountService service){
		return args -> {
			BankAccount account1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(98000)
					.createdAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount account2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAR")
					.balance(Math.random()*100000)
					.createdAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			service.add(account1);
			service.add(account2);
		};
	}

}
