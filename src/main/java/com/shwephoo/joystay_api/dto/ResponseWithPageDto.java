package com.shwephoo.joystay_api.dto;

import com.shwephoo.joystay_api.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseWithPageDto<T> {
    private String status;
    private Pagination pagination;
    private List<T> data;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pagination {
        private int pageNumber;
        private int pageSize;
        private long totalElements;
        private int totalPages;
    }
}
