package pl.sda.crime;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CrimeImporter {
    private final Path path;

    public List<Crime> getCrimes() throws IOException {
        return Files.lines(path)
                .map(line -> line.split(","))
                .map(CrimeMapper::new)
                .map(CrimeMapper::toCrime)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
