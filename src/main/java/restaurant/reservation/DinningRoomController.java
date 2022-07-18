package restaurant.reservation;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DinningRoomController {
    DinningRoom dinningRoom = new DinningRoom(6);
    List<BookedTable> bookedTables = new ArrayList<>();
    Stats dinningRoomStats = new Stats(dinningRoom.getTotalTables());

    @GetMapping("/tables")
    public DinningRoom getAvailableTables() {
        return dinningRoom;
    }
    @PostMapping("/reserve")
    public BookedTable getBookedTable(@RequestBody Table t) {
        int tableNumber = t.getTableNumber();

        if (tableNumber > dinningRoom.getTotalTables() || tableNumber <= 0) {
            throw new TableException("The table number is out of bounds!.");
        }
        for (Table table : dinningRoom.getAvailableTables()) {
            if (table.getTableNumber() == tableNumber && !table.isBooked()) {
                dinningRoom.getAvailableTables().remove(table);
                table.setBooked(true);
                dinningRoomStats.reservedTable();
                BookedTable bookedTable = new BookedTable(table);
                bookedTables.add(bookedTable);
                return bookedTable;
            }
        }
        throw new TableException("The table has been already reserved.");
    }
    @PostMapping("/return")
    public ReturnTable getReturnTable(@RequestBody BookedTable returnedTable) {
        for (BookedTable bookedTable : bookedTables) {
            if (bookedTable.getToken().equals(returnedTable.getToken())) {
                ReturnTable returnTable = new ReturnTable(bookedTable.getTable());
                bookedTable.getTable().setBooked(false);
                dinningRoomStats.returnedTable();
                dinningRoom.getAvailableTables().add(bookedTable.getTable());
                bookedTables.remove(bookedTable);
                return returnTable;
            }
        }
        throw new TableException("Wrong token!");
    }

    @PostMapping("/stats")
    public Stats getStats(@RequestParam(name = "password", required = false) String password) {
        if (password == null || password.isEmpty()) {
            throw new TableException("The password is wrong");
        } else if (password.equals("secret_password")) {
            return dinningRoomStats;
        } else {
            throw new TableException("The password is wrong");
        }
    }
}
