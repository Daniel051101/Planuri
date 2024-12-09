package ro.upt.ac.planuri.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaZiRepository extends JpaRepository<DisciplinaZi,Integer>
{
	DisciplinaZi findById(int id);

	void save(DisciplinaId d2);
}
