package ro.upt.ac.planuri.plan;

import jakarta.persistence.Entity;

@Entity
public class PlanInvatamantLicenta extends PlanInvatamant
{
	private String domeniuDeLicenta;
	private String programDeStudiiLicenta;
	private int codDomeniuDeLicenta;	
	private int codStudii;
	
	public PlanInvatamantLicenta()
	{
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
	
	public int getCodDomeniuDeLicenta() {
		return codDomeniuDeLicenta;
	}
	
	public void setCodDomeniuDeLicenta(int codDomeniuDeLicenta) {
		this.codDomeniuDeLicenta = codDomeniuDeLicenta;
	}
	
	public int getCodStudii() {
		return codStudii;
	}
	
	public void setCodStudii(int codStudii) {
		this.codStudii = codStudii;
	}
}
