package ro.upt.ac.planuri.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaMasterRepository extends JpaRepository<DisciplinaMaster,Integer>
{
	DisciplinaMaster findById(int id);
}
