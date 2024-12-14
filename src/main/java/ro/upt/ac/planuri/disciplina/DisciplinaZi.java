package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaZi extends Disciplina 
{
	private String categorieFormativaLicenta;
	private String numarOreCurs;
	private String numarOreSeminar;
	private String numarOreLaborator;
	private String numarOreProiect;
	
	public DisciplinaZi()
	{
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

	public String getCategorieFormativaLicenta() {
		return categorieFormativaLicenta;
	}

	public void setCategorieFormativaLicenta(String categorieFormativaLicenta) {
		this.categorieFormativaLicenta = categorieFormativaLicenta;
	}
}
