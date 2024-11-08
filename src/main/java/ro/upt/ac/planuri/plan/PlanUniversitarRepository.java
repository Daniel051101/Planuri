package ro.upt.ac.planuri.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanUniversitarRepository extends JpaRepository<PlanUniversitar,Integer>
{
	PlanUniversitar findById(int id);
}

