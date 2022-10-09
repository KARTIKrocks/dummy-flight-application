package CustomExceptionHandling;

public class AvailableSeatException extends Exception{
    public AvailableSeatException(String str){
        super(str);
    }
}
