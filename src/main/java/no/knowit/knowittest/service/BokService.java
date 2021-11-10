package no.knowit.knowittest.service;

import lombok.AllArgsConstructor;
import no.knowit.knowittest.REST.dto.BestillingDto;
import no.knowit.knowittest.REST.dto.BokDto;
import no.knowit.knowittest.REST.dto.NyeKopierDto;
import no.knowit.knowittest.REST.dto.ResponsDto;
import no.knowit.knowittest.domain.Bok;
import no.knowit.knowittest.repository.BokRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BokService {

    BokRepository bokRepository;

    public ResponsDto bestillBoeker(BestillingDto bestillingDto) {

        List<String> ISBNnummere = Arrays.asList(bestillingDto.getISBN());

        List<Bok> boeker = bokRepository.getAlleBoeker().stream()
                .filter(bok -> ISBNnummere.contains(bok.getISBN()))
                .collect(Collectors.toList());

        boeker
                .forEach(bok -> bokRepository.bestillBok(bok));
        return null;
    }

    public ResponsDto leggTilNyeKopier(List<NyeKopierDto> nyeKopier) {

        ArrayList<String> respons = new ArrayList<>();

        nyeKopier
                .forEach(nyeKopierDto -> {
                    String ISBN = nyeKopierDto.getISBN();
                    Optional<Bok> bok = bokRepository.getBokByISBN(ISBN);
                    if (bok.isPresent()) {
                        bokRepository.leggTilNyeKopier(bok.get().getISBN(), nyeKopierDto.getAntall());
                        respons.add(nyeKopierDto.getAntall() + " kopier lagt til bok med ISBN: " + nyeKopierDto.getISBN() );
                    }
                });

        return new ResponsDto(respons);
    }

    public String nyBok(BokDto bokDto) {
        bokRepository.getBokByISBN(bokDto.getISBN()).orElseThrow(() -> new RuntimeException("Bok med ISBN eksisterer allerede"));
        return bokRepository.nyBok(bokDto);
    }
}
