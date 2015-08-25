package datamanagement;
public class ListUnitsCTL {
    private UnitManager uManager_;
public ListUnitsCTL() {
        uManager_ = UnitManager.UM();
}
            public void listUnits( IUnitLister lister ) {
lister.clearUnits();UnitMap units = uManager_.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));}}
