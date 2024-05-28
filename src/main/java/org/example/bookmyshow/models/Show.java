package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {

    private DateTimeLiteralExpression.DateTime showStartTime;
    private DateTimeLiteralExpression.DateTime showEndTime;
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Screen screen;
    @Enumerated
    private Feature feature;
}
