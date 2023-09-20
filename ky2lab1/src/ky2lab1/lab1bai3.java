package ky2lab1;

public class lab1bai3 implements Comparable<lab1bai3> {
    @Override
	public String toString() {
		return "sutdent [studentId=" + studentId + ", studentName=" + studentName + ", semester=" + semester
				+ ", subject=" + subject + "]";
	}

	private String studentId;
    private String studentName;
    private int semester;
    private String subject;

    public void Student(String studentId, String studentName, int semester, String subject) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semester = semester;
        this.subject = subject;
    }

    // các phương thức getter và setter

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

	public lab1bai3() {
		
	}

	public lab1bai3(String studentId, String studentName, int semester, String subject) {
		
		this.studentId = studentId;
		this.studentName = studentName;
		this.semester = semester;
		this.subject = subject;
	}

	@Override
	public int compareTo(lab1bai3 o) {
		return this.getStudentName().compareTo(o.getStudentName());
	}
    
}
