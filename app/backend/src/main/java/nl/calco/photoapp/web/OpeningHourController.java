package nl.calco.photoapp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.OpeningHour;
import nl.calco.photoapp.service.OpeningHourService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/opening_hour")
public class OpeningHourController {
    
    OpeningHourService openingHourService;

    @GetMapping("/{id}")
    public ResponseEntity<OpeningHour> getOpeningHour(@PathVariable Long id) {
        return new ResponseEntity<>(openingHourService.getOpeningHour(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpeningHour> updateOpeningHour(@RequestBody @Valid OpeningHour openingHour, @PathVariable Long id) {
        return new ResponseEntity<>(openingHourService.updateOpeningHour(openingHour.getOpeningMinutesPastMidnight(), openingHour.getClosingMinutesPastMidnight(), id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OpeningHour>> getOpeningHours() {
        return new ResponseEntity<>(openingHourService.getOpeningHours(), HttpStatus.OK);
    }
}

