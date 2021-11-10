package no.knowit.knowittest.REST.controller;

import no.knowit.knowittest.REST.dto.BokDto;
import no.knowit.knowittest.service.BokService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BokControllerTest {

    @MockBean
    public BokService bokServiceMock;

    @Autowired
    public TestRestTemplate testRestTemplate;

    @Test
    void nyBok() {
        BokDto nyBok = new BokDto(
                "God bok 54",
                "234567",
                600,
                600
        );

        HttpEntity<BokDto> request = new HttpEntity<>(nyBok);
        ArgumentCaptor<BokDto> captor = ArgumentCaptor.forClass(BokDto.class);
        Mockito.when(bokServiceMock.nyBok(Mockito.any(BokDto.class))).thenReturn("234567");

        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/ny_bok", request, String.class);

        Mockito.verify(bokServiceMock, Mockito.times(1)).nyBok(captor.capture());

        BokDto capturedBok = captor.getValue();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("234567");

        assertThat(capturedBok.getTittel()).isEqualTo(nyBok.getTittel());
    }
}