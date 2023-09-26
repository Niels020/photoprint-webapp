package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.OpeningHour;

public interface OpeningHourService {
    OpeningHour getOpeningHour(Long id);
    OpeningHour updateOpeningHour(int openingMinutesPastMidnight, int closingMinutesPastMidnight, Long id);
    List<OpeningHour> getOpeningHours();
}
