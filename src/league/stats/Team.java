package league.stats;

public class Team {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
        this.points = 0; // Los puntos inician en 0 cuando se crea el equipo
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd; // Añadir puntos al total actual
    }

    @Override
    public String toString() {
        return name + "; " + points;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Team team = (Team) obj;
        return name.equals(team.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
