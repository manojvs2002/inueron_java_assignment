package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.sql.CallableStatement;
import java.util.Scanner;



public class StudentDatabase {
	
	static Scanner scan = new Scanner(System.in);
	private static Connection connection = null;
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/db";
			String username = "root";
			String password = "123456";
			connection = DriverManager.getConnection(dbURL,username,password);
			
			Scanner sc =new Scanner(System.in);
			System.out.println("enter the choice 1-insert 2-select 3-selectall 4-update 5-delete 6-transaction ");
			int choice =Integer.parseInt(sc.next());
			
			switch (choice) {
			case 1: {
				
				insert();
				break;
				
				
			}
			case 2:{
				select();
				break;
			}
			
			case 3:{
				selectall();
				break;
			}
			
			case 4:{
				update();
				break;
			
			}
			case 5:{
				delete();
				break;
			
			}
			case 6:{
				transaction();
				break;
			}
			default:
				break;
			}
			
		} catch (Exception e) {
			throw new RuntimeException("not found");
		}
		
	}

	private static void transaction() throws SQLException {
		// TODO Auto-generated method stub
		int i=2;
		
		System.out.println("enter the records");

		String sql1 = "insert into student(name,marks) values ('rama',90)";
		String sql2 = "insert into student(name,marks) values ('shyama',60)";
		
		PreparedStatement statement = connection.prepareStatement(sql1);
		statement = connection.prepareStatement(sql2);
		
		int row1=statement.executeUpdate();
		int row2=statement.executeUpdate();
		
		if(row1>0 && row2>0) {
			connection.commit();
		}else {
			connection.rollback();
		}
		
	}

	private static void delete() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("enter the rollno to br deleted");
		int number = scan.nextInt();
		String sql = "delete from student where rollno = "+number;
		
		Statement statement = connection.createStatement();
		
	//	ResultSet res = statement.executeQuery(sql);
		
		int rows =statement.executeUpdate(sql);
		
		if(rows>0) {
			System.out.println("deleted sucessfully");
		}
		
		
	}

	private static void update() throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("enter the roll no");
		int number = Integer.parseInt(scan.nextLine());
		String sql = "select * from student where rollno = "+number;
		 Statement state = connection.createStatement();
		ResultSet result = state.executeQuery(sql);
		
		if(result.next()) {
		
			int rollnum = result.getInt("rollno");
			String name = result.getString("name");
			int marks = result.getInt("marks");
			
			System.out.println("rollno is "+rollnum	);
			System.out.println("name   is "+name);
			System.out.println("marks  is "+marks);
			
			System.out.println("what do you wnat to change 1-name 2-marks");
			
			int choice=scan.nextInt();
			
			 String sql1 = "update student set ";
			switch (choice) {
			case 1: {
				System.out.println("enetr the name to be update");
				String newname = scan.next();
				sql1= sql1+"name = ? where rollno = "+number;
				 //System.out.println("name is updated");
				 PreparedStatement prepare = connection.prepareStatement(sql1);
				prepare.setString(1, newname);
				 
				 int rows = prepare.executeUpdate();
				 if(rows > 0) {
					 System.out.println("record updated successfully");
				 }
				 //System.out.println("enetr 0 for break or 1 for continue");
				break;
				
			}
			case 2: {
				
				 System.out.println("marks is updated");
				break;
			}
			default:
				break;
			}
			
			
			
		}
		else {
					
			System.out.println("records not found");
				}
		
		
	}

	private static void select() throws SQLException {
		System.out.println("");
		
		System.out.println("enter the roll no");
		int number = Integer.parseInt(scan.nextLine());
		String sql = "select * from student where rollno = "+number;
		Statement state = connection.createStatement();
		
		ResultSet res= state.executeQuery(sql);
		
		if(res.next()) {
			int rollnumber = res.getInt("rollno");
			String name = res.getString("name");
			int mark = res.getInt("marks");
			
			System.out.println("rollno is "+rollnumber);
			System.out.println("name   is "+name);
			System.out.println("marks  is "+mark);
			
			
		}else
		{
			System.out.println("no data found");
		}
	
	}
	
	
	
private static void selectall() throws SQLException {
		
		CallableStatement callable =  connection.prepareCall("{ call GET_ALL() }");
		 
	     
		
		ResultSet result = callable.executeQuery(); 
		
		while(result.next()) {
			System.out.println("roll is"+result.getInt("rollno"));
			System.out.println("name is"+result.getString("name"));
			System.out.println("marks is "+result.getInt("marks"));
		}
		 
	}

	private static void insert() throws SQLException {
		System.out.println("enter the records");
		String sql = "insert into student(name,marks) values (?,?)";
		Scanner sc = new Scanner(System.in);
		
		PreparedStatement state =  connection.prepareStatement(sql);
		System.out.println("enter the name and marks");
		state.setString(1, sc.nextLine());
		state.setDouble(2, Double.parseDouble(sc.nextLine()));
		
		
		
		int rows = state.executeUpdate();
		
		if(rows>0) {
			System.out.println("inserted sucessfully");
		}
		
		
	}
}
