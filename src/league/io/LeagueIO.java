package league.io;

import league.stats.Match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeagueIO {

    public static List<Match> loadMatches(String filename) {
        List<Match> matches = new ArrayList<>(); // Lista para almacenar los objetos Match
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) { // Leer cada línea del archivo hasta el final
                String[] parts = line.split("#"); // Dividir la línea en partes basadas en "#"
                if (parts.length == 4) { // Asegurar que cada línea tenga 4 partes
                    String homeTeamName = parts[0];
                    int homeTeamGoals = Integer.parseInt(parts[1]);
                    String visitorTeamName = parts[2];
                    int visitorTeamGoals = Integer.parseInt(parts[3]);
                    Match match = new Match(homeTeamName, homeTeamGoals, visitorTeamName, visitorTeamGoals); // Crear un objeto Match con los datos parseados
                    matches.add(match); // Añadir el objeto Match a la lista
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return matches; // Devolver la lista de partidos
    }
}
