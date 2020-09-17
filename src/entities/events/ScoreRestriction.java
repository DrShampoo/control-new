package entities.events;

public class ScoreRestriction {
    private int minScore;
    private int maxScore;

    public ScoreRestriction(int minScore, int maxScore) {
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public double checkScore(double score){
        return score <= minScore && score >= maxScore ? minScore : score;
    }

}
