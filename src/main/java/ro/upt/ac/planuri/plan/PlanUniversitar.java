package ro.upt.ac.planuri.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanUniversitar 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String universitate;
	private String facultate;
	private String domeniu_fundamental;
	private String ramura_de_stiinte;
	private String domeniul_de_licenta;
	private String programul_de_studii_licenta;
	
	public PlanUniversitar()
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

	public String getUniversitate() {
		return universitate;
	}

	public void setUniversitate(String universitate) {
		this.universitate = universitate;
	}

	public String getFacultate() {
		return facultate;
	}

	public void setFacultate(String facultate) {
		this.facultate = facultate;
	}

	public String getDomeniu_fundamental() {
		return domeniu_fundamental;
	}

	public void setDomeniu_fundamental(String domeniu_fundamental) {
		this.domeniu_fundamental = domeniu_fundamental;
	}

	public String getRamura_de_stiinte() {
		return ramura_de_stiinte;
	}

	public void setRamura_de_stiinte(String ramura_de_stiinte) {
		this.ramura_de_stiinte = ramura_de_stiinte;
	}

	public String getDomeniul_de_licenta() {
		return domeniul_de_licenta;
	}

	public void setDomeniul_de_licenta(String domeniul_de_licenta) {
		this.domeniul_de_licenta = domeniul_de_licenta;
	}

	public String getProgramul_de_studii_licenta() {
		return programul_de_studii_licenta;
	}

	public void setProgramul_de_studii_licenta(String programul_de_studii_licenta) {
		this.programul_de_studii_licenta = programul_de_studii_licenta;
	}

}
