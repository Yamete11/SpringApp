package group.spring.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ProductPurchase")
@Table
public class ProductPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer quantity;
    private String description;
    private Float price;

    private Long idPurchase;
    private Long idProduct;

    @ManyToMany
    @JoinTable(
            name = "product_enrolled",
            joinColumns = @JoinColumn(name = "productPurchase_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> enrolledProducts = new HashSet<>();

    public ProductPurchase() {
    }

    public ProductPurchase(Long id, Integer quantity, String description, Float price, Long idPurchase, Long idProduct) {
        this.id = id;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.idPurchase = idPurchase;
        this.idProduct = idProduct;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setIdPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Long getIdPurchase() {
        return idPurchase;
    }

    public Long getIdProduct() {
        return idProduct;
    }
}
