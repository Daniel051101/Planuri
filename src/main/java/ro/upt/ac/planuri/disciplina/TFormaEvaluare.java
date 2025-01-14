package ro.upt.ac.planuri.disciplina;

public enum TFormaEvaluare 
{
	E("Examen","E"),
	D("Evaluare distribuita","D"),
	C("Colocviu","C"),
	P_E("Proiect autonom cu examinare ca si in cazul disciplinelor cu examen","P_E"),
	P_D("Proiect autonom cu examinare","P_D");
	
	private String numeLung;
	private String numeScurt;
	
	TFormaEvaluare(String numeLung,String numeScurt)
	{
		this.numeLung=numeLung;
		this.numeScurt=numeScurt;
	}
	
	public String getNumeLung()
	{
		return numeLung;
	}
	
	public String getNumeScurt()
	{
		return numeScurt;
	}
}
