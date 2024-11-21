package ro.upt.ac.planuri.disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DisciplinaID 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	private String numeDisciplina;
	private String codDisciplina;
	private int numarCrediteTransferabile;
	private String formaEvaluare;
	private int numarOreActivitatiAutoinstruire; 
	private int numarOreActivitatiTutorat;
	private int numarTemeDeControl;
	private int numarActivitatiAplicativeAsistate ;
	private int volumOreNecesareActivitatilorPartialAsistate;
	private String categorieFormativa;
	private int volumOreNecesaraPregatiriIndividuale;
	
	public DisciplinaID()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeDisciplina() {
		return numeDisciplina;
	}

	public void setNumeDisciplina(String numeDisciplina) {
		this.numeDisciplina = numeDisciplina;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public int getNumarCrediteTransferabile() {
		return numarCrediteTransferabile;
	}

	public void setNumarCrediteTransferabile(int numarCrediteTransferabile) {
		this.numarCrediteTransferabile = numarCrediteTransferabile;
	}

	public String getFormaEvaluare() {
		return formaEvaluare;
	}

	public void setFormaEvaluare(String formaEvaluare) {
		this.formaEvaluare = formaEvaluare;
	}

	public int getNumarOreActivitatiAutoinstruire() {
		return numarOreActivitatiAutoinstruire;
	}

	public void setNumarOreActivitatiAutoinstruire(int numarOreActivitatiAutoinstruire) {
		this.numarOreActivitatiAutoinstruire = numarOreActivitatiAutoinstruire;
	}

	public int getNumarOreActivitatiTutorat() {
		return numarOreActivitatiTutorat;
	}

	public void setNumarOreActivitatiTutorat(int numarOreActivitatiTutorat) {
		this.numarOreActivitatiTutorat = numarOreActivitatiTutorat;
	}

	public int getNumarTemeDeControl() {
		return numarTemeDeControl;
	}

	public void setNumarTemeDeControl(int numarTemeDeControl) {
		this.numarTemeDeControl = numarTemeDeControl;
	}

	public int getNumarActivitatiAplicativeAsistate() {
		return numarActivitatiAplicativeAsistate;
	}

	public void setNumarActivitatiAplicativeAsistate(int numarActivitatiAplicativeAsistate) {
		this.numarActivitatiAplicativeAsistate = numarActivitatiAplicativeAsistate;
	}

	public int getVolumOreNecesareActivitatilorPartialAsistate() {
		return volumOreNecesareActivitatilorPartialAsistate;
	}

	public void setVolumOreNecesareActivitatilorPartialAsistate(int volumOreNecesareActivitatilorPartialAsistate) {
		this.volumOreNecesareActivitatilorPartialAsistate = volumOreNecesareActivitatilorPartialAsistate;
	}

	public String getCategorieFormativa() {
		return categorieFormativa;
	}

	public void setCategorieFormativa(String categorieFormativa) {
		this.categorieFormativa = categorieFormativa;
	}

	public int getVolumOreNecesaraPregatiriIndividuale() {
		return volumOreNecesaraPregatiriIndividuale;
	}

	public void setVolumOreNecesaraPregatiriIndividuale(int volumOreNecesaraPregatiriIndividuale) {
		this.volumOreNecesaraPregatiriIndividuale = volumOreNecesaraPregatiriIndividuale;
	}
	
	

}
