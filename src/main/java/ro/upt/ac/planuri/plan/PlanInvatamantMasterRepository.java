package ro.upt.ac.planuri.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanInvatamantMasterRepository extends JpaRepository<PlanInvatamantMaster,Integer>
{
	PlanInvatamantMaster findById(int id);
}

