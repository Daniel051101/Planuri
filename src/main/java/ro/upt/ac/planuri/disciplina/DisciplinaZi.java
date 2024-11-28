package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaZi extends Disciplina 
{
	private int numarOreCurs; //la ID avem numarOreActivitatiAutoinstruire 
	private int numarOreSeminar; //la ID avem numarOreActivitatiTutorat
	private int numarOreLaborator; //la ID avem numarTemeDeControl
	private int numarOreProiect; //la ID avem numarActivitatiAplicativeAsistate
	
	public DisciplinaZi()
	{
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

}
