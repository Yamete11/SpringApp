package group.spring.Services;

import group.spring.Entities.Purchase;
import group.spring.Repositories.PurchaseRepository;
import group.spring.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    //GET
    public List<Purchase> getPurchases(){
        return purchaseRepository.findAll();
    }

    //GET
    public Purchase getPurchase(Long id){
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("purchase with id " + id + " not found"));
    }

    //POST
    public Purchase addPurchase(Purchase purchase){
        boolean exists = purchaseRepository.existsByEmail(purchase.getEmail());

        if(exists){
            throw new IllegalStateException("Purchase with email " + purchase.getEmail() + " already exists");
        }
        return purchaseRepository.save(purchase);
    }

    //DELETE
    public void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }


    //UPDATE
    public void updatePurchase(Long id,
                               String name,
                               String surname,
                               String email,
                               String telNumber){

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Purchase with id " + id + " doesn't exist"));

        purchase.setName(name);
        purchase.setSurname(surname);
        purchase.setEmail(email);
        purchase.setTelNumber(telNumber);

    }
}
