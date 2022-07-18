package restaurant.reservation;

public class Stats {
    private int numberOfAvailableTables;

    public Stats() {}

    public Stats(int numberOfAvailableTables) {
        this.numberOfAvailableTables = numberOfAvailableTables;
    }

    public void reservedTable() {
        this.numberOfAvailableTables--;
    }

    public void returnedTable() {
        this.numberOfAvailableTables++;
    }

    public int getNumberOfAvailableTables() {
        return numberOfAvailableTables;
    }

    public void setNumberOfAvailableTables(int numberOfAvailableTables) {
        this.numberOfAvailableTables = numberOfAvailableTables;
    }
}
