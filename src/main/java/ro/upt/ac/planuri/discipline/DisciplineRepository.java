package ro.upt.ac.planuri.discipline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,Integer>
{
	Discipline findById(int id);
}

