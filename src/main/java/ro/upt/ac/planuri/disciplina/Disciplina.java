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
	
	private String nume;
	private String cod;
	private int numarCrediteTransferabile;
	private String formaEvaluare;
	private int volumOreNecesareActivitatilorPartialAsistate;
	private int volumOreNecesaraPregatiriIndividuale;
//	private String semestru;
	
	public Disciplina()
	{
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getNumarCrediteTransferabile() {
		return numarCrediteTransferabile;
	}


	public void setNumarCrediteTransferabile(int numarCrediteTransferabile) {
		this.numarCrediteTransferabile = numarCrediteTransferabile;
	}

	public String getFormaEvaluare() {
		return formaEvaluare;
	}

	public void setFormaEvaluare(String formaEvaluare) {
		this.formaEvaluare = formaEvaluare;
	}

	public int getVolumOreNecesareActivitatilorPartialAsistate() {
		return volumOreNecesareActivitatilorPartialAsistate;
	}

	public void setVolumOreNecesareActivitatilorPartialAsistate(int volumOreNecesareActivitatilorPartialAsistate) {
		this.volumOreNecesareActivitatilorPartialAsistate = volumOreNecesareActivitatilorPartialAsistate;
	}

	public int getVolumOreNecesaraPregatiriIndividuale() {
		return volumOreNecesaraPregatiriIndividuale;
	}

	public void setVolumOreNecesaraPregatiriIndividuale(int volumOreNecesaraPregatiriIndividuale) {
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
