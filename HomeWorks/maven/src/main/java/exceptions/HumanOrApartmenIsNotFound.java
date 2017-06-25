package exceptions;


public class HumanOrApartmenIsNotFound extends RuntimeException {

    public HumanOrApartmenIsNotFound(String message){
        super(message);
    }
}
