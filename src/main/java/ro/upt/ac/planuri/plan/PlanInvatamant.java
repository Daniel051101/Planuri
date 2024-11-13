package ro.upt.ac.planuri.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanInvatamant 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String universitate;
	private String facultate;
	private String domeniuFundamental;
	private String ramuraDeStiinte;
	private String domeniulDeLicenta;
	private String programulDeStudiiLicenta;
	
	public PlanInvatamant()
	{
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

	public String getDomeniuFundamental() {
		return domeniuFundamental;
	}

	public void setDomeniuFundamental(String domeniuFundamental) {
		this.domeniuFundamental = domeniuFundamental;
	}

	public String getRamuraDeStiinte() {
		return ramuraDeStiinte;
	}

	public void setRamuraDeStiinte(String ramuraDeStiinte) {
		this.ramuraDeStiinte = ramuraDeStiinte;
	}

	public String getDomeniulDeLicenta() {
		return domeniulDeLicenta;
	}

	public void setDomeniulDeLicenta(String domeniulDeLicenta) {
		this.domeniulDeLicenta = domeniulDeLicenta;
	}

	public String getProgramulDeStudiiLicenta() {
		return programulDeStudiiLicenta;
	}

	public void setProgramulDeStudiiLicenta(String programulDeStudiiLicenta) {
		this.programulDeStudiiLicenta = programulDeStudiiLicenta;
	}

	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}

	

}
