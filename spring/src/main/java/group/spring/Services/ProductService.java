package group.spring.Services;

import group.spring.Entities.Product;
import group.spring.Repositories.ProductRepository;
import group.spring.exception.UserNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //GET
    public List<Product> getProducts(){
        return productRepository.findAll();
    }


    //GET
    public Product getProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    //POST
    public Product addProduct(Product product){
        boolean exists = productRepository.findByTitle(product.getTitle());

        if(exists){
            throw new IllegalStateException("Product with provided title already exists");
        }

        return productRepository.save(product);
    }

    //DELETE
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    //PUT
    @Transactional
    public void updateProduct(Long id,
                              String title,
                              Float price,
                              String type,
                              String model){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Product with id " + id + " doesn't exist"));

        if(title != null && title.length() > 0 && !Objects.equals(product.getTitle(), title)){
            Optional<Product> productOptional = productRepository.findProductByTitle(title);
            if(productOptional.isPresent()){
                throw new IllegalStateException("title taken");
            }
            product.setTitle(title);
        }

        product.setPrice(price);
        product.setType(type);
        product.setModel(model);
    }
}
