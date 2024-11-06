package com.www.termp.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    ON_RENTAL("ON_RENTAL");

    private final String name;

}
