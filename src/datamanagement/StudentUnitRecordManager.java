package datamanagement;

import java.util.List;
import org.jdom.Element;

public class StudentUnitRecordManager {

    private static StudentUnitRecordManager recordManager_ = null;
    private StudentUnitRecordMap recordMap_;
    private java.util.HashMap<String,StudentUnitRecordList> unitRecord_;
    private java.util.HashMap<Integer,StudentUnitRecordList> studentRecord_;

    public static StudentUnitRecordManager instance() {
        if (recordManager_ == null ) recordManager_ = new StudentUnitRecordManager(); return recordManager_;
    }
    
    

    private StudentUnitRecordManager() {
        recordMap_ = new StudentUnitRecordMap();
        unitRecord_ = new java.util.HashMap<>();
        studentRecord_ = new java.util.HashMap<>();
    }
    
    
            
    public IStudentUnitRecord getStudentUnitRecord( Integer studentID, String unitCode ) {
        IStudentUnitRecord iRecord = recordMap_.get(studentID.toString()+unitCode);
        return iRecord != null ? iRecord : createStudentUnitRecord(studentID, unitCode);
    }
    
    

    private IStudentUnitRecord createStudentUnitRecord( Integer uid, String sid ) {
        IStudentUnitRecord iRecord;
        for (Element element : (List<Element>) ( XMLManager.getXML().getDocument()).getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (uid.toString().equals(element.getAttributeValue("sid")) && sid.equals(element.getAttributeValue("uid"))) {
                iRecord = new StudentUnitRecord( new Integer(element.getAttributeValue("sid")),element.getAttributeValue("uid"),
                        new Float(element.getAttributeValue("asg1")).floatValue(),
                        new Float(element.getAttributeValue("asg2")).floatValue(),
                        new Float(element.getAttributeValue("exam")).floatValue() );
                recordMap_.put(iRecord.getStudentID().toString()+iRecord.getUnitCode(), iRecord);return iRecord;
                }
        }
        throw new RuntimeException("DBMD: createStudent : student unit record not in file");
    }
    
    
    
    public StudentUnitRecordList getRecordsByUnit( String unitCode ) {
        StudentUnitRecordList recs = unitRecord_.get(unitCode);
        
        if ( recs != null ) return recs; 
        recs = new StudentUnitRecordList();
        for (Element elemant : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
        if (unitCode.equals(elemant.getAttributeValue("uid"))) recs.add(new StudentUnitRecordProxy( new Integer(elemant.getAttributeValue("sid")), elemant.getAttributeValue("uid")));
        }
        
        if ( recs.size() > 0 ) 
        unitRecord_.put(unitCode, recs); // be careful - this could be empty
        return recs;
    }
    
    

    public StudentUnitRecordList getRecordsByStudent( Integer studentID ) {
        StudentUnitRecordList recs = studentRecord_.get(studentID);
        if ( recs != null ) return recs; recs = new StudentUnitRecordList();
        for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")){
        if (studentID.toString().equals(element.getAttributeValue("sid"))) 
        recs.add(new StudentUnitRecordProxy( new Integer(element.getAttributeValue("sid")), element.getAttributeValue("uid")));
        if ( recs.size() > 0 ) 
        studentRecord_.put(studentID, recs); // be careful - this could be empty
        }
        return recs;
            
    }
    
    

    public void saveRecord( IStudentUnitRecord iRec ) {
        for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (iRec.getStudentID().toString().equals(element.getAttributeValue("sid")) && iRec.getUnitCode().equals(element.getAttributeValue("uid"))) {
                element.setAttribute("asg1", new Float(iRec.getAsg1()).toString());
                element.setAttribute("asg2", new Float(iRec.getAsg2()).toString());
                element.setAttribute("exam", new Float(iRec.getExam()).toString());
                XMLManager.getXML().saveDocument(); // write out the XML file for continuous save
                return;
            }
        }
        
        throw new RuntimeException("DBMD: saveRecord : no such student record in data");
    }
    
    
    
}
