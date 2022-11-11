package group.spring.Controllers;

import group.spring.Entities.Purchase;
import group.spring.Services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "api/v1/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getPurchases(){
        List<Purchase> purchases = purchaseService.getPurchases();
        return new ResponseEntity<>(purchases, OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable Long id){
        Purchase purchase = purchaseService.getPurchase(id);
        return new ResponseEntity<>(purchase, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase){
        Purchase newPurchase = purchaseService.addPurchase(purchase);
        return new ResponseEntity<>(newPurchase, CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Purchase> deletePurchase(@PathVariable Long id){
        purchaseService.deletePurchase(id);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable Long id,
                                                   @RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String surname,
                                                   @RequestParam(required = false) String email,
                                                   @RequestParam(required = false) String telNumber
    ){
        purchaseService.updatePurchase(id, name, surname, email, telNumber);
        return new ResponseEntity<>(OK);
    }
}
