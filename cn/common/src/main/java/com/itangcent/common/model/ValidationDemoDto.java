package com.itangcent.common.model;

import javax.validation.constraints.*;

public class ValidationDemoDto {

    @NotNull
    private String str;

    @Min(666)
    private Integer minInt;

    @Max(999)
    private Integer maxInt;

    @Min(666)
    private Double minDouble;

    @Max(999)
    private double maxDouble;

    @Min(666)
    @Max(999)
    private Integer rangeInt;

    @Min(66)
    @Max(9999)
    private float rangeFloat;

    @Negative
    private Integer negative;

    @NegativeOrZero
    private Integer negativeOrZero;

    @Positive
    private Integer positive;

    @PositiveOrZero
    private Integer positiveOrZero;

    @Positive
    private Float positiveFloat;

    @PositiveOrZero
    private float positiveOrZeroFloat;

    @Email
    private String email;

    @AssertTrue
    private boolean assertTrue;

    @AssertFalse
    private boolean assertFalse;

}
