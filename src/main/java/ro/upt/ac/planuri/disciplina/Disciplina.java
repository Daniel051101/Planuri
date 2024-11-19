package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Disciplina 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	private String numeDisciplina;
	private String codDisciplina;
	private int numarCrediteTransferabile;
	private String formaEvaluare;
	private int numarOreCurs; 
	private int numarOreSeminar ;
	private int numarOreLaborator ;
	private int numarOreProiect ;
	private int volumOreNecesareActivitatilorPartialAsistate;
	private String categorieFormativa;
	private int volumOreNecesaraPregatiriIndividuale;
	
	public Disciplina() //constructor
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

	public int getNumarOreCurs() {
		return numarOreCurs;
	}


	public void setNumarOreCurs(int numarOreCurs) {
		this.numarOreCurs = numarOreCurs;
	}


	public int getNumarOreSeminar() {
		return numarOreSeminar;
	}


	public void setNumarOreSeminar(int numarOreSeminar) {
		this.numarOreSeminar = numarOreSeminar;
	}


	public int getNumarOreLaborator() {
		return numarOreLaborator;
	}


	public void setNumarOreLaborator(int numarOreLaborator) {
		this.numarOreLaborator = numarOreLaborator;
	}


	public int getNumarOreProiect() {
		return numarOreProiect;
	}


	public void setNumarOreProiect(int numarOreProiect) {
		this.numarOreProiect = numarOreProiect;
	}


	public int getVolumOreNecesareActivitatilorPartialAsistate() {
		return volumOreNecesareActivitatilorPartialAsistate;
	}


	public void setVolumOreNecesareActivitatilorPartialAsistate(int volumOreNecesareActivitatilorPartialAsistate) {
		this.volumOreNecesareActivitatilorPartialAsistate = volumOreNecesareActivitatilorPartialAsistate;
	}

	public String getCategorieFormativa() {
		return categorieFormativa;
	}


	public void setCategorieFormativa(String categorieFormativa) {
		this.categorieFormativa = categorieFormativa;
	}


	public int getVolumOreNecesaraPregatiriIndividuale() {
		return volumOreNecesaraPregatiriIndividuale;
	}


	public void setVolumOreNecesaraPregatiriIndividuale(int volumOreNecesaraPregatiriIndividuale) {
		this.volumOreNecesaraPregatiriIndividuale = volumOreNecesaraPregatiriIndividuale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
