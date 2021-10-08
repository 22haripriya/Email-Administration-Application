package emailAdmin;

import java.sql.SQLException;
import java.util.Scanner;

class EmailDemo extends passwordDemo implements Employee
{
	private int empId;
	private String firstname;
	private String lastname;
	String email;
	private String password;
	private String department;
	private String organisation;
	
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String emailGenrate() 
	{
		email = firstname+""+lastname+""+"."+department+"@"+organisation+".com";
		return email;
	}
}

class switchCase extends MySQLCon
{
	void menu() throws ClassNotFoundException, SQLException
	{ 
	Scanner sc = new Scanner(System.in);
		
		MySQLCon m = new MySQLCon();
	
		while(true)
		{
			System.out.println("1. Insert Record");
			System.out.println("2. Retrieve Record");
			System.out.println("3. Update Record");
			System.out.println("4. Delete Record");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Choose operation to be performed");
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1: 	m.InsertRecord();
				break;

			case 2: 	m.RetriveRecord();
				break;

			case 3: 	m.UpdateRecord();
				break;
				
			case 4: 	m.DeleteRecord();
				break;
	
			case 5:
				System.exit(0);
			}
		}
	}
}
public class EmployeeDemo extends switchCase
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		switchCase s = new switchCase();
		s.menu();
		
	}
}
