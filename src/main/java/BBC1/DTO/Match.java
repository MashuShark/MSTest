package BBC1.DTO;

public class Match {

    private String firstTeam;
    private String secondTeam;
    private String score;

    public Match(String firstTeam, String secondTeam, String score){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.score = score;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public String getScore() {
        return score;
    }
}
