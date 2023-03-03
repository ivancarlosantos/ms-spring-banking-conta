package core.ics.conta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@RestControllerAdvice
public class ContaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ContaExceptionMessage> handlerException(Exception ex, WebRequest request) {

        ContaExceptionMessage exceptionMensagem = new ContaExceptionMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                new Date(),
                ex.getMessage());

        return new ResponseEntity<>(exceptionMensagem, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {RegraDeNegocioException.class})
    public ResponseEntity<ContaExceptionMessage> exceptionHandler(RuntimeException exception){

        ContaExceptionMessage error = new ContaExceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                new Date(),
                exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ContaExceptionMessage> handlerExceptionNumberFormat(MethodArgumentTypeMismatchException ex) {

        ContaExceptionMessage exceptionMensagem = new ContaExceptionMessage(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                new Date(),
                ex.getMessage());

        return new ResponseEntity<>(exceptionMensagem, HttpStatus.BAD_REQUEST);
    }
}
