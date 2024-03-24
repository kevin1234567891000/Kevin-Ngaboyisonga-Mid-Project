package Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class StudentCourse {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer Credits;
    @Column(nullable = true)
    private String result;
    @ManyToOne
    @JoinColumn(name = "std_id")
    private Student student_reg;

    @ManyToOne
    @JoinColumn(name = "Semester_id")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "Course_Id")
    private Course courseSet;

    public StudentCourse() {
    }

    public StudentCourse(Integer id) {
        Id = id;
    }

    public StudentCourse(Integer id, Integer credits, String result, Student student_reg, Semester semester, Course courseSet) {
        Id = id;
        Credits = credits;
        this.result = result;
        this.student_reg = student_reg;
        this.semester = semester;
        this.courseSet = courseSet;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCredits() {
        return Credits;
    }

    public void setCredits(Integer credits) {
        Credits = credits;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Student getStudent_reg() {
        return student_reg;
    }

    public void setStudent_reg(Student student_reg) {
        this.student_reg = student_reg;
    }

    public Course getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Course courseSet) {
        this.courseSet = courseSet;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
