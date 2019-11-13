package com.maxosoft.stepmeter.services;

import com.maxosoft.stepmeter.dto.DataWindowDto;
import com.maxosoft.stepmeter.dto.RecordingSessionDto;

import java.util.List;

public interface IDataWindowService {
    List<DataWindowDto> getForAccount(Long accountId);
    List<DataWindowDto> getExceptAccount(Long accountId);
    void saveRecordingSession(RecordingSessionDto recordingSessionDto);
}
