package saloncey.d4jmmorpg.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saloncey.d4jmmorpg.Entities.Resources;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources, Long> {
}
