package no.knowit.knowittest.database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import no.knowit.knowittest.domain.Bestilling;
import no.knowit.knowittest.domain.Bok;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class DB {
    public static List<Bok> boeker = new ArrayList<>();
    public static List<Bestilling> bestillinger = new ArrayList<>();
}
