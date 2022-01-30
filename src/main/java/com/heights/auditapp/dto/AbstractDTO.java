package com.heights.auditapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AbstractDTO<E> {

    @JsonIgnore
    private E id;

    public E getId() {
        return id;
    }

    public void setId(E id) {
        this.id = id;
    }
}