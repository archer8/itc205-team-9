package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
    private Integer studentID_;
    private String unitCode_;
    private float assess1_, assess2_, exam_;

    public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) {
        this.studentID_ = id;
        this.unitCode_ = code;
        this.setAsg1(asg1);
        this.setAsg2(asg2);
        this.setExam(exam);
    }
    public Integer getStudentID() {
        return studentID_;
    }

    public String getUnitCode() {
        return unitCode_;
    }

    public void setAsg1(float asg1) {
        if (asg1 < 0 || asg1 > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.assess1_ = asg1;
    }

    public float getAsg1() {

        return assess1_;
    }

    public void setAsg2(float asg2) {
        if (asg2 < 0 || asg2 > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.assess2_ = asg2;

    }

    public float getAsg2() {
        return assess2_;
    }

    public void setExam(float exam) {
        if (exam < 0 || exam > UnitManager.UM().getUnit(unitCode_).getExamWeight()) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.exam_ = exam;
    }

    public float getExam() {
        return exam_;
    }

    public float getTotal() {
        return assess1_ + assess2_ + exam_;

    }
}
