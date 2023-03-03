package core.ics.conta.utils;


import core.ics.conta.exception.RegraDeNegocioException;

public class ValidateParameter {

    private ValidateParameter(){}

    public static Long validate(String value){
        try {
            Long id = Long.parseLong(value);
            return id;
        }catch (NumberFormatException e){
            throw new RegraDeNegocioException(e.getMessage());
        }
    }
}
