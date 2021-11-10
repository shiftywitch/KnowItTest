package no.knowit.knowittest.service;

import no.knowit.knowittest.REST.dto.BokDto;
import no.knowit.knowittest.REST.dto.NyeKopierDto;
import no.knowit.knowittest.REST.dto.ResponsDto;
import no.knowit.knowittest.domain.Bok;
import no.knowit.knowittest.repository.BokRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BokServiceTest {

    @MockBean
    private BokRepository bokRepositoryMock;

    @Autowired
    private BokRepository bokRepository;

    @Autowired
    private BokService bokService;

    @Test
    void nyBok() {
        BokDto nyBok = new BokDto(
                "God bok 555",
                "787878",
                89,
                55
        );

        Mockito.when(bokRepositoryMock.nyBok(nyBok)).thenReturn("787878");

        String nyBokReturn = bokService.nyBok(nyBok);

        assertThat(nyBokReturn).isEqualTo("787878");
    }

    @Test
    void leggTilNyeKopier() {
        List<NyeKopierDto> nyeKopier = new ArrayList<>(Arrays.asList(
                new NyeKopierDto("1234567", 50),
                new NyeKopierDto("1234568", 100)
        ));

        bokService.leggTilNyeKopier(nyeKopier);


        Bok bok = bokRepository.getBokByISBN("1234567").orElseThrow();

        System.out.println(bok.getAntall());

        assertThat(bok.getAntall()).isEqualTo(149);
    }
}