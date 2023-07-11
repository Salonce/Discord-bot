package Salonce.DiscordBot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Salonce.DiscordBot.Entities.Resources;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources, Long> {
}
