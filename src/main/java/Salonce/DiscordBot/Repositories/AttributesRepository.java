package Salonce.DiscordBot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Salonce.DiscordBot.Entities.Attributes;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {
}
