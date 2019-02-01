package dto;

public class StudentCourse {
	private String scid;
	private String scmark;
	private Course course; 	//ctype;cterm;cid
	private String id;//stuid
	private Student student;
	private String name;//stuname	
	private String cid;
	private String cname;
	private String cyear;	
	private String cterm;
	private String cshangke;	
	private String cteacher;	
	private String ctype;	
	private String cexam;	
	private String[]  cweekday;	
	private String[]  cjieshu;		
	private String  cplace;		
	
	public String getScid() {
		return scid;
	}
	public void setScid(String scid) {
		this.scid = scid;
	}
	public String getScmark() {
		return scmark;
	}
	public void setScmark(String scmark) {
		this.scmark = scmark;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCyear() {
		return cyear;
	}
	public void setCyear(String cyear) {
		this.cyear = cyear;
	}
	public String getCterm() {
		return cterm;
	}
	public void setCterm(String cterm) {
		this.cterm = cterm;
	}
	public String getCexam() {
		return cexam;
	}
	public void setCexam(String cexam) {
		this.cexam = cexam;
	}
	public String getCshangke() {
		return cshangke;
	}
	public void setCshangke(String cshangke) {
		this.cshangke = cshangke;
	}
	public String getCteacher() {
		return cteacher;
	}
	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String[] getCweekday() {
		return cweekday;
	}
	public void setCweekday(String[] cweekday) {
		this.cweekday = cweekday;
	}
	public String[] getCjieshu() {
		return cjieshu;
	}
	public void setCjieshu(String[] cjieshu) {
		this.cjieshu = cjieshu;
	}
	public String getCplace() {
		return cplace;
	}
	public void setCplace(String cplace) {
		this.cplace = cplace;
	}
	
	
}
