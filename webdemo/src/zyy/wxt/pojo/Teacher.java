package zyy.wxt.pojo;

public class Teacher {
private int id;
private String tname;
private String   salary;
private String    clzss;
private String  institusion;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getClzss() {
	return clzss;
}
public void setClzss(String clzss) {
	this.clzss = clzss;
}
public String getInstitusion() {
	return institusion;
}
public void setInstitusion(String institusion) {
	this.institusion = institusion;
}
public Teacher() {
	super();
	this.id = id;
	this.tname = tname;
	this.salary = salary;
	this.clzss = clzss;
	this.institusion = institusion;
}
   
}
