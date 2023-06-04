package saloncey.d4jmmorpg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Repository.AttributesRepository;

@Service
public class AttributesService {
    private AttributesRepository attributesRepository;

    @Autowired
    AttributesService(AttributesRepository attributesRepository){
        this.attributesRepository = attributesRepository;
    };

    public boolean userExists(Long id){
        return attributesRepository.existsById(id);
    }

    public void addAttributes(Long id){
        Attributes attributes = new Attributes(id);
        attributesRepository.save(attributes);
    }

    public boolean attributesExist(Long id){
            return attributesRepository.existsById(id);
    }


    public Attributes getAttributes(Long userId){
        return attributesRepository.getReferenceById(userId);
    }
}
