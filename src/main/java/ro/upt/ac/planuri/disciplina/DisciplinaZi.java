package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;

@Entity
public class DisciplinaZi extends Disciplina 
{
	private String categorieFormativaLicenta;
	private int numarOreCurs;
	private int numarOreSeminar;
	private int numarOreLaborator;
	private int numarOreProiect;
	
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

	public String getCategorieFormativaLicenta() {
		return categorieFormativaLicenta;
	}

	public void setCategorieFormativaLicenta(String categorieFormativaLicenta) {
		this.categorieFormativaLicenta = categorieFormativaLicenta;
	}
}
