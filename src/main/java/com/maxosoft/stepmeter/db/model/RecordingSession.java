package com.maxosoft.stepmeter.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class RecordingSession {
    private Long id;
    private Long accountId;
    private String deviceId;
    private Timestamp dateStart;
    private Timestamp dateEnd;
}
