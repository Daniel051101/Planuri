package ro.upt.ac.planuri.citire;

public class WriteDemo 
{
	/*
	  public static void main(String[] args) 
	  {
	    //Blank workbook
	    XSSFWorkbook workbook = new XSSFWorkbook();
	
	    //Create a blank sheet
	    XSSFSheet sheet = workbook.createSheet("Employee Data");
	
	    //This data needs to be written (Object[])
	    Map<String, Object[]> data = new TreeMap<String, Object[]>();
	    data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
	    data.put("2", new Object[]{1, "Amit", "Shukla"});
	    data.put("3", new Object[]{2, "Lokesh", "Gupta"});
	    data.put("4", new Object[]{3, "John", "Adwards"});
	    data.put("5", new Object[]{4, "Brian", "Schultz"});
	
	    //Iterate over data and write to sheet
	    Set<String> keyset = data.keySet();
	    int rownum = 0;
	    for (String key : keyset) {
	      Row row = sheet.createRow(rownum++);
	      Object[] objArr = data.get(key);
	      int cellnum = 0;
	      for (Object obj : objArr) {
	        Cell cell = row.createCell(cellnum++);
	        if (obj instanceof String)
	          cell.setCellValue((String) obj);
	        else if (obj instanceof Integer)
	          cell.setCellValue((Integer) obj);
	      }
	    }
	    try 
	    {
	      //Write the workbook in file system
	      //URL url = ReadDemo.class.getClassLoader().getResource(
	      //    "howtodoinjava_demo.xlsx");
	      FileOutputStream out = new FileOutputStream(url.getFile());
	      workbook.write(out);
	      out.close();
	
	      System.out.println("howtodoinjava_demo.xlsx written successfully on " +
	          "disk.");
	
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
  	*/
}
