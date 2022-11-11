package group.spring.Repositories;

import group.spring.Entities.ProductPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase, Long> {
}
