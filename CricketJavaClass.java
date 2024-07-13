package godproject;

/* The java.sql package contains classes and interfaces for JDBC.
 *  Connection class represents a connection to a database in JDBC. 
 *  It allows you to connect to a database, execute SQL queries*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricketJavaClass {
	/* creating global variables/instance so that they can be accesible by swing class event after
	 * function execution*/
	public int instanceNoOfLinks;
	public String instanceDate;
	public String[] instanceDescription=new String[instanceNoOfLinks];
	public String[] instanceTeams=new String[instanceNoOfLinks];
	public String[] instanceScorecardSummery=new String[instanceNoOfLinks];
	public String[] instanceResult=new String[instanceNoOfLinks];
	
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException {
		/* creating object of the class so that other functions of the class can be called*/
		CricketJavaClass object=new CricketJavaClass();
		object.godprojectFunction();
	}

	public void godprojectFunction() throws InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/* WebDriver is an interface in Selenium WebDriver that defines methods for interacting with a web browser.
		 * driver: This is a variable of type WebDriver that will hold an instance of a web browser driver. 
		 * new ChromeDriver(): This part of the statement creates a new instance of ChromeDriver,
		 *  which is a class provided by Selenium WebDriver specifically for automating interactions with the Google Chrome browser.*/
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.espncricinfo.com/");
		driver.manage().window().maximize();
		Thread.sleep(9000);
		//creating string to store date
		String date="23 june 2024";
		//finding search icon and clicking
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[3]/div/nav/div/div/div/div[2]/div[2]/div[6]/i")).click();
		//sending keys to seach button
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[3]/div/nav/div/div/div/div[2]/div[2]/div/form/div/div/div/input")).sendKeys(instanceDate);
		//after sending keys ,clicking enter
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[3]/div/nav/div/div/div/div[2]/div[2]/div/form/div/div/i[2]")).click();
		//finding anchor tag named 'matches' and clicking
//		driver.manage().window().minimize();
		driver.findElement(By.xpath("//*[@id=\"viewport\"]/div[5]/div[2]/main/div/div[3]/ul/li[4]/a")).click();
		//finding total no of links or matches that day
		int noOfLinks = driver.findElements(By.tagName("h3")).size();
		//creating string array to store descriptio of matches
		String[] description =new String[noOfLinks];
		String[] teams=new String[noOfLinks];
		String[] scorecardSummery=new String[noOfLinks];
		String[] result=new String[noOfLinks];
		//navigating to each links or matches
		for(int i=0;i<noOfLinks;i++)
		{
			//initialising list each time to avoid 'slate element not found' error/warning.list is storing links of each matches of that day
			
			List<WebElement> links=driver.findElements(By.tagName("h3"));
			System.out.println(links.get(i).getText());
			links.get(i).click();
			Thread.sleep(1000);
			//finding and clicking on summery
			driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[2]/div/div[1]/a/span")).click();
			Thread.sleep(1000);
			//finding description and storing in webelement desc
			WebElement desc=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]"));
			//storing desc.gettext() in string
			description[i]=desc.getText();
			//finding teams and storing in team1 and team2
			WebElement team1=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/a/span"));
			WebElement team2=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/a/span"));
			//storing team1 and team2 in string
			teams[i]=team1.getText()+" vs "+team2.getText();
			//finding result and storing in webelement Eresult
			WebElement Eresult=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div/p/span"));
			//finding scorecard summery and storing in webelement scorecard
			WebElement scorecardSummery1=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/strong"));
			WebElement scorecardSummery2=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[2]/strong"));
			//storing scorecard in scorecardSummery
			scorecardSummery[i]=team1.getText()+" "+scorecardSummery1.getText()+" And  "+team2.getText()+" "+scorecardSummery2.getText();
			//storing Eresult in string
			result[i]=Eresult.getText();
			//after navigating to desired matches coming back to original list
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(1000);
		}
		
//copying data of all local variables to INSTANCE variables using ' clone() ' method
//		instanceDate=date;
		instanceNoOfLinks = noOfLinks;
		instanceDescription = description.clone();
		instanceTeams = teams.clone();
		instanceScorecardSummery = scorecardSummery.clone();
		instanceResult = result.clone();
		
		System.out.println(noOfLinks);
		for(int i=0;i<noOfLinks;i++)
		{
			System.out.println("this is desc : "+description[i]);
			System.out.println("this is teams : "+teams[i]);
			System.out.println("this is summery : "+scorecardSummery[i]);
			System.out.println("this is result : "+result[i]);
		}
		
		/*Class.forName() is a method used to dynamically load and register the JDBC driver class.
		 * com.mysql.cj.jdbc.Driver is the JDBC driver class provided by MySQL Connector/J, 
		 * which is the JDBC driver for MySQL databases. */
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/*Connection con: This part of the statement declares a variable con of type Connection. 
		 * Once getConnection(...) successfully establishes a connection to the MySQL database , 
		 * it returns a Connection object that represents the established database connection. 
		 *DriverManager: it is a class & getConnection(...) is a static method of the DriverManager.
		 * used to create a connection to a database. It takes three parameters:
		 *jdbc:mysql:// indicates the protocol for connecting to a MySQL database.
		 *localhost means the database server is on the same machine as the Java application, 
		 *and 3306 is the default port for MySQL.
		 *cricketproject is the name of the specific database schema or database to which you want to connect.*/
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketproject","root","Root1234");
		System.out.println("connection established");
		for(int i=0;i<noOfLinks;i++)
		{
//			PreparedStatement ps=con.prepareStatement("insert into myproject_table values ('"+date+"','"+teams[i]+"','"+description[i]+"','"+scorecardSummery[i]+"','"+result[i]+"')");
			
			/*PreparedStatement is an interface in Java that represents a precompiled SQL statement. 
			 * It allows you to execute parameterized SQL queries against the database.
			 *ps is the reference variable that holds the PreparedStatement object returned by con.prepareStatement(...). 
			 *You use ps to set parameter values (setString, setInt, etc.) and execute the prepared statement (executeUpdate). */
			
			PreparedStatement ps=con.prepareStatement("insert into myproject_table values(?,?,?,?,?)");
			ps.setString(1, instanceDate);
			ps.setString(2, teams[i]);
			ps.setString(3, description[i]);
			ps.setString(4, scorecardSummery[i]);
			ps.setString(5, result[i]);
			
			/*When you call ps.executeUpdate(),the prepared SQL statement is executed against the database. */
			int confirmation=ps.executeUpdate();
			//if executeUpdate succeds than it returns number>0
			if(confirmation>0)
			{
				System.out.println("row no "+(i+1)+" inserted");
			}
			else
				System.out.println("row no "+(i+1)+" insertion failed");
			if(i==(noOfLinks-1))
				ps.close();
		}
		//closing the connection
		
		con.close();
		System.out.println("susscess and program end here saurabh!");
	}

}
