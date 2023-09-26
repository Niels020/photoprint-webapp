package nl.calco.photoapp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.OpeningHourNonStandard;
import nl.calco.photoapp.service.OpeningHourNonStandardService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/opening_hour_non_standard")
public class OpeningHourNonStandardController {
     
    OpeningHourNonStandardService openingHourNonStandardService;

    @GetMapping("/{id}")
    public ResponseEntity<OpeningHourNonStandard> getOpeningHourNonStandard(@PathVariable Long id) {
        return new ResponseEntity<>(openingHourNonStandardService.getOpeningHourNonStandard(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OpeningHourNonStandard> saveOpeningHourNonStandard(@RequestBody @Valid OpeningHourNonStandard openingHourNonStandard) {
        return new ResponseEntity<>(openingHourNonStandardService.saveOpeningHourNonStandard(openingHourNonStandard), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOpeningHourNonStandard(@PathVariable Long id) {
        openingHourNonStandardService.deleteOpeningHourNonStandard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OpeningHourNonStandard>> getOpeningHoursNonStandard() {
        return new ResponseEntity<>(openingHourNonStandardService.getOpeningHoursNonStandard(), HttpStatus.OK);
    }
}