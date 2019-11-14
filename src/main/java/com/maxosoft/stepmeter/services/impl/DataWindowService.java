package com.maxosoft.stepmeter.services.impl;

import com.maxosoft.stepmeter.db.dao.IDataWindowDAO;
import com.maxosoft.stepmeter.db.model.DataWindow;
import com.maxosoft.stepmeter.db.model.RecordingSession;
import com.maxosoft.stepmeter.dto.DataWindowDto;
import com.maxosoft.stepmeter.dto.RecordingSessionDto;
import com.maxosoft.stepmeter.services.IDataWindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataWindowService implements IDataWindowService {

    @Autowired
    private IDataWindowDAO dataWindowDAO;

    @Override
    public List<DataWindowDto> getForAccount(Long accountId) {
        List<DataWindow> dataWindows = dataWindowDAO.getDataWindowsForAccount(accountId);
        return this.getDtos(dataWindows);
    }

    @Override
    public List<DataWindowDto> getExceptAccount(Long accountId) {
        List<DataWindow> dataWindows = dataWindowDAO.getDataWindowsExceptAccount(accountId);
        return this.getDtos(dataWindows);
    }

    @Override
    public void saveRecordingSession(RecordingSessionDto recordingSessionDto) {
        RecordingSession recordingSession = recordingSessionDto.getRecordingSession();
        List<DataWindow> dataWindows = recordingSessionDto.getDataWindowList();

        dataWindowDAO.saveRecordingSession(recordingSession);
        if (dataWindows != null && !dataWindows.isEmpty()) {
            boolean includeGyroscope = dataWindows.stream().anyMatch(dw -> (dw.getGyrMinX() != null));
            if (includeGyroscope) {
                dataWindows = dataWindows.stream().filter(dw -> dw.getGyrMinX() != null).collect(Collectors.toList());
            }
            dataWindows.forEach(dw -> dw.setSessionId(recordingSession.getId()));
            dataWindowDAO.saveDataWindows(dataWindows, includeGyroscope);
        }
    }

    private List<DataWindowDto> getDtos(List<DataWindow> dataWindows) {
        List<DataWindowDto> dtos = new ArrayList<>();
        if (dataWindows != null && !dataWindows.isEmpty()) {
            dataWindows.forEach(dw -> dtos.add(new DataWindowDto(dw)));
        }
        return dtos;
    }
}
