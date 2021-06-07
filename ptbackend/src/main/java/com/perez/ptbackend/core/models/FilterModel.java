package com.perez.ptbackend.core.models;

import static com.perez.ptbackend.core.util.DateUtil.DATE_TIME_FORMAT;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FilterModel<T> {

    private int page;
    private int size;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
    private LocalDateTime from;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
    private LocalDateTime to;
    private String sort;
    private String direction;
    private String groupBy;
    private T filters;
    private boolean deleted;

    public FilterModel() {
        this.page = 0;
        this.size = 300;
    }



}
