package entities.controls;

import entities.events.ScoreRestriction;

public class Exam {

    private double score;


    public Exam(ScoreRestriction scoreRestriction, double score) {
        this.score = scoreRestriction.checkScore(score);
    }

    public double getScore() {
        return score;
    }

}
