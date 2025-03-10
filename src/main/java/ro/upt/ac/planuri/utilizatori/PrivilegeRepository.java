package ro.upt.ac.planuri.utilizatori;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> 
{
    Optional<Privilege> findByName(String name);
}


