package saloncey.d4jmmorpg.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Inventory;
import saloncey.d4jmmorpg.Repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    Long getItemA(Long id){
        return inventoryRepository.getReferenceById(id).getItemA();
    }

    //@Transactional
    public void addInventory() {
        Inventory inventory = new Inventory();
        inventory.setItemA(10L);
        inventory.setItemB(15L);
        inventoryRepository.save(inventory);

    }
}
