package com.example.tzrstech.services.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductStatus {
    ACTIVE(true),
    INACTIVE(false);

    private final boolean value;
}
