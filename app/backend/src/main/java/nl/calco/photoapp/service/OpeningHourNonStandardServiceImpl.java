package nl.calco.photoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.OpeningHourNonStandard;
import nl.calco.photoapp.exception.EntityNotFoundException;
import nl.calco.photoapp.repository.OpeningHourNonStandardRepository;

@AllArgsConstructor
@Service
public class OpeningHourNonStandardServiceImpl implements OpeningHourNonStandardService {

    OpeningHourNonStandardRepository openingHourNonStandardRepository;
    
    @Override
    public OpeningHourNonStandard getOpeningHourNonStandard(Long id) {
        Optional<OpeningHourNonStandard> openingHourNonStandard = openingHourNonStandardRepository.findById(id);
        return unwrapOpeningHourNonStandard(openingHourNonStandard, id);
    }

    @Override
    public OpeningHourNonStandard saveOpeningHourNonStandard(OpeningHourNonStandard openingHourNonStandard) {
        return openingHourNonStandardRepository.save(openingHourNonStandard);
    }

    @Override
    public void deleteOpeningHourNonStandard(Long id) {
        if (openingHourNonStandardRepository.existsById(id)) {
            openingHourNonStandardRepository.deleteById(id);
        } else throw new EntityNotFoundException(id, OpeningHourNonStandard.class);    
    }

    @Override
    public List<OpeningHourNonStandard> getOpeningHoursNonStandard() {
        return (List<OpeningHourNonStandard>) openingHourNonStandardRepository.findAll();
    }

    static OpeningHourNonStandard unwrapOpeningHourNonStandard(Optional<OpeningHourNonStandard> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, OpeningHourNonStandard.class);
    }

}