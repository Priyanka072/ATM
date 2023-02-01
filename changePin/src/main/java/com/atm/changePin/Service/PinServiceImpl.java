package com.atm.changePin.Service;

import com.atm.changePin.Repositroy.PinRepository;
import com.atm.changePin.entities.Pin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository pinRepository;
    @Override
    public Pin save(Pin pin) {
        return pinRepository.save(pin);
    }
}
