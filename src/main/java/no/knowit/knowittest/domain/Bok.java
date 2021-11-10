package no.knowit.knowittest.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Bok {
    private String tittel;
    private String ISBN;
    private Integer pris;
    private Integer antall;

    public void selgBok() {
        if (antall > 1) {
            antall--;
        }
    }

    public void leggTilKopier(Integer antall) {
        this.antall += antall;
    }
}
