package com.maxosoft.stepmeter.db.dao;

import com.maxosoft.stepmeter.db.model.DataWindow;
import com.maxosoft.stepmeter.db.model.RecordingSession;

import java.util.List;

public interface IDataWindowDAO {
    List<DataWindow> getDataWindowsForAccount(Long accountId);
    List<DataWindow> getDataWindowsExceptAccount(Long accountId);
    void saveRecordingSession(RecordingSession recordingSession);
    void saveDataWindows(List<DataWindow> dataWindows);
}
