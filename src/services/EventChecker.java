package services;

import entities.controls.Exam;
import entities.controls.Test;
import entities.events.FirstControlEvent;
import entities.events.SecondControlEvent;
import entities.events.ThirdControlEvent;

import java.util.List;

public class EventChecker {

    public static void isPassedSession(FirstControlEvent controlEvent) {
        double sumScore = calculateSumScore(controlEvent.getExams());
        boolean isPassed = sumScore >= controlEvent.getPassingScore();
        controlEvent.setSessionPassed(isPassed);
    }

    public static void isPassedSession(SecondControlEvent controlEvent) {
        double sumScore = calculateSumScore(controlEvent.getExams());
        boolean isPassed = sumScore >= controlEvent.getPassingScore() && isTestsPassed(controlEvent.getTests());
        controlEvent.setSessionPassed(isPassed);
    }

    public static void isPassedSession(ThirdControlEvent controlEvent) {
        boolean isPassed = isTestsPassed(controlEvent.getTests());
        controlEvent.setSessionPassed(isPassed);
    }

    private static double calculateSumScore(List<Exam> exams){
        double sumScore = 0;
        for (Exam value : exams) {
            sumScore += value.getScore();
        }
        return sumScore;
    }

    private static boolean isTestsPassed(List<Test> tests){
        int numberTestsPassed = 0;
        for (Test value : tests) {
            if (value.isPassed()) {
                numberTestsPassed++;
            }
        }
        if (tests.size() > 1) {
            return numberTestsPassed > tests.size() / 2;
        } else {
            return numberTestsPassed == 1;
        }
    }
}
