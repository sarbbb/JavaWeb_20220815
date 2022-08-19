package mvc.dao;

/*
 * 
 *
 *
建立資料庫
CREATE DATABASE web CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
建立資料表
create table if not exists user(
	id int not null auto_increment,
	username varchar(50) not null unique,
	password varchar(255) not null,
	salary varbinary(255) not null,
	createtime timestamp default current_timestamp,
	primary key (id)
);
 * 
 *  
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import mvc.entity.User;

public class UserDao {
	
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
			String db_ursername = "root";
			String db_password = "12345678";
			conn = DriverManager.getConnection(db_url, db_ursername, db_password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int add(User user) {
		int rowcount = 0;
		String sql = "insert into user(username,password,salary) values (?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setBytes(3, user.getSalary());
			rowcount = pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
}
