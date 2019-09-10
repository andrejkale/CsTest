package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.util.List;

public class SearchResultPage extends BasePage {
	@FindBy(xpath="//section[@id='section-search']//div[@class='container']//div[1]//ul[1]//li[position() < 4]//a[1]")
	private List<WebElement> searchResultProducts;

	@FindBy(xpath="//body[1]/section[2]/div[1]/div[2]/div[2]/ul[1]/li[position() < 9]/a[1]")
	private List<WebElement> searchResultJobs;


	public void getProductsFromSearch() throws IOException { // get a list of products and save it in file.txt
	    for(int i = 0; i < searchResultProducts.size(); i++){
			System.out.println(searchResultProducts.get(i).getText());
		}

		File actualResProd = new File("actualProducts.txt");
		Writer csvWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(actualResProd), "UTF-8"));
		for(int i = 0; i < searchResultProducts.size(); i++){
			csvWriter.append(String.join(";","ПРОДУКТИ", searchResultProducts.get(i).getText()));
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
    }

    public void getJobsFromSearch() throws IOException{ //get a list of jobs and save it in file.txt
		for(int i =0; i < searchResultJobs.size(); i++){
			System.out.println(searchResultJobs.get(i).getText());
		}

		File actualResJob = new File("actualJobs.txt");
		Writer csvWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(actualResJob), "UTF-8"));
		for(int i =0; i < searchResultJobs.size(); i++){
			csvWriter.append(String.join(";", "ВАКАНСІЇ", searchResultJobs.get(i).getText()));
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}

	public void mergeSearchResult() throws IOException{ //merge two files.txt to file.csv
		File searchResult = new File("actual/searchResult.csv");
		PrintWriter csvWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(searchResult), "Windows-1251"));

		BufferedReader brProd = new BufferedReader(new FileReader("actualProducts.txt"));
		String lineProd = brProd.readLine();

		while (lineProd  != null)
			{
				csvWriter.println(lineProd);
				lineProd = brProd.readLine();

			}
		BufferedReader brJob = new BufferedReader(new FileReader("actualJobs.txt"));
		String lineJob = brJob.readLine();

			while (lineJob != null)
			{
				csvWriter.println(lineJob);
				lineJob = brJob.readLine();
			}


		csvWriter.flush();
		brProd.close();
		brJob.close();
		csvWriter.close();
	}

}
