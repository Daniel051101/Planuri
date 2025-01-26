 package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaMaster extends Disciplina
{
	private String categorieFormativaMaster;
	private int numarOreCurs;
	private int numarOreSeminar;
	private int numarOreLaborator;
	private int numarOreProiect;
	
	public DisciplinaMaster()
	{
	}

	public String getCategorieFormativaMaster() {
		return categorieFormativaMaster;
	}

	public void setCategorieFormativaMaster(String categorieFormativaMaster) {
		this.categorieFormativaMaster = categorieFormativaMaster;
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
