package com.miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLConnector2 
{
	public static void main(String[] args) 
	{
		String first_name = "";
		String last_name = "";
		int age = 0;
		String gender = "";
		String email_id = "";
		String mbl_no = "";
		int grade_year = 0;
		char ch = 'Y';
		do 
		{
			Scanner scan=new Scanner(System.in);

			System.out.println("Enter student First name: "); 
			first_name = scan.next();

			System.out.println("Enter student Last name: ");
			last_name = scan.next();

			System.out.println("Enter student Age : "); 
			age = scan.nextInt();

			System.out.println("Enter student Gender(M/F): "); 
			gender = scan.next();

			System.out.println("Enter student Email ID: "); 
			email_id = scan.next();

			System.out.println("Enter student Mobile No: "); 
			mbl_no = scan.next();

			System.out.println("Enter student Grade Year(1/2/3): "); 
			grade_year = scan.nextInt();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/student","root","");  

				String query = "insert into details(first_name,last_name,age,gender,email_id,mbl_no,grade_year) values(?,?,?,?,?,?,?)";
				PreparedStatement pdstmt = con.prepareStatement(query);

				//set the values
				pdstmt.setString(1,first_name);
				pdstmt.setString(2,last_name);
				pdstmt.setInt(3,age);
				pdstmt.setString(4,gender);
				pdstmt.setString(5,email_id);
				pdstmt.setString(6,mbl_no);
				pdstmt.setInt(7,grade_year);

				//execute
				pdstmt.executeUpdate();

				System.out.println("Success....Query Fired");
			}

			catch(Exception e)
			{
				System.out.println("Exception occurs!!....");
			}
			
			System.out.println("you want to select next option Y/N");
			ch = scan.next().charAt(0);
		}while(ch == 'y' || ch == 'Y');

		if(ch == 'n' || ch == 'N')
		{
			System.exit(0);
		}
	}
}
