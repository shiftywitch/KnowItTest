package no.knowit.knowittest.repository;

import no.knowit.knowittest.REST.dto.BokDto;
import no.knowit.knowittest.database.DB;
import no.knowit.knowittest.domain.Bok;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BokRepository {

    public void bestillBoeker() {

    }

    public Optional<Bok> getBokByISBN(String ISBN) {
        return DB.boeker.stream()
                .filter(bok -> bok.getISBN().equals(ISBN))
                .findFirst();
    }

    public List<Bok> getAlleBoeker() {
        return DB.boeker;
    }

    public String nyBok(BokDto nyBok) {
        DB.boeker.add(new Bok(
                nyBok.getTittel(),
                nyBok.getISBN(),
                nyBok.getPris(),
                nyBok.getAntall()
        ));

        return nyBok.getISBN();
    }

    public Integer bestillBok(Bok bok) {
        bok.selgBok();
        return 1;
    }

    public void leggTilNyeKopier(String isbn, Integer antall) {
         getBokByISBN(isbn).get().leggTilKopier(antall);
    }
}
