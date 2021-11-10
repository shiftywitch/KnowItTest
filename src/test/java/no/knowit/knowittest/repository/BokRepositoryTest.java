package no.knowit.knowittest.repository;

import no.knowit.knowittest.REST.dto.BokDto;
import no.knowit.knowittest.database.DB;
import no.knowit.knowittest.domain.Bok;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BokRepositoryTest {

    @Autowired
    BokRepository bokRepository;

    @Test
    void bestillBoeker() {
    }

    @Test
    void getBokByISBN() {
        Optional<Bok> bok = bokRepository.getBokByISBN("1234567");
        assertThat(bok).isPresent();
    }

    @Test
    void getAlleBoeker() {
    }

    @Test
    void nyBok() {
        BokDto bok = new BokDto(
                "God Bok 150",
                "7777777",
                100,
                11
        );

        bokRepository.nyBok(bok);
        Bok nyBokFromDb = bokRepository.getBokByISBN(bok.getISBN()).get();

        assertThat(DB.boeker).contains(nyBokFromDb);
    }

    @Test
    void bestillBok() {
    }

    @Test
    void leggTilNyeKopier() {
    }
}