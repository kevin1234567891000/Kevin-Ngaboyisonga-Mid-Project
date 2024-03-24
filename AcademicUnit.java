package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private CourseEnum programType;
    @ManyToOne
    @JoinColumn(name = "parentId", nullable = true)
    private AcademicUnit academicUnit;

    @OneToMany(mappedBy = "academicUnit")
    private List<Course> courses = new ArrayList<>();
    @OneToMany(mappedBy = "studentReg")
    private List<StudentReg> studentRegList = new ArrayList<>();

    public AcademicUnit() {
    }

    public AcademicUnit(Integer id) {
        this.id = id;
    }

	public AcademicUnit(Integer id, String code, String name, CourseEnum programType, AcademicUnit academicUnit,
			List<Course> courses, List<StudentReg> studentRegList) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.programType = programType;
		this.academicUnit = academicUnit;
		this.courses = courses;
		this.studentRegList = studentRegList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CourseEnum getProgramType() {
		return programType;
	}

	public void setProgramType(CourseEnum programType) {
		this.programType = programType;
	}

	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<StudentReg> getStudentRegList() {
		return studentRegList;
	}

	public void setStudentRegList(List<StudentReg> studentRegList) {
		this.studentRegList = studentRegList;
	}
    
}