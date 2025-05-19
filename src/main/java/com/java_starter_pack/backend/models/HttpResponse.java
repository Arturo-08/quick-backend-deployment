package com.java_starter_pack.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@AllArgsConstructor
@ToString
public class HttpResponse<T> {
    private Instant timestamp;
    private int status;
    private String message;
    private T data;

    public HttpResponse(int status, T data, String message) {
        this.timestamp = Instant.now();
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
