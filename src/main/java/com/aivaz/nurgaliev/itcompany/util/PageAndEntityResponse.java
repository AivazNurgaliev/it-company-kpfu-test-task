package com.aivaz.nurgaliev.itcompany.util;

import java.util.List;

public class PageAndEntityResponse<T> {

    private Integer totalPages;
    private Long totalElements;
    private List<T> entity;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getEntity() {
        return entity;
    }

    public void setEntity(List<T> entity) {
        this.entity = entity;
    }
}
