package no.knowit.knowittest.REST.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BokDto {
    private String tittel;
    private String ISBN;
    private Integer pris;
    private Integer antall;
}
