package day17.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {
	

	public void getSalaryByEmployeeIdInput(Connection conn, Scanner sc) {

		System.out.println("Enter employee id whose salary you want to see :");
		int empId = sc.nextInt();

		try {
			PreparedStatement ps = conn.prepareStatement("select salary from employee where eid=?");

			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				System.out.println("Salary of Employee Id: " + empId + " is RS " + rs.getInt("salary") + "/-");
			else
				System.out.println("Invalid Id !");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getAllEmployeesData(Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("<====== Employee " + rs.getInt("eid") + " details ======>");
				System.out.println("Employee name is " + rs.getString("name"));
				System.out.println("Employee address is " + rs.getString("address"));
				System.out.println("Employee salary is " + rs.getInt("salary"));
				System.out.println("<==================================>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addBonus(Connection conn, int bonus) {
		try {
			PreparedStatement ps = conn.prepareStatement("update employee set salary=salary+?");

			ps.setInt(1, bonus);

			int x = ps.executeUpdate();

			if (x > 0)
				System.out.println("Bonus " + bonus + " given to " + x + " employees");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addEmployeeWithoutAddress(Connection conn, Scanner sc) {

		System.out.println("Enter employee id :");
		int eid = sc.nextInt();

		System.out.println("Enter employee name :");
		String name = sc.next();

		System.out.println("Enter employee salary :");
		int salary = sc.nextInt();

		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee (eid, name, salary) values(?,?,?)");

			ps.setInt(1, eid);
			ps.setString(2, name);
			ps.setInt(3, salary);

			int x = ps.executeUpdate();

			if (x == 1)
				System.out.println("Inserted successfully..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getEmployeeByEmployeeIdInput(Connection conn, Scanner sc) {

		System.out.println("Enter employee id whom you want to see :");
		int empId = sc.nextInt();

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("select * from employee where eid=?");
			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println();

				System.out.print(rs.getString("name"));

				if (rs.getString("address") != null) {

					System.out.print(" from " + rs.getString("address"));

				} else {
					System.out.print(" address not available");

					System.out.print(" earning " + rs.getInt("salary") + "/");

					System.out.println();
				}
			} else
				System.out.println("Invalid Id !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getEmployeeSalaryMoreThan(Connection conn, int empSalary) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee where salary>?");

			ps.setInt(1, empSalary);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("<====== Employee " + rs.getInt("eid") + " details ======>");
				System.out.println("Employee name is " + rs.getString("name"));
				System.out.println("Employee address is " + rs.getString("address"));
				System.out.println("Employee salary is " + rs.getInt("salary"));
				System.out.println("<==================================>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
