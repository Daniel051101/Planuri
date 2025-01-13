package ro.upt.ac.planuri.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaIdRepository extends JpaRepository<DisciplinaId,Integer>
{
	DisciplinaId findById(int id);
}
