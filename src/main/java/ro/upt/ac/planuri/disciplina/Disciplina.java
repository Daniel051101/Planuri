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
	
	private String codDisciplina;
	private int numarCrediteTransferabile; 
	//@Enumerated(EnumType.STRING)
	private FE formaEvaluare ; //(E,D,C,P-E,P-D)
	private int numarOreCurs; 
	private int numarOreSeminar ;
	private int numarOreLaborator ;
	private int numarOreProiect ;
	private int volumOreNecesareActivitatilorPartialAsistate ;
	private CF categorieFormativa ;//(DC, DD, DF, DS) categorie formativa careia ii apartine disciplina
	private int volumOreNecesaraPregatiriIndividuale;
	
	
	public Disciplina() //constructor
	{
		
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


	public FE getFormaEvaluare() {
		return formaEvaluare;
	}


	public void setFormaEvaluare(FE formaEvaluare) {
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


	public CF getCategorieFormativa() {
		return categorieFormativa;
	}


	public void setCategorieFormativa(CF categorieFormativa) {
		this.categorieFormativa = categorieFormativa;
	}


	public int getVolumOreNecesaraPregatiriIndividuale() {
		return volumOreNecesaraPregatiriIndividuale;
	}


	public void setVolumOreNecesaraPregatiriIndividuale(int volumOreNecesaraPregatiriIndividuale) {
		this.volumOreNecesaraPregatiriIndividuale = volumOreNecesaraPregatiriIndividuale;
	}


	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}




	
	
	
}