package nestedclasses.soccer;

public class TeamStatistics {

    private String teamName;
    private int played;
    private int won;
    private int tie;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst){
        goalsFor+=plusGoalsFor;
        goalsAgainst+=plusGoalsAgainst;
        played++;

        if(plusGoalsFor>plusGoalsAgainst){
            won++;
            points+=3;
        }
        else if(plusGoalsFor==plusGoalsAgainst){
            tie++;
            points+=1;
        }
        else{
            lost++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamStatistics that = (TeamStatistics) o;

        return teamName != null ? teamName.equals(that.teamName) : that.teamName == null;
    }

    @Override
    public int hashCode() {
        return teamName != null ? teamName.hashCode() : 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getTied() {
        return tie;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }
}
