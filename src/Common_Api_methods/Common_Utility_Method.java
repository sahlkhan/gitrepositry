package Common_Api_methods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import java.util.Iterator;
public class Common_Utility_Method {
	public static void Evidencecreator(String Filename,String ResponseBody,String RequestBody,int statuscode) throws IOException {
		File TextFile = new File("D:\\mssquare class recording\\RestAssure\\Evidense\\" +Filename+".txt");
		System.out.println("New blank text file of name :" + TextFile.getName());
		
		FileWriter datawrite = new FileWriter(TextFile);
		
		datawrite.write("RequestBody is:" +RequestBody+ "\n\\n");
		datawrite.write("StatusCode is:" +statuscode+ "\n\\n");
		datawrite.write("ResponseBody is:" +ResponseBody+ "\n\\n");
		
		datawrite.close();
		System.out.println("RequestBody and ResponseBody is written in textfile :" +TextFile.getName());
		
	}
	public static ArrayList<String> ReadDataExcel(String sheetname,String TestCaseName ) throws IOException
	{
		ArrayList<String>ArrayData=new ArrayList<String>();
		//Step 1 create the object of file input stream to locate the excel file
		FileInputStream Fis=new FileInputStream("D:\\mssquare class recording\\RestAssure\\Selenium\\SahilRestAssure.xlsx");
		//Step 2 Open the excel file by creating the object XSSFworkbook 
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		//Step 3 open the Desired ExcelSheet
		int countofsheet=WorkBook.getNumberOfSheets();
		for(int i=0;i<countofsheet;i++) {
		String Sheetname=WorkBook.getSheetName(i);
		//Step 4 Access the desired sheet
		if(sheetname.equalsIgnoreCase(sheetname))
				{
			      //Use XSSFSheet to save the sheet into the variable
			      XSSFSheet Sheet=WorkBook.getSheetAt(i);
			      
			      //Create iterator to iterate through rows and find out in which column the test case names are found
			      Iterator<Row> Rows = Sheet.iterator();
			      Row FirstRow = Rows.next();
			      //Create the iterate through the Cell of first row to find out which cell contain test case name
			      Iterator<Cell> CellsOfFirstRow = FirstRow.cellIterator();
			      int k=0;
			      int TC_coloumn=0;
			      while(CellsOfFirstRow.hasNext())
			      {
			    	  Cell CellValue=CellsOfFirstRow.next();
			    	  if(CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName"))
			    	  {
			    		  TC_coloumn=k;
			    		  //System.out.println("Expected coloumn for TestCaseName : " +k);
			    		  break;
			    	  }
			    	  k++;
			      }
			      //Verify the Row where the desired TestCase is found and fetch the entire Row
			      while(Rows.hasNext()) 
			      {
			    	  Row DataRow = Rows.next();
			    	  String TCName=DataRow.getCell(TC_coloumn).getStringCellValue();
			    	  DataRow.getCell(TC_coloumn).getStringCellValue();
			    	  //DataRow.getCell(TC_coloumn).getNumericCellValue()
			    	  if(TCName.equalsIgnoreCase(TestCaseName))
			    	  {
			    		  
			    		  Iterator<Cell> CellValues = DataRow.cellIterator();
			    		  while(CellValues.hasNext())
			    		  {
			    			  String Data="";
			    			  Cell CurrentCell=CellValues.next();
			    			  try
			    			  {
				    			  String StringData = CurrentCell.getStringCellValue();
				    			  Data=StringData;
			    			  }
			    			  catch(IllegalStateException e) 
			    			  {
		                         double doubledata=CurrentCell.getNumericCellValue();
		                         Data=Double.toString(doubledata);
			    			  }
			    			  ArrayData.add(Data);
			    		  }
			    		  break;
			    	  }
			      }
		        }	
		}
		return ArrayData;
	}
}                                                                                                               
	