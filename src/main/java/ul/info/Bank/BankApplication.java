package ul.info.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Boolean b=false;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "123");
			statement = connection.createStatement();
			try {
				ResultSet resultSet = statement.executeQuery("select 1 from pg_database where datname = 'Bank'");
				if(!resultSet.next()){
					statement.executeUpdate("CREATE DATABASE \"Bank\"");
					b=true;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		SpringApplication.run(BankApplication.class, args);
		if(b) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank", "postgres", "123");
				statement = connection.createStatement();
				try {
					statement.executeUpdate("INSERT INTO card( amount, created_at, currency, cvv, ex_date, pan, updated_at) VALUES (1000000,'2020-01-22','USD', '123', '2024-01-01', '1111222233334444' ,'2020-01-22')");
					statement.executeUpdate("INSERT INTO card( amount, created_at, currency, cvv, ex_date, pan, updated_at) VALUES (2000000,'2020-01-22','LBP', '123', '2024-01-01', '1234123412341234' ,'2020-01-22')");
					statement.executeUpdate("INSERT INTO card( amount, created_at, currency, cvv, ex_date, pan, updated_at) VALUES (2000000,'2020-01-22','USD', '123', '2024-01-01', '1122334455667788' ,'2020-01-22')");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
