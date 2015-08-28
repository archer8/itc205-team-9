package datamanagement;

public class ListStudentsCtl {
  private StudentManager sm;

  public ListStudentsCTL() {
    sm = StudentManager.get();
  }

  /**
   * listStudents does something.
   *
   * @param lister
   *          Param lister.
   * @param unitCode
   *          Param unitCode.
   */
  public void listStudents(IStudentLister lister, String unitCode) {
    lister.clearStudents();
    StudentMap students = sm.getStudentsByUnit(unitCode);
    for (Integer id : students.keySet()) {
      lister.addStudent(students.get(id));
    }
  }
}
