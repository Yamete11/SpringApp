package group.spring.Repositories;

import group.spring.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean findByTitle(String title);

    @Query("SELECT p FROM Product p WHERE p.title = ?1")
    Optional<Product> findProductByTitle(String title);
}
