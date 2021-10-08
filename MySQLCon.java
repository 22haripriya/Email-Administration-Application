package emailAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class MySQLCon extends EmailDemo
{
	EmailDemo ed1 = new EmailDemo();

		void RetriveRecord() throws ClassNotFoundException, SQLException
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/EmailDB","root","root");
				PreparedStatement ps = con.prepareStatement("select * from employee");
				ResultSet rs = ps.executeQuery();
				System.out.println("Employee Id"+"  FirstName "+"LastName "+"Department "+" Organisation "+" Email "+"                     Password ");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"            "+rs.getString(2)+"      "+rs.getString(3)+"     "+rs.getString(4)+"        "+rs.getString(5)+"           "+rs.getString(6)+"      "+rs.getString(7));
					
				}
			System.out.println();
			}

		void InsertRecord() throws ClassNotFoundException, SQLException
		{
			Scanner sc = new Scanner(System.in);
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/EmailDB","root","root");
			PreparedStatement st = con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?)");
			
			System.out.println("Enter employee Id : ");
			int id = sc.nextInt();
			ed1.setEmpId(id);
			st.setInt(1, id);
			
			System.out.println("Enter Employee First Name : ");
			String fn = sc.next();
			ed1.setFirstname(fn);
			st.setString(2, fn);
			
			System.out.println("Enter Employee Last Name : ");
			String ln = sc.next();
			ed1.setLastname(ln);
			st.setString(3, ln);
						
			System.out.println("Enter Employee Department  : ");
			String dept = sc.next();
			ed1.setDepartment(dept);
			st.setString(4, dept);
			
			System.out.println("Enter Employee Organisation : ");
			String org = sc.next();
			ed1.setOrganisation(org);
			st.setString(5, org);
			
			String genemail = ed1.emailGenrate();
			st.setString(6, genemail);
			
			String genpwd = ed1.passwordGenerate();
			st.setString(7, genpwd);
			
			int j = st.executeUpdate();
			System.out.println(j+" record inserted");
			con.close();
			
			System.out.println();
		}
		
		void DeleteRecord() throws ClassNotFoundException, SQLException
		{
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/EmailDB","root","root");
			PreparedStatement ps = con.prepareStatement("delete from employee where empid=?");
			
			System.out.println("Enter the id of employee : ");
			ps.setInt(1, sc.nextInt());
			
			int i = ps.executeUpdate();
			System.out.println(i+" record deleted");
			con.close();
			System.out.println();
		}
		
		void UpdateRecord() throws ClassNotFoundException, SQLException
		{
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/EmailDB","root","root");
			PreparedStatement ps = con.prepareStatement("update employee set password=? where empid=?");
			

			System.out.println("Enter the id of employee : ");
			ps.setInt(2, sc.nextInt());
			
			System.out.println("Enter the password to be updated :");
			ps.setString(1, sc.next());
			
			int i = ps.executeUpdate();
			System.out.println(i+" record updated");
			con.close();
			
			System.out.println();
		}
		
}
