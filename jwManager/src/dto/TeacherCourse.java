package dto;

public class TeacherCourse {
	private String id;
	private String cid;
	private String name;
	private String cname;
	private String cexam;
	private String cyear;
	private String cterm;
	private String cshangke;
	private String ctype;	
	private String cplace;	
	private String[]  cweekday;	
	private String[]  cjieshu;		
	private Course course;
	private Teacher teacher;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCexam() {
		return cexam;
	}
	public void setCexam(String cexam) {
		this.cexam = cexam;
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
	public String getCshangke() {
		return cshangke;
	}
	public void setCshangke(String cshangke) {
		this.cshangke = cshangke;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getCplace() {
		return cplace;
	}
	public void setCplace(String cplace) {
		this.cplace = cplace;
	}
	
}
