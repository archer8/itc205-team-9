package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
    private Integer studentId_;
    private String unitCode_;
    private float asg1_, asg2_, exam_;

    public StudentUnitRecord(Integer id, String code, float asg1, float asg2,float exam) {
	this.studentId_ = id;
	this.unitCode_ = code;
	this.setAsg1(asg1);
	this.setAsg2(asg2);
	this.setExam(exam);
    }
    
    

    public Integer getStudentID() {
	return studentId_;
    }
    
    

    public String getUnitCode() {
	return unitCode_;
    }
    
    

    
    public void setAsg1(float a1) {
        boolean as1IsValid = (a1 > 0 || a1 < UnitManager.UM().getUnit(unitCode_).getAsg1Weight());
        System.out.println(as1IsValid);
	if (as1IsValid == false) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
	}
	this.asg1_ = a1;
    }
    
    

    public float getAsg1() {
        return asg1_;
    }
    
    

    public void setAsg2(float a2) {
        boolean as2IsValid = (a2 > 0 || a2 < UnitManager.UM().getUnit(unitCode_).getAsg2Weight());
	if (as2IsValid == false) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
	}
        this.asg2_ = a2;
    }
    
    

    public float getAsg2() {
	return asg2_;
    }
    
    

    public void setExam(float ex) {
        boolean exIsValid = (ex > 0 || ex < UnitManager.UM().getUnit(unitCode_).getExamWeight());
        if (exIsValid == false) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
	}
        this.exam_ = ex;
    }
    
    

    public float getExam() {
        return exam_;
    }
    
    

    public float getTotal() {
	return asg1_ + asg2_ + exam_;
    }
    
    
}
