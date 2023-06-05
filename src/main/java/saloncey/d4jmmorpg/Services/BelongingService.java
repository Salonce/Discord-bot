package saloncey.d4jmmorpg.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saloncey.d4jmmorpg.Entity.Belonging;
import saloncey.d4jmmorpg.Repository.BelongingRepository;

@Service
public class BelongingService {

    @Autowired
    private BelongingRepository belongingRepository;

    //@Transactional
    public void addBelongings(Long userId, String itemId) {
        belongingRepository.save(new Belonging(userId, itemId));
    }


}
