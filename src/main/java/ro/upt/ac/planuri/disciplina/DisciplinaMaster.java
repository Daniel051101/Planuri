package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaMaster extends Disciplina
{
	private String categorieFormativaMaster;
	private String numarOreCurs;
	private String numarOreSeminar;
	private String numarOreLaborator;
	private String numarOreProiect;
	
	public DisciplinaMaster()
	{
	}

	public String getCategorieFormativaMaster() {
		return categorieFormativaMaster;
	}

	public void setCategorieFormativaMaster(String categorieFormativaMaster) {
		this.categorieFormativaMaster = categorieFormativaMaster;
	}

	public String getNumarOreCurs() {
		return numarOreCurs;
	}

	public void setNumarOreCurs(String numarOreCurs) {
		this.numarOreCurs = numarOreCurs;
	}

	public String getNumarOreSeminar() {
		return numarOreSeminar;
	}

	public void setNumarOreSeminar(String numarOreSeminar) {
		this.numarOreSeminar = numarOreSeminar;
	}

	public String getNumarOreLaborator() {
		return numarOreLaborator;
	}

	public void setNumarOreLaborator(String numarOreLaborator) {
		this.numarOreLaborator = numarOreLaborator;
	}

	public String getNumarOreProiect() {
		return numarOreProiect;
	}

	public void setNumarOreProiect(String numarOreProiect) {
		this.numarOreProiect = numarOreProiect;
	}
}
