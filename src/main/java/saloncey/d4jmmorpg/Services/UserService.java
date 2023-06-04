package saloncey.d4jmmorpg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Entity.Inventory;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Repository.AttributesRepository;
import saloncey.d4jmmorpg.Repository.InventoryRepository;
import saloncey.d4jmmorpg.Repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AttributesRepository attributesRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    };

    public boolean userExists(Long id){
        return userRepository.existsById(id);
    }

    @Transactional
    public void addUser(Long id) {
        if (!userExists(id)) {
            //first create parent, only then you can add children (which have foreign keys lulz)
            User user = new User();
            user.setId(id);
            userRepository.save(user); // after saving user stops being the same as user in the db reference
        }
        if (!attributesRepository.existsById(id)){
            Attributes attributes = new Attributes();
            attributes.setUser(userRepository.getReferenceById(id));
            attributesRepository.save(attributes);
        }

        if (!inventoryRepository.existsById(id)) {
            Inventory inventory = new Inventory();
            inventory.setUser(userRepository.getReferenceById(id));
            inventoryRepository.save(inventory);
        }
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }
}
