package com.maxosoft.stepmeter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxosoft.stepmeter.db.model.DataWindow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataWindowDto {
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

    public DataWindowDto(DataWindow dataWindow) {
        this.id = dataWindow.getId();
        this.sessionId = dataWindow.getSessionId();

        this.accMinX = dataWindow.getAccMinX();
        this.accMaxX = dataWindow.getAccMaxX();
        this.accMinY = dataWindow.getAccMinY();
        this.accMaxY = dataWindow.getAccMaxY();
        this.accMinZ = dataWindow.getAccMinZ();
        this.accMaxZ = dataWindow.getAccMaxZ();
        this.accMeanX = dataWindow.getAccMeanX();
        this.accMeanY = dataWindow.getAccMeanY();
        this.accMeanZ = dataWindow.getAccMeanZ();
        this.accVarX = dataWindow.getAccVarX();
        this.accVarY = dataWindow.getAccVarY();
        this.accVarZ = dataWindow.getAccVarZ();
        this.accDevX = dataWindow.getAccDevX();
        this.accDevY = dataWindow.getAccDevY();
        this.accDevZ = dataWindow.getAccDevZ();
        this.accSkewX = dataWindow.getAccSkewX();
        this.accSkewY = dataWindow.getAccSkewY();
        this.accSkewZ = dataWindow.getAccSkewZ();
        this.accKurtX = dataWindow.getAccKurtX();
        this.accKurtY = dataWindow.getAccKurtY();
        this.accKurtZ = dataWindow.getAccKurtZ();
        this.accZeroX = dataWindow.getAccZeroX();
        this.accZeroY = dataWindow.getAccZeroY();
        this.accZeroZ = dataWindow.getAccZeroZ();

        this.gyrMinX = dataWindow.getGyrMinX();
        this.gyrMaxX = dataWindow.getGyrMaxX();
        this.gyrMinY = dataWindow.getGyrMinY();
        this.gyrMaxY = dataWindow.getGyrMaxY();
        this.gyrMinZ = dataWindow.getGyrMinZ();
        this.gyrMaxZ = dataWindow.getGyrMaxZ();
        this.gyrMeanX = dataWindow.getGyrMeanX();
        this.gyrMeanY = dataWindow.getGyrMeanY();
        this.gyrMeanZ = dataWindow.getGyrMeanZ();
        this.gyrVarX = dataWindow.getGyrVarX();
        this.gyrVarY = dataWindow.getGyrVarY();
        this.gyrVarZ = dataWindow.getGyrVarZ();
        this.gyrDevX = dataWindow.getGyrDevX();
        this.gyrDevY = dataWindow.getGyrDevY();
        this.gyrDevZ = dataWindow.getGyrDevZ();
        this.gyrSkewX = dataWindow.getGyrSkewX();
        this.gyrSkewY = dataWindow.getGyrSkewY();
        this.gyrSkewZ = dataWindow.getGyrSkewZ();
        this.gyrKurtX = dataWindow.getGyrKurtX();
        this.gyrKurtY = dataWindow.getGyrKurtY();
        this.gyrKurtZ = dataWindow.getGyrKurtZ();
        this.gyrZeroX = dataWindow.getGyrZeroX();
        this.gyrZeroY = dataWindow.getGyrZeroY();
        this.gyrZeroZ = dataWindow.getGyrZeroZ();
    }

    @JsonIgnore
    public DataWindow getDataWindow() {
        DataWindow dataWindow = new DataWindow();

        dataWindow.setId(this.id);
        dataWindow.setSessionId(this.sessionId);

        dataWindow.setAccMinX(this.accMinX);
        dataWindow.setAccMaxX(this.accMaxX);
        dataWindow.setAccMinY(this.accMinY);
        dataWindow.setAccMaxY(this.accMaxY);
        dataWindow.setAccMinZ(this.accMinZ);
        dataWindow.setAccMaxZ(this.accMaxZ);
        dataWindow.setAccMeanX(this.accMeanX);
        dataWindow.setAccMeanY(this.accMeanY);
        dataWindow.setAccMeanZ(this.accMeanZ);
        dataWindow.setAccVarX(this.accVarX);
        dataWindow.setAccVarY(this.accVarY);
        dataWindow.setAccVarZ(this.accVarZ);
        dataWindow.setAccDevX(this.accDevX);
        dataWindow.setAccDevY(this.accDevY);
        dataWindow.setAccDevZ(this.accDevZ);
        dataWindow.setAccSkewX(this.accSkewX);
        dataWindow.setAccSkewY(this.accSkewY);
        dataWindow.setAccSkewZ(this.accSkewZ);
        dataWindow.setAccKurtX(this.accKurtX);
        dataWindow.setAccKurtY(this.accKurtY);
        dataWindow.setAccKurtZ(this.accKurtZ);
        dataWindow.setAccZeroX(this.accZeroX);
        dataWindow.setAccZeroY(this.accZeroY);
        dataWindow.setAccZeroZ(this.accZeroZ);

        dataWindow.setGyrMinX(this.gyrMinX);
        dataWindow.setGyrMaxX(this.gyrMaxX);
        dataWindow.setGyrMinY(this.gyrMinY);
        dataWindow.setGyrMaxY(this.gyrMaxY);
        dataWindow.setGyrMinZ(this.gyrMinZ);
        dataWindow.setGyrMaxZ(this.gyrMaxZ);
        dataWindow.setGyrMeanX(this.gyrMeanX);
        dataWindow.setGyrMeanY(this.gyrMeanY);
        dataWindow.setGyrMeanZ(this.gyrMeanZ);
        dataWindow.setGyrVarX(this.gyrVarX);
        dataWindow.setGyrVarY(this.gyrVarY);
        dataWindow.setGyrVarZ(this.gyrVarZ);
        dataWindow.setGyrDevX(this.gyrDevX);
        dataWindow.setGyrDevY(this.gyrDevY);
        dataWindow.setGyrDevZ(this.gyrDevZ);
        dataWindow.setGyrSkewX(this.gyrSkewX);
        dataWindow.setGyrSkewY(this.gyrSkewY);
        dataWindow.setGyrSkewZ(this.gyrSkewZ);
        dataWindow.setGyrKurtX(this.gyrKurtX);
        dataWindow.setGyrKurtY(this.gyrKurtY);
        dataWindow.setGyrKurtZ(this.gyrKurtZ);
        dataWindow.setGyrZeroX(this.gyrZeroX);
        dataWindow.setGyrZeroY(this.gyrZeroY);
        dataWindow.setGyrZeroZ(this.gyrZeroZ);

        return dataWindow;
    }
}
