package pl.sda.crime;

import org.w3c.dom.ranges.Range;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<Crime> crimes = new LinkedList<>(new CrimeImporter(Paths.get("src/main/resources/crime.csv")).getCrimes());
        LinkedList<Crime> crimesLinked = new LinkedList<>(new CrimeImporter(Paths.get("src/main/resources/crime.csv")).getCrimes());
        crimesLinked.getLast();

        Random random = new Random();


        Instant start = Instant.now();

        for (int i = 0; i < 100; i++) {
            int i1 = random.nextInt(crimes.size());
            Crime crime = crimes.get(i1);
//            System.out.println(crime);
        }

        Instant end = Instant.now();
        Duration executionTime = Duration.between(start, end);


        crimes = new ArrayList<Crime>(crimes);
        Instant start2 = Instant.now();

        for (int i = 0; i < 100; i++) {
            int i1 = random.nextInt(crimes.size());
            Crime crime = crimes.get(i1);
//            System.out.println(crime);
        }

        Instant end2 = Instant.now();
        Duration executionTime2 = Duration.between(start2, end2);
        System.out.println(executionTime.toNanos()/100);
        System.out.println(executionTime2.toNanos()/100);

    }
}
