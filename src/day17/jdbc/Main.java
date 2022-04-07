package day17.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String url = "jdbc:mysql://localhost:3306/db1";

		try (Connection conn = DriverManager.getConnection(url, "root", "chirag")) {
			Employee employee = new Employee();
			employee.getSalaryByEmployeeIdInput(conn, sc);
			employee.getAllEmployeesData(conn);
			employee.addBonus(conn, 500);
			employee.addEmployeeWithoutAddress(conn, sc);
			employee.getEmployeeByEmployeeIdInput(conn, sc);
			employee.getEmployeeSalaryMoreThan(conn, 80000);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
