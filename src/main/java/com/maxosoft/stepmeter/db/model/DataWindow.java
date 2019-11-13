package com.maxosoft.stepmeter.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataWindow {
    private Long id;
    private Long sessionId;
    private Float accMinX;
    private Float accMaxX;
    private Float accMinY;
    private Float accMaxY;
    private Float accMinZ;
    private Float accMaxZ;
    private Float accMeanX;
    private Float accMeanY;
    private Float accMeanZ;
    private Float accVarX;
    private Float accVarY;
    private Float accVarZ;
    private Float accDevX;
    private Float accDevY;
    private Float accDevZ;
    private Float accSkewX;
    private Float accSkewY;
    private Float accSkewZ;
    private Float accKurtX;
    private Float accKurtY;
    private Float accKurtZ;
    private Float accZeroX;
    private Float accZeroY;
    private Float accZeroZ;

    private Float gyrMinX;
    private Float gyrMaxX;
    private Float gyrMinY;
    private Float gyrMaxY;
    private Float gyrMinZ;
    private Float gyrMaxZ;
    private Float gyrMeanX;
    private Float gyrMeanY;
    private Float gyrMeanZ;
    private Float gyrVarX;
    private Float gyrVarY;
    private Float gyrVarZ;
    private Float gyrDevX;
    private Float gyrDevY;
    private Float gyrDevZ;
    private Float gyrSkewX;
    private Float gyrSkewY;
    private Float gyrSkewZ;
    private Float gyrKurtX;
    private Float gyrKurtY;
    private Float gyrKurtZ;
    private Float gyrZeroX;
    private Float gyrZeroY;
    private Float gyrZeroZ;
}
