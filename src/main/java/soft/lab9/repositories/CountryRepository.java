package soft.lab9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.lab9.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
