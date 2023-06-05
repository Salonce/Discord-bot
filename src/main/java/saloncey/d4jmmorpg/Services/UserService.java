package saloncey.d4jmmorpg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Entity.Equipment;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Repository.AttributesRepository;
import saloncey.d4jmmorpg.Repository.BelongingRepository;
import saloncey.d4jmmorpg.Repository.EquipmentRepository;
import saloncey.d4jmmorpg.Repository.UserRepository;

import java.time.Duration;
import java.time.Instant;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    private BelongingRepository belongingRepository;

    @Autowired
    private AttributesRepository attributesRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

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

        if (!equipmentRepository.existsById(id)) {
            Equipment equipment = new Equipment();
            equipment.setUser(userRepository.getReferenceById(id));
            equipmentRepository.save(equipment);
        }
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }


    public final int AP_TIME_REGEN_SEC = 10;
    public final int MAX_AP = 3;

    public boolean useAp(User user, int ap){
        if (getAp(user) >= ap){
            if (getAp(user) == MAX_AP)
                user.setFullApTime(Instant.now().plusSeconds(ap * AP_TIME_REGEN_SEC));
            else
                user.setFullApTime(user.getFullApTime().plusSeconds(ap * AP_TIME_REGEN_SEC));
            return true;
        }
        return false;
    }

    public Long getAp(User user){
        Instant now = Instant.now();
        Instant userApTime = user.getFullApTime();
        Duration maxDuration = Duration.ofSeconds(AP_TIME_REGEN_SEC * MAX_AP);
        Duration timeToMaxAp = Duration.between(now, userApTime);
        if (timeToMaxAp.isNegative())
            return Long.valueOf(MAX_AP);
        else
            return maxDuration.minus(timeToMaxAp).toSeconds()/AP_TIME_REGEN_SEC;
    }

    public Long getApInSec(User user){
        Instant now = Instant.now();
        Instant userApTime = user.getFullApTime();
        Duration timeToMaxAp = Duration.between(now, userApTime);
        return Math.max(timeToMaxAp.toSeconds(), 0);
    }

    public Long getNextApInSec(User user){
        return getApInSec(user)%AP_TIME_REGEN_SEC;
    }
}
