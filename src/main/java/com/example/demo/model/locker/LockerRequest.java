package com.example.demo.model.locker;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LockerRequest {

    @NotNull
    private String city;

    @NotNull
    private String space;
}
