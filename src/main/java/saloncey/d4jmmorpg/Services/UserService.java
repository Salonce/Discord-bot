package saloncey.d4jmmorpg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    };

    public boolean userExists(Long id){
        return userRepository.existsById(id);
    }

 // @Transactional
    public void addUser(Long id){
        if (!userExists(id)) {
            User user = new User();
            user.setId(id);
            user.setAttributes(new Attributes(id));
            userRepository.save(user);
        }
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }
}
