package datamanagement;

public class ListUnitsCtl {
  private UnitManager um;

  public ListUnitsCTL() {
    um = UnitManager.UM();
  }

  /**
   * listUnits does something.
   *
   * @param lister
   *          Param lister.
   */
  public void listUnits(IUnitLister lister) {
    lister.clearUnits();
    UnitMap units = um.getUnits();
    for (String s : units.keySet()) {
      lister.addUnit(units.get(s));
    }
  }
}
