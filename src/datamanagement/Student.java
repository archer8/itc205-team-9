package datamanagement;

public class Student implements IStudent {
    private Integer id_;
    private String firstName_;
    private String lastName_;
    private StudentUnitRecordList studentUnit_;

    public Student(Integer id, String fn, String ln, StudentUnitRecordList su) {
        this.id_ = id;
        this.firstName_ = fn;
        this.lastName_ = ln;
        this.studentUnit_ =
                su == null ? new StudentUnitRecordList() :
                        su;
    }

    public Integer getID() {
        return this.id_;
    }

    public String getFirstName() {
        return firstName_;
    }

    public void setFirstName(String firstName) {
        this.firstName_ = firstName;
    }

    public String getLastName() {
        return lastName_;
    }

    public void setLastName(String lastName) {
        this.lastName_ = lastName;
    }

    public void addUnitRecord(IStudentUnitRecord record) {
        studentUnit_.add(record);
    }

    public IStudentUnitRecord getUnitRecord(String unitCode) {
        for (IStudentUnitRecord r : studentUnit_)
            if (r.getUnitCode().equals(unitCode))
                return r;

        return null;

    }

    public StudentUnitRecordList getUnitRecords() {
        return studentUnit_;
    }
}
