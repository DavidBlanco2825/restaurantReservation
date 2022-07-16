package restaurant.reservation;

public class TableException extends RuntimeException {
    public TableException(String reason) {
        super(reason);
    }
}
