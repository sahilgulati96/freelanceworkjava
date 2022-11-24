package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Main {

	public static void main(String args[]) throws CsvValidationException, IOException {

		getvalue("Infrastructure as Code","CI/CD Deployment");
	}

	public static void getvalue(String row, String col) throws CsvValidationException, IOException {

		File file = new File("Test.csv");
		FileReader filereader = new FileReader(file);
		CSVReader csvReader = new CSVReader(filereader);
		String[] data = csvReader.readNext();
		
		int dataCol = 0;
		for (int i = 0; i < data.length; i++) {
			if(data[i].equalsIgnoreCase(col)) {
				dataCol=i;
			}
		}
		int dataRowtemp =0;
		int dataRow =0;
		String ValueToFind = null;
		while((data=csvReader.readNext())!=null) {
			
			for(int j=0; j< data.length;j++) {
				if(data[j].equalsIgnoreCase(row)) {
					dataRow=dataRowtemp+1;
					ValueToFind=data[dataCol];
					break;
				}
			}
			dataRowtemp++;
		}
		
		System.out.println("Value for "+row+" is: "+ValueToFind);
	}

	public void writecsv() throws InterruptedException, IOException {

		WebDriver wd = Driver.launchbrowser();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		wd.get("https://sahilgulati96.github.io/");

		WebElement table = wd.findElement(By.xpath("//*[@id=\"content\"]/table"));

		File file = new File("Test.csv");

		FileWriter outputfile = new FileWriter(file);

		// create CSVWriter object filewriter object as parameter
		CSVWriter writer = new CSVWriter(outputfile);

		Thread.sleep(3000);

		int numOfCol = wd.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td")).size();

		int numOfRow = wd.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr")).size();

		for (int i = 1; i <= numOfRow; i++) {
			String data[] = new String[numOfCol];
			String tempxpath = "//*[@id=\"content\"]/table/tbody/tr[" + i + "]";
			System.out.println(tempxpath);
			WebElement row = table.findElement(By.xpath(tempxpath));

			for (int j = 1; j <= numOfCol; j++) {
				String tempcol = tempxpath + "/td[" + j + "]";
				System.out.println("Temp col is :" + tempcol);
				WebElement col = row.findElement(By.xpath(tempcol));
				data[j - 1] = col.getText();

			}
			writer.writeNext(data);

		}
		writer.close();
		wd.close();
	}

}
