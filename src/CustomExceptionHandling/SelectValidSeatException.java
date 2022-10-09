package CustomExceptionHandling;

public class SelectValidSeatException extends Exception{
    public SelectValidSeatException(String str){
        super(str);
    }
}
