package datamanagement;
public class UnitProxy implements IUnit {
    
    private String unitCode_;
    private String unitName_;

    UnitManager   unitManager_;

    public UnitProxy( String unitCode, String unitName ) {
        this.unitCode_ = unitCode;
        this.unitName_ = unitName;
        unitManager_ = UnitManager.UM(); 
    }
    
    public String getUnitCode() { 
        return this.unitCode_;
    }
    
    public String getUnitName() { 
        return this.unitName_; 
    }
    
    public void setPsCutoff1(float cutoff) {
    unitManager_.getUnit(unitCode_).setPsCutoff1(cutoff);
    }
    
    public float getPsCutoff() {
    return unitManager_.getUnit(unitCode_).getPsCutoff();
    }
    
    public void setCrCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setCrCutoff(cutoff);
    }
    
    public float getCrCutoff() {
        return unitManager_.getUnit(unitCode_).getCrCutoff();
    }

    public void setDiCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setDiCutoff(cutoff);
    }
    
    public float getDiCuttoff() {
        return unitManager_.getUnit(unitCode_).getDiCuttoff();
    }
    
    public void setHdCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setHdCutoff(cutoff); 
    }
    
    public float getHdCutoff() {
        return unitManager_.getUnit(unitCode_).getHdCutoff();
    }
    
    public void setAeCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setAeCutoff(cutoff);
    }
    
    public float getAeCutoff() {
        return unitManager_.getUnit(unitCode_).getAeCutoff();
    }
    
    public String getGrade(float f1, float f2, float f3) {
        return unitManager_.getUnit(unitCode_).getGrade(f1, f2, f3);
    }
    
    public void addStudentRecord(IStudentUnitRecord record) { 
        unitManager_.getUnit(unitCode_).addStudentRecord(record);
    }
    
    public IStudentUnitRecord getStudentRecord(int s) {
        return unitManager_.getUnit(unitCode_).getStudentRecord(s);
    }
    
    public StudentUnitRecordList listStudentRecords() {
        return unitManager_.getUnit(unitCode_).listStudentRecords();
    }
    
    public int getAsg1Weight() {
	return unitManager_.getUnit(unitCode_).getAsg1Weight();
    }
    
    public int getAsg2Weight() {
	return unitManager_.getUnit(unitCode_).getAsg2Weight();
    }
    
    public int getExamWeight() {
	return unitManager_.getUnit(unitCode_).getExamWeight();
    }
    
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
	unitManager_.getUnit(unitCode_).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
	
    }
}
