package AnimalShelter.repository;

import AnimalShelter.entity.UserMessages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Long, UserMessages> {
}
