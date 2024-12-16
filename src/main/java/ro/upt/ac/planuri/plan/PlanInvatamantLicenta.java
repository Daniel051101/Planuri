package ro.upt.ac.planuri.plan;

import jakarta.persistence.Entity;

@Entity
public class PlanInvatamantLicenta extends PlanInvatamant
{
	private String domeniuDeLicenta;
	private String programDeStudiiLicenta;
	private String codDomeniuDeLicenta;	
	private String codStudii;
	
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
	
	public String getCodDomeniuDeLicenta() {
		return codDomeniuDeLicenta;
	}
	
	public void setCodDomeniuDeLicenta(String codDomeniuDeLicenta) {
		this.codDomeniuDeLicenta = codDomeniuDeLicenta;
	}
	
	public String getCodStudii() {
		return codStudii;
	}
	
	public void setCodStudii(String codStudii) {
		this.codStudii = codStudii;
	}
}
