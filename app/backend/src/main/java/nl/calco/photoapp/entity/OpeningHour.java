package nl.calco.photoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import nl.calco.photoapp.validation.DayOfWeek;

@Getter
@Setter
@Entity
@Table(name = "opening_hour")
public class OpeningHour {


    public OpeningHour() {
    }

    public OpeningHour(String dayOfWeek, int openingMinutesPastMidnight, int closingMinutesPastMidnight) {
        this.dayOfWeek = dayOfWeek;
        this.openingMinutesPastMidnight = openingMinutesPastMidnight;
        this.closingMinutesPastMidnight = closingMinutesPastMidnight;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @DayOfWeek
    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;

    @Min(0)
    @Max(1520)
    @Column(name = "opening_minutes_past_midnight", nullable = false)
    private int openingMinutesPastMidnight;

    @Min(0)
    @Max(1520)
    @Column(name = "closing_minutes_past_midnight", nullable = false)
    private int closingMinutesPastMidnight;

}
