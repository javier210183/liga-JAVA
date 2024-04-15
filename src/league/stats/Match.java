package league.stats;

public class Match {
    private String homeTeamName;
    private int homeTeamGoals;
    private String visitorTeamName;
    private int visitorTeamGoals;

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public String getVisitorTeamName() {
        return visitorTeamName;
    }

    public void setVisitorTeamName(String visitorTeamName) {
        this.visitorTeamName = visitorTeamName;
    }

    public int getVisitorTeamGoals() {
        return visitorTeamGoals;
    }

    public void setVisitorTeamGoals(int visitorTeamGoals) {
        this.visitorTeamGoals = visitorTeamGoals;
    }

    // Constructor
    public Match(String homeTeamName, int homeTeamGoals, String visitorTeamName, int visitorTeamGoals) {
        this.homeTeamName = homeTeamName;
        this.homeTeamGoals = homeTeamGoals;
        this.visitorTeamName = visitorTeamName;
        this.visitorTeamGoals = visitorTeamGoals;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeamName='" + homeTeamName + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", visitorTeamName='" + visitorTeamName + '\'' +
                ", visitorTeamGoals=" + visitorTeamGoals +
                '}';
    }
}
