package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class Disciplina 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	private String numeDisciplina;
	private String codDisciplina;
	private String numarCrediteTransferabile;
	private String formaEvaluare;
	private String volumOreNecesareActivitatilorPartialAsistate;
	private String volumOreNecesaraPregatiriIndividuale;
//	private String semestru;
	
	public Disciplina()
	{
	}
	
	public String getNumeDisciplina() {
		return numeDisciplina;
	}

	public void setNumeDisciplina(String numeDisciplina) {
		this.numeDisciplina = numeDisciplina;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNumarCrediteTransferabile() {
		return numarCrediteTransferabile;
	}


	public void setNumarCrediteTransferabile(String numarCrediteTransferabile) {
		this.numarCrediteTransferabile = numarCrediteTransferabile;
	}

	public String getFormaEvaluare() {
		return formaEvaluare;
	}

	public void setFormaEvaluare(String formaEvaluare) {
		this.formaEvaluare = formaEvaluare;
	}

	public String getVolumOreNecesareActivitatilorPartialAsistate() {
		return volumOreNecesareActivitatilorPartialAsistate;
	}

	public void setVolumOreNecesareActivitatilorPartialAsistate(String volumOreNecesareActivitatilorPartialAsistate) {
		this.volumOreNecesareActivitatilorPartialAsistate = volumOreNecesareActivitatilorPartialAsistate;
	}

	public String getVolumOreNecesaraPregatiriIndividuale() {
		return volumOreNecesaraPregatiriIndividuale;
	}

	public void setVolumOreNecesaraPregatiriIndividuale(String volumOreNecesaraPregatiriIndividuale) {
		this.volumOreNecesaraPregatiriIndividuale = volumOreNecesaraPregatiriIndividuale;
	}

//	public String getSemestru() {
//		return semestru;
//	}
//
//	public void setSemestru(String semestru) {
//		this.semestru = semestru;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
