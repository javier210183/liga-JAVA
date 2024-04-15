package league.Main;

import league.io.LeagueIO;
import league.stats.Match;
import league.stats.Team;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Cargar los partidos desde el archivo
        List<Match> matches = LeagueIO.loadMatches("matches.txt");

        // Crear un mapa para los equipos
        Map<String, Team> teamMap = new HashMap<>();

        // Procesar cada partido y actualizar la información de los equipos
        for (Match match : matches) {
            updateTeamInfo(teamMap, match.getHomeTeamName(), match.getHomeTeamGoals(), match.getVisitorTeamGoals());
            updateTeamInfo(teamMap, match.getVisitorTeamName(), match.getVisitorTeamGoals(), match.getHomeTeamGoals());
        }

        // Imprimir la información de todos los partidos
        for (Match match : matches) {
            System.out.println(match);
        }

        saveRanking(teamMap, "ranking.txt");  // Guarda el ranking en un archivo
        System.out.println(" ");
        // Guardar la clasificación de los equipos en un archivo
        saveRanking(teamMap, "ranking.txt");
        // Mostrar la clasificación en la consola
        displayRanking("ranking.txt");

    }

    private static void updateTeamInfo(Map<String, Team> teamMap, String teamName, int teamGoals, int opponentGoals) {
        Team team = teamMap.getOrDefault(teamName, new Team(teamName));
        if (teamGoals > opponentGoals) {
            team.addPoints(3); // Victoria
        } else if (teamGoals == opponentGoals) {
            team.addPoints(1); // Empate
        }
        teamMap.put(teamName, team);
    }
    public static void saveRanking(Map<String, Team> teamMap, String filename) {
        List<Team> sortedTeams = new ArrayList<>(teamMap.values());
        sortedTeams.sort((team1, team2) -> Integer.compare(team2.getPoints(), team1.getPoints()));  // Orden descendente por puntos

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Team team : sortedTeams) {
                writer.write(team.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void displayRanking(String filename) {
        System.out.println("Clasificación Final:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }



}
