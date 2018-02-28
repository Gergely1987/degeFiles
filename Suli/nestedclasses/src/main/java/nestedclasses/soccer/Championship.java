package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;

public class Championship {

    private List<TeamStatistics> teamStatistics = new ArrayList<>();

    public List<TeamStatistics> getTeamStatistics() {
        return teamStatistics;
    }

    private boolean didPlayBefor(String team) {
        for (TeamStatistics ts : teamStatistics) {
            if (team.equals(ts.getTeamName())) {
                return true;
            }
        }
        return false;
    }

    public void addGame(GameResult result) {
        if (didPlayBefor(result.teamHome)) {
            for (TeamStatistics ts : teamStatistics) {
                if (result.teamHome.equals(ts.getTeamName())) {
                    ts.played(result.goalHome, result.goalGuest);
                }
            }
        } else {
            TeamStatistics newTeam = new TeamStatistics(result.teamHome);
            newTeam.played(result.goalHome, result.goalGuest);
            teamStatistics.add(newTeam);
        }

        if (didPlayBefor(result.teamGuest)) {
            for (TeamStatistics ts : teamStatistics) {

                if (ts.getTeamName().equals(result.teamGuest)) {
                    ts.played(result.goalGuest, result.goalHome);
                }
            }
        } else {
            TeamStatistics newTeam = new TeamStatistics(result.teamGuest);
            newTeam.played(result.goalGuest,result.goalHome);
            teamStatistics.add(newTeam);


        }

    }

    public List<TeamStatistics> getLeagueTable() {
        return teamStatistics;
    }

    protected static class GameResult {
        private String teamHome;
        private String teamGuest;
        private int goalHome;
        private int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }
}
