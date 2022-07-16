package restaurant.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DinningRoomController {
    DinningRoom dinningRoom = new DinningRoom(6);

    @GetMapping("/tables")
    public DinningRoom getAvailableTables() {
        return dinningRoom;
    }
}
