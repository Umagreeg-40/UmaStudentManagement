package com.miniProject;

import java.util.Scanner;

public class Student
{
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String emailId;
	private String mblNo;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 800;
	private static int id = 1000;

	// Constructor prompt user to enter student's name and details

	public Student() 
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter student first name: ");
		firstName = scan.nextLine();

		System.out.println("Enter student last name: ");
		lastName = scan.nextLine();

		System.out.println("Enter student Age: ");
		age = scan.nextInt();

		System.out.println("Enter student Email Id: ");
		emailId = scan.next();

		System.out.println("Enter student Gender:(M/F) ");
		gender = scan.next();

		System.out.println("Enter student Mobile No: ");
		mblNo = scan.next();
	}

	public void studentYear() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Press \n 1 for Fresher \n 2 for Junior \n 3 for Senior \n Enter student class level: ");
		gradeYear = scan.nextInt();

		if (gradeYear == 1 || gradeYear == 2 || gradeYear == 3) 
		{
			setStudentID();
		} 
		else 
		{
			System.out.println("Sorry!! Enter the correct year for Course Enrollment...");
			studentYear();
		}
	}

	// Generate an ID

	private void setStudentID()
	{
		// Grade Level + ID
		id++;
		studentID = gradeYear + "" + id;
	}

	// Enroll in courses

	public void enroll() 
	{
		do 
		{
			System.out.print("Enter course to enroll (0 to quit): ");
			Scanner scan = new Scanner(System.in);
			String course = scan.nextLine();

			if(!course.equals("0")) 
			{ 
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse; 
			}
			else 
			{
				break; 
			}
		} while (1 != 0);
	}

	// View balance

	public void viewBalance()
	{
		System.out.println("Your balance is: $" + tuitionBalance);
	}

	// Pay Tuition

	public void payTuition()
	{
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner scan = new Scanner(System.in);
		int payment = scan.nextInt();

		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
	}

	public void eligibleTest()
	{
		System.out.println("Enter your attendance percentage: ");
		Scanner scan = new Scanner(System.in);
		int attPer = scan.nextInt();

		if(attPer > 70 && tuitionBalance == 0) 
		{
			System.out.println("Permitted!!..You are Eligible for Course Exam");
		}

		else 
		{
			System.out.println("Not Permitted!!..You are not Eligible for Course Exam"); 
		}
	}

	// Show status

	public String toString() 
	{
		System.out.println("*******************************");
		return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nGender: " + gender + "\nEmail ID: "
		+ emailId + "\nMobile No: " + mblNo + "\nGrade Level: " + gradeYear + "\nStudent ID: " + studentID + "\nCourses Enrolled:"
		+ courses + "\nBalance: $" + tuitionBalance + "\nThank you for the user...";
	}
}
