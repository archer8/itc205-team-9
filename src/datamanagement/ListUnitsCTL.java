package datamanagement;
public class ListUnitsCTL {
    private UnitManager uManager_;
<<<<<<< HEAD
    
    
    
    public ListUnitsCTL() {
        uManager_ = UnitManager.UM();
    }
    
    
    
    public void listUnits( IUnitLister lister ) {
        lister.clearUnits();UnitMap units = uManager_.getUnits();
=======
public ListUnitsCTL() {
        uManager_ = UnitManager.UM();
}
            public void listUnits( IUnitLister lister ) {
lister.clearUnits();UnitMap units = uManager_.getUnits();
>>>>>>> master
        for (String s : units.keySet() )
        lister.addUnit(units.get(s));
    }



}
