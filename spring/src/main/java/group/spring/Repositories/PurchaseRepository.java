package group.spring.Repositories;

import group.spring.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT p.email FROM Purchase p WHERE p.email = ?1")
    boolean existsByEmail(String email);
}
