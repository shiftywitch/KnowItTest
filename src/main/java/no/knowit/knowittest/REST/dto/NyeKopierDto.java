package no.knowit.knowittest.REST.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class NyeKopierDto {
    private String ISBN;
    private Integer antall;
}
