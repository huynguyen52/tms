package icu.nguyenquochuy.tms.vo;

import icu.nguyenquochuy.tms.constant.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {
    private int status;
    private String timestamp;
    private String message;
    private T data;

    public ResponseVO(int status, T data) {
        this.status = HttpStatus.OK.value();
        this.timestamp = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        this.message = Messages.GET_DATA_SUCCESS;
        this.data = data;
    }

    public static ResponseVO success(String message) {
        ResponseVO response = new ResponseVO(HttpStatus.OK.value(), null);
        response.setMessage(message);
        return response;
    }

    public static <T> ResponseVO<T> success(T data) {
        return new ResponseVO<>(HttpStatus.OK.value(), data);
    }

    public static <T> ResponseVO<T> success(String message, T data) {
        ResponseVO response = new ResponseVO(HttpStatus.OK.value(), data);
        response.setMessage(message);
        return response;
    }

    /**
     * Response for CREATE resource
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseVO<T> created(String message, T data) {
        ResponseVO<T> response = new ResponseVO<>(HttpStatus.CREATED.value(), data);
        response.setMessage(message);
        return response;
    }
}
