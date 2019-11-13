package com.maxosoft.stepmeter.dto;

import com.maxosoft.stepmeter.db.model.DataWindow;
import com.maxosoft.stepmeter.db.model.RecordingSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordingSessionDto {
    private Long id;
    private Long accountId;
    private String deviceId;
    private Date dateStart;
    private Date dateEnd;
    private List<DataWindowDto> dataWindows;

    public RecordingSessionDto(RecordingSession recordingSession, List<DataWindow> dataWindows) {
        this.id = recordingSession.getId();
        this.accountId = recordingSession.getAccountId();
        this.deviceId = recordingSession.getDeviceId();
        this.dateStart = recordingSession.getDateStart();
        this.dateEnd = recordingSession.getDateEnd();
        if (dataWindows != null && !dataWindows.isEmpty()) {
            this.dataWindows = new ArrayList<>();
            dataWindows.forEach(dw -> this.dataWindows.add(new DataWindowDto(dw)));
        }
    }

    public RecordingSession getRecordingSession() {
        RecordingSession recordingSession = new RecordingSession();

        recordingSession.setId(this.id);
        recordingSession.setAccountId(this.accountId);
        recordingSession.setDeviceId(this.deviceId);
        if (this.dateStart != null) {
            recordingSession.setDateStart(new Timestamp(this.dateStart.getTime()));
        }
        if (this.dateEnd != null) {
            recordingSession.setDateEnd(new Timestamp(this.dateEnd.getTime()));
        }

        return recordingSession;
    }

    public List<DataWindow> getDataWindowList() {
        List<DataWindow> dataWindows = new ArrayList<>();

        if (this.dataWindows != null && !this.dataWindows.isEmpty()) {
            this.dataWindows.forEach(dw -> dataWindows.add(dw.getDataWindow()));
        }

        return dataWindows;
    }
}
