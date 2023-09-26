package nl.calco.photoapp.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opening_hour_non_standard")
public class OpeningHourNonStandard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Future
    @NonNull
    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Min(0)
    @Max(1520)
    @NonNull
    @Column(name = "opening_minutes_past_midnight", nullable = false)
    private int openingMinutesPastMidnight;

    @Min(0)
    @Max(1520)
    @NonNull
    @Column(name = "closing_minutes_past_midnight", nullable = false)
    private int closingMinutesPastMidnight;
}
