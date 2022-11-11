package group.spring.Controllers;

import group.spring.Entities.Product;
import group.spring.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> listOfProducts = productService.getProducts();
        return new ResponseEntity<>(listOfProducts, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                                 @RequestParam(required = false) String title,
                                                 @RequestParam(required = false) Float price,
                                                 @RequestParam(required = false) String type,
                                                 @RequestParam(required = false) String model){
        productService.updateProduct(id, title, price, type, model);
        return new ResponseEntity<>(OK);
    }
}














