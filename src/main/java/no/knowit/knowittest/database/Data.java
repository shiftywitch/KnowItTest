package no.knowit.knowittest.database;

import lombok.AllArgsConstructor;
import no.knowit.knowittest.domain.Bok;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class Data {

    @Bean
    protected void populateDatabase() {
        DB.boeker.add(new Bok(
                "God bok 1",
                "1234567",
                199,
                500
        ));
        DB.boeker.add(new Bok(
                "God bok 2",
                "1234568",
                299,
                432
        ));
        DB.boeker.add(new Bok(
                "God bok 3",
                "1234569",
                249,
                235
        ));
        DB.boeker.add(new Bok(
                "God bok 4",
                "1234577",
                149,
                45
        ));
        DB.boeker.add(new Bok(
                "God bok 5",
                "1234578",
                99,
                89
        ));

        System.out.println(DB.boeker.get(0).getISBN());
    }
}
