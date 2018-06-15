package com.ghelas.backend.http.controller;

import com.ghelas.backend.model.response.FurnitureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.ghelas.backend.constant.FurnitureConstants.FURNITURE_URI;

@RestController
@RequestMapping(FURNITURE_URI)
public class FurnitureController {

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FurnitureResponse> getFurniture() {
        return new ResponseEntity<>(new FurnitureResponse(), HttpStatus.OK);
    }
}
