package restaurant.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DinningRoomController {
    DinningRoom dinningRoom = new DinningRoom(6);
    List<BookedTable> bookedTables = new ArrayList<>();

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
                table.setBooked(true);
                BookedTable bookedTable = new BookedTable(table);
                bookedTables.add(bookedTable);
                return bookedTable;
            }
        }
        throw new TableException("The table has been already reserved.");
    }
}
