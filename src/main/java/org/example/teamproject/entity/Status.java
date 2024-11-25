package org.example.teamproject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    ON_RENTAL("ON_RENTAL"),
    ON_RETURN("ON_RETURN"),
    ON_FREE("ON_FREE");

    private final String name;

}
