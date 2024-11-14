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
	public int id;
	
	private String universitate;
	private String facultate;
	
	private String domeniuFundamental;
	private String ramuraDeStiinta;
	private String domeniuDeLicenta;
	private String programDeStudiiLicenta;
	
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

	public String getRamuraDeStiinta() {
		return ramuraDeStiinta;
	}

	public void setRamuraDeStiinta(String ramuraDeStiinta) {
		this.ramuraDeStiinta = ramuraDeStiinta;
	}

	public String getDomeniuDeLicenta() {
		return domeniuDeLicenta;
	}

	public void setDomeniuDeLicenta(String domeniuDeLicenta) {
		this.domeniuDeLicenta = domeniuDeLicenta;
	}

	public String getProgramDeStudiiLicenta() {
		return programDeStudiiLicenta;
	}

	public void setProgramDeStudiiLicenta(String programDeStudiiLicenta) {
		this.programDeStudiiLicenta = programDeStudiiLicenta;
	}

	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}

	

}
