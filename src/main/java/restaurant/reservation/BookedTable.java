package restaurant.reservation;

import java.util.UUID;

public class BookedTable {
    private UUID token;
    private Table table;

    public BookedTable() {}

    public BookedTable(Table table) {
        this.table = table;
        this.token = UUID.randomUUID();
    }

    public BookedTable(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
