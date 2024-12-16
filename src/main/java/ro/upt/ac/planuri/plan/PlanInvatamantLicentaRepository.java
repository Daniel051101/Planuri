package ro.upt.ac.planuri.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanInvatamantLicentaRepository extends JpaRepository<PlanInvatamantLicenta,Integer>
{
	PlanInvatamantLicenta findById(int id);
}

