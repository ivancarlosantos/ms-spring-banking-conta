package core.ics.conta.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@Getter
@NoArgsConstructor
public class ContaExceptionMessage implements Serializable {

    private Integer statusNumber;

    private HttpStatus status;

    private String timestamp;

    private String message;

    public ContaExceptionMessage(Integer statusNumber, HttpStatus status, Date timestamp, String message){
        this.statusNumber = statusNumber;
        this.status = status;
        this.timestamp = timestamp.toString();
        this.message = message;
    }
}
