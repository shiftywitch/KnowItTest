package no.knowit.knowittest.REST.controller;

import lombok.AllArgsConstructor;
import no.knowit.knowittest.REST.dto.BokDto;
import no.knowit.knowittest.service.BokService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/*")
@AllArgsConstructor
public class BokController {

    BokService bokService;

    @PostMapping(path = "/ny_bok")
    public ResponseEntity<?> nyBok(@RequestBody BokDto bokDto) {
        String respons = bokService.nyBok(bokDto);
        return new ResponseEntity<String>(respons, HttpStatus.OK);
    }
}
