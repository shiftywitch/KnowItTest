package no.knowit.knowittest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Bestilling {
    private final Date dato;
    private final String[] ISBN;
}
