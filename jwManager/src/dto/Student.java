package dto;

public class Student {
	private String id;
	private String name;
	private String stupic;
	private String stusex;
	private String stubirth;
	private String stunation;
	private String stuidentity;
	private String stulook;
	private String stubirthplace;
	private String stutel;
	private String stucontacter;
	private String stuhometel;
	private String stuaddress;
	private String stuemail;
	private String stuenterdate;
	private String stuleavedate;
	private String studepartment;
	private String stumajor;
	private String stuclassid;
	private String stustatus;
	private String sturoomid;
	private String stusum;
	private String stumust;
	private String stuselect;
	private String sturemark;
	private String password;
	private String role;	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStupic() {
		return stupic;
	}
	public void setStupic(String stupic) {
		this.stupic = stupic;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStubirth() {
		return stubirth;
	}
	public void setStubirth(String stubirth) {
		this.stubirth = stubirth;
	}
	public String getStunation() {
		return stunation;
	}
	public void setStunation(String stunation) {
		this.stunation = stunation;
	}
	public String getStuidentity() {
		return stuidentity;
	}
	public void setStuidentity(String stuidentity) {
		this.stuidentity = stuidentity;
	}
	public String getStulook() {
		return stulook;
	}
	public void setStulook(String stulook) {
		this.stulook = stulook;
	}
	public String getStubirthplace() {
		return stubirthplace;
	}
	public void setStubirthplace(String stubirthplace) {
		this.stubirthplace = stubirthplace;
	}
	public String getStutel() {
		return stutel;
	}
	public void setStutel(String stutel) {
		this.stutel = stutel;
	}
	public String getStucontacter() {
		return stucontacter;
	}
	public void setStucontacter(String stucontacter) {
		this.stucontacter = stucontacter;
	}
	public String getStuhometel() {
		return stuhometel;
	}
	public void setStuhometel(String stuhometel) {
		this.stuhometel = stuhometel;
	}
	public String getStuaddress() {
		return stuaddress;
	}
	public void setStuaddress(String stuaddress) {
		this.stuaddress = stuaddress;
	}
	public String getStuemail() {
		return stuemail;
	}
	public void setStuemail(String stuemail) {
		this.stuemail = stuemail;
	}
	public String getStuenterdate() {
		return stuenterdate;
	}
	public void setStuenterdate(String stuenterdate) {
		this.stuenterdate = stuenterdate;
	}
	public String getStuleavedate() {
		return stuleavedate;
	}
	public void setStuleavedate(String stuleavedate) {
		this.stuleavedate = stuleavedate;
	}
	public String getStudepartment() {
		return studepartment;
	}
	public void setStudepartment(String studepartment) {
		this.studepartment = studepartment;
	}
	public String getStumajor() {
		return stumajor;
	}
	public void setStumajor(String stumajor) {
		this.stumajor = stumajor;
	}
	public String getStuclassid() {
		return stuclassid;
	}
	public void setStuclassid(String stuclassid) {
		this.stuclassid = stuclassid;
	}
	public String getStustatus() {
		return stustatus;
	}
	public void setStustatus(String stustatus) {
		this.stustatus = stustatus;
	}
	public String getSturoomid() {
		return sturoomid;
	}
	public void setSturoomid(String sturoomid) {
		this.sturoomid = sturoomid;
	}
	public String getStusum() {
		return stusum;
	}
	public void setStusum(String stusum) {
		this.stusum = stusum;
	}
	public String getStumust() {
		return stumust;
	}
	public void setStumust(String stumust) {
		this.stumust = stumust;
	}
	public String getStuselect() {
		return stuselect;
	}
	public void setStuselect(String stuselect) {
		this.stuselect = stuselect;
	}
	public String getSturemark() {
		return sturemark;
	}
	public void setSturemark(String sturemark) {
		this.sturemark = sturemark;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Student(String id,String name,String stupic,String stusex,String stubirth,
			String stunation,String stuidentity,String stulook,String stubirthplace,String stutel,
			String stucontacter,String stuhometel,String stuaddress,String stuemail,String stuenterdate,
			String stuleavedate,String studepartment,String stumajor,String stuclassid,String stustatus,
			String sturoomid,String stusum,String stumust,String stuselect,String sturemark,String password,
			String role) {
		this.id = id;
		this.name = name;
		this.stupic = stupic;
		this.stusex = stusex;
		this.stubirth = stubirth;
		this.stunation = stunation;
		this.stuidentity = stuidentity;
		this.stulook = stulook;
		this.stubirthplace = stubirthplace;
		this.stutel = stutel;
		this.stucontacter = stucontacter;
		this.stuhometel = stuhometel;
		this.stuaddress = stuaddress;
		this.stuemail = stuemail;
		this.stuenterdate = stuenterdate;
		this.stuleavedate = stuleavedate;
		this.studepartment = studepartment;
		this.stumajor = stumajor;
		this.stuclassid = stuclassid;
		this.stustatus = stustatus;
		this.sturoomid = sturoomid;
		this.stusum = stusum;
		this.stumust = stumust;
		this.stuselect = stuselect;
		this.sturemark = sturemark;
		this.password = password;
		this.role = role;
	}
	public Student() {
		// TODO 自动生成的构造函数存根
	}
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", stusex=" + stusex +",stubirth="+stubirth
				+",stunation="+stunation+",stuidentity="+stuidentity+",stulook="+stulook+",stubirthplace="+stubirthplace
				+",stutel="+stutel+"stucontacter="+stucontacter+",stuhometel="+stuhometel+",stuaddress="+stuaddress
				+"stuemail="+stuemail+",stuenterdate="+stuenterdate+",stuleavedate="+stuleavedate+",studepartment="+studepartment
				+",stumajor="+stumajor+",stuclassid="+stuclassid+",stustatus="+stustatus+",sturoomid="+sturoomid+",stusum="+stusum
				+"stumust="+stumust+",stuselect="+stuselect+"sturemark="+stuselect+"sturemark="+sturemark+"]";
	}
	
	
}