package ro.upt.ac.planuri.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanInvatamantRepository extends JpaRepository<PlanInvatamant,Integer>
{
	PlanInvatamant findById(int id);
}

