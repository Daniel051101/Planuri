package ro.upt.ac.planuri.utilizatori;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> 
{
    Optional<Role> findByName(String name);
}


