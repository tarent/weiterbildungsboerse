package de.tarent.entities;

import de.tarent.validator.StartDateBeforeEndDate;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.validation.constraints.Pattern.Flag.CASE_INSENSITIVE;

@Entity
@StartDateBeforeEndDate
public class Course extends PanacheEntity {

    @NotBlank
    public String title;
    @NotBlank
    public String trainer;
    public String organizer;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    @NotNull
    @Enumerated(STRING)
    public CourseType courseType;
    @Enumerated(STRING)
    public Location location;
    public String address;
    public String targetAudience;
    @Pattern(regexp = "https?\\W.*", flags = CASE_INSENSITIVE, message = "protocol must be \"http\" or \"https\"")
    @URL
    public String link;

    public enum CourseType {
        EXTERNAL, INTERNAL
    }

    public enum Location {
        REMOTE, ONSITE
    }
}
