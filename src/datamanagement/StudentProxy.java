package datamanagement;

public class StudentProxy implements IStudent {
    private Integer id_;
    private String firstName_;
    private String lastName_;
    private StudentManager students;

    public StudentProxy(Integer id, String fn, String Il) {
        this.id_ = id;
        this.firstName_ = fn;


        this.lastName_ = Il;
        this.students = StudentManager.get();
    }

    public Integer getID() {
        return id_;
    }

    public String getFirstName() {
        return firstName_;
    }

    public String getLastName() {
        return lastName_;
    }

    public void setFirstName(String firstName) {
        students.getStudent(id_).setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        students.getStudent(id_).setLastName(lastName);
    }


    public void addUnitRecord(IStudentUnitRecord record) {
        students.getStudent(id_).addUnitRecord(record);
    }

    public IStudentUnitRecord getUnitRecord(String unitCode) {
        return students.getStudent(id_).getUnitRecord(unitCode);
    }

    public StudentUnitRecordList getUnitRecords() {
        return students.getStudent(id_).getUnitRecords();
    }
}
