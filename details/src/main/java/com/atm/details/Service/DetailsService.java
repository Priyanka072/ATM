package com.atm.details.Service;

import com.atm.details.Entity.Details;
import com.atm.details.Repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    public Details saveDetails(Details details) {

        return detailsRepository.save(details);
    }

    public Details findByDetailsId(Long detailsId) {

        return detailsRepository.findByDetailsId(detailsId);
    }
}
