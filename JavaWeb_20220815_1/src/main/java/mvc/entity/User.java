package mvc.entity;

import java.util.Arrays;
import java.util.Date;

public class User {
	private Integer id;
	private String username;
	private String password;  // MD5 password
	private byte[] salary;   // DES 解密後的資料
	private String salaryDecrypt;
	private Date createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getSalary() {
		return salary;
	}
	public void setSalary(byte[] salary) {
		this.salary = salary;
	}
	public String getSalaryDecrypt() {
		return salaryDecrypt;
	}
	public void setSalaryDecrypt(String salaryDecrypt) {
		this.salaryDecrypt = salaryDecrypt;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salary="
				+ Arrays.toString(salary) + ", salaryDecrypt=" + salaryDecrypt + ", createtime=" + createtime + "]";
	}

}