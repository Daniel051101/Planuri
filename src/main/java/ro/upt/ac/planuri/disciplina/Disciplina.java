package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public enum FE{
	E, //Examen
	D, //Evaluare distribuita
	C, //Colocviu
	P_E, //proiect autonom cu examinare ca si in cazul disciplinelor cu examen
	P_D //proiect autonom cu examinare
}

public enum CF{
	DC, //Disciplina complementara
	DD, //Disciplina in domeniu
	DF, //Disciplina fundamentala
	DS //Disciplina de specialitate
}

@Entity
public class Disciplina 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String cod_diciplina;
	private int numar_credite; 
	@Enumerated(EnumType.STRING)
	private FE forma_evaluare ; //(E,D,C,P-E,P-D)forma de evaluare
	private int act_autoinstruire; //numar ore activitati de autoinstruire
	private int act_tutorat ; //numar ore activitati de tutorat
	private int teme_control ; //teme de control/evaluare pe parcurs
	private int act_aplicative ; //activitati aplicative asistate
	private int act_partial_asistate ; //volum de ore necesar activitatilor partial asistate/practica
	private CF categorie_formativa ;//(DC, DD, DF, DS) categorie formativa careia ii apartine disciplina
	private int volum_pregatire_individuala; //volum de ore necesa pregatiri individuale
	
	
	public Disciplina() //constructor
	{
		
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getCod_diciplina() {
		return cod_diciplina;
	}
	
	public void setCod_diciplina(String cod_diciplina) {
		this.cod_diciplina = cod_diciplina;
	}
	
	public int getNumar_credite() {
		return numar_credite;
	}
	
	public void setNumar_credite(int numar_credite) {
		this.numar_credite = numar_credite;
	}
	
	public int getAct_autoinstruire() {
		return act_autoinstruire;
	}
	
	public void setAct_autoinstruire(int act_autoinstruire) {
		this.act_autoinstruire = act_autoinstruire;
	}
	
	public int getAct_tutorat() {
		return act_tutorat;
	}
	
	public void setAct_tutorat(int act_tutorat) {
		this.act_tutorat = act_tutorat;
	}
	
	public int getTeme_control() {
		return teme_control;
	}
	
	public void setTeme_control(int teme_control) {
		this.teme_control = teme_control;
	}
	
	public int getAct_aplicative() {
		return act_aplicative;
	}
	
	public void setAct_aplicative(int act_aplicative) {
		this.act_aplicative = act_aplicative;
	}
	
	public int getAct_partial_asistate() {
		return act_partial_asistate;
	}
	
	public void setAct_partial_asistate(int act_partial_asistate) {
		this.act_partial_asistate = act_partial_asistate;
	}
	
	public CF getCategorie_formativa() {
		return categorie_formativa;
	}
	
	public void setCategorie_formativa(CF categorie_formativa) {
		this.categorie_formativa = categorie_formativa;
	}
	
	public int getVolum_pregatire_individuala() {
		return volum_pregatire_individuala;
	}
	
	public void setVolum_pregatire_individuala(int volum_pregatire_individuala) {
		this.volum_pregatire_individuala = volum_pregatire_individuala;
	}
	
}