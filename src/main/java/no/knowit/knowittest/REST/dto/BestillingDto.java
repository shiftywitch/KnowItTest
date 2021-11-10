package no.knowit.knowittest.REST.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class BestillingDto {
    private final Date dato;
    private final String[] ISBN;
}
