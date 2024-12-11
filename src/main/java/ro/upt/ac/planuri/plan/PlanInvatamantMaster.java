package ro.upt.ac.planuri.plan;

import jakarta.persistence.Entity;

@Entity
public class PlanInvatamantMaster extends PlanInvatamant
{
	private String programMaster;
	private String formatInvatamant;
	private int durataStudiilor; //ani
	private String domeniuStudiiMaster;
	private int codDomeniuStudiiMaster;
	
	public PlanInvatamantMaster()
	{
	}
	
	public String getProgramMaster() {
		return programMaster;
	}
	
	public void setProgramMaster(String programMaster) {
		this.programMaster = programMaster;
	}
	
	public String getFormatInvatamant() {
		return formatInvatamant;
	}
	
	public void setFormatInvatamant(String formatInvatamant) {
		this.formatInvatamant = formatInvatamant;
	}
	
	public int getDurataStudiilor() {
		return durataStudiilor;
	}
	
	public void setDurataStudiilor(int durataStudiilor) {
		this.durataStudiilor = durataStudiilor;
	}
	
	public String getDomeniuStudiiMaster() {
		return domeniuStudiiMaster;
	}
	
	public void setDomeniuStudiiMaster(String domeniuStudiiMaster) {
		this.domeniuStudiiMaster = domeniuStudiiMaster;
	}
	
	public int getCodDomeniuStudiiMaster() {
		return codDomeniuStudiiMaster;
	}
	
	public void setCodDomeniuStudiiMaster(int codDomeniuStudiiMaster) {
		this.codDomeniuStudiiMaster = codDomeniuStudiiMaster;
	}
}
