package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.OpeningHourNonStandard;

public interface OpeningHourNonStandardService {
    OpeningHourNonStandard getOpeningHourNonStandard(Long id);
    OpeningHourNonStandard saveOpeningHourNonStandard(OpeningHourNonStandard openingHourNonStandard);
    void deleteOpeningHourNonStandard(Long id);
    List<OpeningHourNonStandard> getOpeningHoursNonStandard();
}
