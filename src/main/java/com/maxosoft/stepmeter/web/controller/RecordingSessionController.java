package com.maxosoft.stepmeter.web.controller;

import com.maxosoft.stepmeter.db.dao.IAccountDAO;
import com.maxosoft.stepmeter.db.model.Account;
import com.maxosoft.stepmeter.dto.DataWindowDto;
import com.maxosoft.stepmeter.dto.RecordingSessionDto;
import com.maxosoft.stepmeter.services.IDataWindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordingSessionController {

    @Autowired
    private IDataWindowService dataWindowService;
    @Autowired
    private IAccountDAO accountDAO;

    @GetMapping(value = "/data-windows-for-account/{accountId}")
    public ResponseEntity getDataWindowsForAccount(@PathVariable Long accountId) {
        List<DataWindowDto> dataWindows = dataWindowService.getForAccount(accountId);
        if (dataWindows != null && !dataWindows.isEmpty()) {
            return ResponseEntity.ok(dataWindows);
        } else {
            return ResponseEntity.ok("No Data Windows are available for account");
        }
    }

    @GetMapping(value = "/data-windows-except-account/{accountId}")
    public ResponseEntity getDataWindowsExceptAccount(@PathVariable Long accountId) {
        List<DataWindowDto> dataWindows = dataWindowService.getExceptAccount(accountId);
        if (dataWindows != null && !dataWindows.isEmpty()) {
            return ResponseEntity.ok(dataWindows);
        } else {
            return ResponseEntity.ok("No Data Windows are available for other accouns");
        }
    }

    @PostMapping(value = "/recording-session")
    public void saveRecordingSession(@RequestBody RecordingSessionDto recordingSession, @RequestParam(required = false) String email) {
        if (recordingSession.getAccountId() == null) {
            if (email != null) {
                Account account = accountDAO.getByEmail(email);
                recordingSession.setAccountId(account.getId());
            } else {
                return;
            }
        }
        dataWindowService.saveRecordingSession(recordingSession);
    }
}
