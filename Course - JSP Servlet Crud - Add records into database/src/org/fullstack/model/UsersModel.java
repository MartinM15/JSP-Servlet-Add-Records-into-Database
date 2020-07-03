package org.fullstack.model;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.fullstack.entity.User;


public class UsersModel {
	
	public List<User> listUsers(DataSource dataSource) {
		// Step 1: Initialize connection objects
				//PrintWriter out= response.getWriter();
				List<User> listUsers = new ArrayList<>();
				Connection connect = null;
				Statement stmt = null;
				ResultSet rs= null;
				try {
					connect = dataSource.getConnection();
					
					// Step 2: Create a SQL statements string
					String query = "Select * from users";
					stmt = connect.createStatement();
					
					// Step 3: Execute SQL query
					
					rs = stmt.executeQuery(query);
					// Step 4: Process the result set
					while(rs.next()) {
						//out.print("<br/>" + rs.getString("email") + "correos");
						listUsers.add(new User(rs.getInt("users_id"),rs.getString("username"),rs.getString("email")));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return listUsers;
				
	}

}
