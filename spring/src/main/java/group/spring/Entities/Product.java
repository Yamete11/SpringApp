package group.spring.Entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Product")
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private Float price;
    private String type;
    private String model;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledProducts")
    private Set<ProductPurchase> productPurchases = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String title, Float price, String type, String model) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
        this.model = model;
    }

    public Product(String title, Float price, String type, String model) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.model = model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }
}
