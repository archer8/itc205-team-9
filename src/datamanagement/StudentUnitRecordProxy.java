package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord {

    private Integer studentID_;
    private String unitCode_;
    private StudentUnitRecordManager mngr_;

    public StudentUnitRecordProxy(Integer id, String code) {
        this.studentID_ = id;
        this.unitCode_ = code;
        this.mngr_ = StudentUnitRecordManager.instance();
    }



    public Integer getStudentID() {
        return studentID_;
    }



    public String getUnitCode() {
        return unitCode_;
    }



    public void setAsg1(float mark) {
        mngr_.getStudentUnitRecord(studentID_, unitCode_).setAsg1(mark);
    }



    public float getAsg1() {
        return mngr_.getStudentUnitRecord(studentID_, unitCode_).getAsg1();
    }



    public void setAsg2(float mark) {
        mngr_.getStudentUnitRecord(studentID_, unitCode_).setAsg2(mark);
    }



    public float getAsg2() {
        return mngr_.getStudentUnitRecord(studentID_, unitCode_).getAsg2();
    }



    public void setExam(float mark) {
        mngr_.getStudentUnitRecord(studentID_, unitCode_).setExam(mark);
    }



    public float getExam() {
        return mngr_.getStudentUnitRecord(studentID_, unitCode_).getExam();
    }



    public float getTotal() {
        return mngr_.getStudentUnitRecord(studentID_, unitCode_).getTotal();
    }



}
