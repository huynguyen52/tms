package icu.nguyenquochuy.tms.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationResponseVO<T> extends ResponseVO<T>{
    private Long totalRecords;
    private Integer page;
    private Integer limit;

    public PaginationResponseVO(int status, T data, Long totalRecords, Integer page, Integer limit) {
        super(status, data);
        this.totalRecords = totalRecords;
        this.page = page;
        this.limit = limit;
    }

    public static <T> PaginationResponseVO success(T data, Integer page, Integer limit, Long totalRecords) {
        return new PaginationResponseVO(
                HttpStatus.OK.value(),
                data,
                totalRecords,
                page,
                limit
        );
    }
}
