package com.miniProject;

import java.util.Scanner;

public class StudentDataBase
{
	public static void main(String[] args)
	{
		//Ask how many new users we want to add

		try
		{
			System.out.println("Greeting to Student Management System!!");
			System.out.println("****************************************");
			System.out.println("Welcome to the user......");
			System.out.println("Enter number of students to enroll: ");
			Scanner scan = new Scanner(System.in);
			int numOfStudents = scan.nextInt();

			Student[] students = new Student[numOfStudents];

			//Create a number of new students

			for (int n = 0; n < numOfStudents; n++)
			{
				students[n] = new Student();
				students[n].studentYear();
				students[n].enroll();
				students[n].payTuition();
				students[n].eligibleTest();
			}

			for (int n = 0; n < numOfStudents; n++)
			{
				System.out.println(students[n].toString());
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occurs!!");
			System.out.println("Enter the appropriate values for the given question....");
		}
	}
}
