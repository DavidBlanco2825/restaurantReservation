package restaurant.reservation;

public class ReturnTable {
    private Table returnedTable;

    public ReturnTable(){}

    public ReturnTable(Table returnedTable) {
        this.returnedTable = returnedTable;
    }

    public Table getReturnedTable() {
        return returnedTable;
    }

    public void setReturnedTable(Table returnedTable) {
        this.returnedTable = returnedTable;
    }
}
