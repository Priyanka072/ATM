package com.atm.changePin.Controller;

import com.atm.changePin.Service.PinService;
import com.atm.changePin.entities.Pin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("details/pin")
public class PinController {

    @Autowired
    private PinService pinService;

    @RequestMapping(value = "save",
            method = RequestMethod.PUT,
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            headers = "Accept=application/json")
    public ResponseEntity<Pin> save(@RequestBody Pin pin) {
        try {
            return new ResponseEntity<Pin>(pinService.save(pin), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Pin>(HttpStatus.BAD_REQUEST);
        }
    }
}
