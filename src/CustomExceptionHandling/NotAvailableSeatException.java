package CustomExceptionHandling;

public class NotAvailableSeatException extends Exception{
    public NotAvailableSeatException(String str){
        super(str);
    }
}
