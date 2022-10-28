package com.is442.oop.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is442.oop.data.models.Pass;
import com.is442.oop.data.payloads.response.DataResponse;

@RestController
@RequestMapping("/scheduled")
public class ScheduledController {
    @Autowired
    ScheduledService scheduledService;

    @GetMapping("/updatePassesToUnreturned")
    public ResponseEntity<DataResponse> updatePassesToUnreturned() {
        List<Pass> unreturnedPasses = null;
        try {
            unreturnedPasses = scheduledService.updatePassesToUnreturned();
        } catch (Exception e) {
            return new ResponseEntity<>(new DataResponse(unreturnedPasses, e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new DataResponse(unreturnedPasses, "ScheduledService"), HttpStatus.OK);
    }
}