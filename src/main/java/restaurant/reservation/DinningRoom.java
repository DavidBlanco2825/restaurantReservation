package restaurant.reservation;

import java.util.ArrayList;
import java.util.List;

public class DinningRoom {
    private int totalTables;
    private List<Table> availableTables;

    public DinningRoom() {}

    public DinningRoom(int totalTables) {
        this.totalTables = totalTables;
        this.availableTables = assembleTables();
    }

    public List<Table> assembleTables() {
        List<Table> tables = new ArrayList<>();
        for (int i = 1; i <= totalTables; i++) {
            int seats = i % 2 == 0 ? 4 : 6;
            tables.add(new Table(i, seats));
        }
        return tables;
    }

    public int getTotalTables() {
        return totalTables;
    }

    public void setTotalTables(int totalTables) {
        this.totalTables = totalTables;
    }

    public List<Table> getAvailableTables() {
        return availableTables;
    }

    public void setAvailableTables(List<Table> availableTables) {
        this.availableTables = availableTables;
    }
}
