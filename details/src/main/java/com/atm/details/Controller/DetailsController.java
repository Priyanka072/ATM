package com.atm.details.Controller;

import com.atm.details.Entity.Details;
import com.atm.details.Service.DetailsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;


    @PostMapping("/")
    public Details saveDetails(@RequestBody Details details)
    {

        return detailsService.saveDetails(details);
    }

    @GetMapping("/{id}")
    public Details findDetailsById(@PathVariable("id") Long detailsId){
        return detailsService.findByDetailsId(detailsId);

    }
}
