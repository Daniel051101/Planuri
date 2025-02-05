package ro.upt.ac.planuri.extractori;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.upt.ac.planuri.disciplina.DisciplinaZi;
import ro.upt.ac.planuri.plan.PlanInvatamant;
import ro.upt.ac.planuri.plan.PlanInvatamantLicenta;
import ro.upt.ac.planuri.plan.PlanInvatamantLicentaRepository;

@Component
public class ExtractorLicentaCalcEn extends Extractor
{
    @Autowired
    private PlanInvatamantLicentaRepository planInvatamantLicentaRepository;
    
	private PlanInvatamantLicenta pil = new PlanInvatamantLicenta();
	
	public void extract()
	{
		extract("./data/licenta/2023-2027_AC_PI_C-EN.xlsx");
	}

    public void save()
    {
    	planInvatamantLicentaRepository.save(pil);
    }
	
	public void extract(String path) 
	{
		try
		{
			FileInputStream file = new FileInputStream(path);
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			
			int n = sheet.getLastRowNum();
			int c=0, r=0, index=0, semesterNumber = 0, semesterMax=0;
			String semesterNumberStr;
			
			ArrayList<String> values = new ArrayList<>();
			
			//uni, facultate, coduri
			for(c=0; c<10; c++)
			{
				for (r=0; r<13; r++)
				{
					Row row=sheet.getRow(r);
					if(row==null)
						continue;
					
					Cell cell=row.getCell(c);
					if(cell==null)
						continue;
					
					if ((c==0 && (r>4 && r<9)) || (r==10 && (c>=0 && c<7)))
						continue;
					
					String value=getValue(workbook,cell);
					value=value.replaceAll("\n", " ");
					
					if(value.isEmpty() || value.equals("0"))
						continue;
					
					values.add(value);
					//System.out.println(value);
				}
			}
			index=0;
			
            pil.setUniversitate(values.get(index++));
            pil.setFacultate(index < values.size() ? values.get(index++) : null); 
            pil.setCodDomeniuFundamental(index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
            pil.setCodRamuraDeStiinta(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setCodDomeniuDeLicenta(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setCodStudii(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setCiclu(index < values.size() ? values.get(index++) : null);
            pil.setCodulProgramuluiDeStudii(index < values.size() ? values.get(index++) : null);
            pil.setAnCalendaristic(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setDomeniuFundamental(index < values.size() ? values.get(index++) : null);
            pil.setRamuraDeStiinta(index < values.size() ? values.get(index++) : null);
            pil.setDomeniuDeLicenta(index < values.size() ? values.get(index++) : null);
            pil.setProgramDeStudiiLicenta(index < values.size() ? values.get(index++) : null);
			
            //System.out.println("Datele planului introduse în baza de date!");
            values.clear();
                
			Map<Integer, Integer> rAdjustments=Map.of(
					51, 69,
					103, 141,
				    178, 201,
				    241, 264,
				    304, 326,
				    339, 349,
				    362, n - 1
					);
			
			for(c=1;c<38;c+=12)
			{
				for(r=17;r<n;r++)
				{		
			        if (rAdjustments.containsKey(r)) 
			            r = rAdjustments.get(r);
					
					Row row=sheet.getRow(r);
					if(row==null)
						continue;
					
					Cell cell=row.getCell(c);
					if(cell==null)
						continue;
					
					String value=getValue(workbook,cell);
					value=value.replaceAll("\n", " ");
					
					if(value.isEmpty() || value.equals("0"))
						continue;
					
					if(value.matches("(?i)SEMESTRUL\\s+\\d+"))
					{
					    semesterNumberStr = value.replaceAll("(?i)SEMESTRUL\\s+", "");
					    semesterNumber = Integer.parseInt(semesterNumberStr);
					    
					    if (semesterNumber > semesterMax)
					    	semesterMax = semesterNumber;
					    continue;
					    //System.out.println("Detected semester: " + semesterNumber);
					}
					else
					{
						values.add(value);
						//System.out.println(value);
					}
	
					if (cell.getCellType() == CellType.FORMULA || value.equals("Valoare indisponibilă"))
					{
						for (int k=3; k<12; k++)
						{
							Cell cell1=row.getCell(c+k);
							if(cell1==null)
								continue;
					
							String value1=getValue(workbook,cell1);
							values.add(value1);
							//System.out.println(value1);
						}
					}
				
					DisciplinaZi dz = new DisciplinaZi();
					try 
					{
						if (values.size() >= 11)
						{
				            index=0;
								
							dz.setNume(values.get(index++));
							dz.setCod(index < values.size() ? values.get(index++) : null);
							dz.setNumarCrediteTransferabile(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setFormaEvaluare(index < values.size() ? values.get(index++) : null);
							dz.setNumarOreCurs(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setNumarOreSeminar(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setNumarOreLaborator(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setNumarOreProiect(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setVolumOreNecesareActivitatilorPartialAsistate(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setCategorieFormativaLicenta(index < values.size() ? values.get(index++) : null);
							dz.setVolumOreNecesaraPregatiriIndividuale(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dz.setSemestru(semesterNumber);
								
							pil.getListaDisciplinaZi().add(dz);
												
					        //System.out.println(values.size() + "   Datele disciplinei introduse în baza de date ! \n");
							values.clear();
						}
					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid format: "+dz.toString());
					}
				}
			}
			pil.setDurataStudiiLicenta(semesterMax/2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println("Stopping...);
	}
}
