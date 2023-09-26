package nl.calco.photoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.OpeningHour;
import nl.calco.photoapp.exception.EntityNotFoundException;
import nl.calco.photoapp.repository.OpeningHourRepository;

@AllArgsConstructor
@Service
public class OpeningHourServiceImpl implements OpeningHourService {

    OpeningHourRepository openingHourRepository;
    
    @Override
    public OpeningHour getOpeningHour(Long id) {
        Optional<OpeningHour> openingHour = openingHourRepository.findById(id);
        return unwrapOpeningHour(openingHour, id);
    }

    @Override
    public OpeningHour updateOpeningHour(int openingMinutesPastMidnight, int closingMinutesPastMidnight, Long id) {
        Optional<OpeningHour> optionalOpeningHour = openingHourRepository.findById(id);
        OpeningHour openingHour = unwrapOpeningHour(optionalOpeningHour, id);
        openingHour.setOpeningMinutesPastMidnight(openingMinutesPastMidnight);
        openingHour.setClosingMinutesPastMidnight(closingMinutesPastMidnight);
        return openingHourRepository.save(openingHour);
    }

    @Override
    public List<OpeningHour> getOpeningHours() {
        return (List<OpeningHour>) openingHourRepository.findAll();
    }

    static OpeningHour unwrapOpeningHour(Optional<OpeningHour> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, OpeningHour.class);
    }
}
