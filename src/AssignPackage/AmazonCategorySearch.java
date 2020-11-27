package AssignPackage;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class AmazonCategorySearch {
	
	private static final String db = "jdbc:mysql://localhost:3306/AmazonProduct";
	//private static final String dbserver = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String pwd = "root";
	
	private static Connection con;
	//private static Statement stmt;
	//private static ResultSet rs;
	private static PreparedStatement pstmt;

        
          @FindBy(how = How.ID, using = "twotabsearchtextbox")
           private WebElement SearchTextBox;
        
           @FindBy(how = How.XPATH, using = "//input[@type='submit']")
           private WebElement SearchIcon;
        
           @FindBy(how = How.XPATH, using = "(//div[@class='sg-row']/div/div/div/h2/a/span)[1]")
           private WebElement ModelNameCapture;

          
	
	public void insertRecord1(String AppleModel) {
		
		SearchTextBox.sendKeys("apple iphone");
		SearchIcon.click();
		String CapturedModelName = ModelNameCapture.getText();
		
		
		String query1 = "Insert into AmazonProduct.itemlist (ItemNo, ProductName) values (?,?)";
		
		Scanner s1 = new Scanner(System.in);
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con=DriverManager.getConnection(db, user, pwd);
			
			pstmt = con.prepareStatement(query1);
			
			System.out.println("ItemNo:");
			pstmt.setInt(1, s1.nextInt());
			
			System.out.println("ProductName:");
			pstmt.setString(2, CapturedModelName);
			
			int ret = pstmt.executeUpdate();
			if (ret == 1) {
				System.out.println("Successfully added a new record");
			}
			else {
				System.out.println("Unable to add a new record");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
			con.close();
			pstmt.close();
			s1.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	}
}
