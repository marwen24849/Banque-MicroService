package fsb.ucar.ClientService.repository;

import fsb.ucar.ClientService.entites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount,String> {
}
