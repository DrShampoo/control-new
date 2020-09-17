package entities.events;

import entities.controls.Exam;
import entities.controls.Test;

import java.util.List;

public abstract class ControlEvent {
    private List<Exam> exams;
    private double passingScore;
    private List<Test> tests;
    private boolean isSessionPassed;


    public ControlEvent(List<Exam> exams, double passingScore, List<Test> tests) {
        this.exams = exams;
        this.passingScore = passingScore;
        this.tests = tests;
    }

    public ControlEvent(List<Exam> exams, int passingScore) {
        this.exams = exams;
        this.passingScore = passingScore;
    }

    public ControlEvent(List<Test> tests) {
        this.tests = tests;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public boolean isSessionPassed() {
        return isSessionPassed;
    }

    public void setSessionPassed(boolean sessionPassed) {
        isSessionPassed = sessionPassed;
    }
}
