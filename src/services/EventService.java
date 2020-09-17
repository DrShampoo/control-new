package services;

import entities.controls.Exam;
import entities.controls.Test;
import entities.events.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EventService {
    private List<ControlEvent> controlEvents = new ArrayList<>();


    public void loadFile(String pathToFile) {
        File file = new File(pathToFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                ControlEvent event = getControlEvent(scanner.nextLine());
                controlEvents.add(event);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        }
    }

    private ControlEvent getControlEvent(String line) {
        String[] eventResult = line.split(":");
        switch (eventResult[0]) {
            case Constants.FIRST_CONTROL_EVENT_NUMBER:
                int firstExamResult = Integer.parseInt(eventResult[1].split(Constants.SPLIT_TEST_STRING)[0]);
                int secondExamResult = Integer.parseInt(eventResult[1].split(Constants.SPLIT_TEST_STRING)[1]);
                return createFirstControlEvent(firstExamResult, secondExamResult);
            case Constants.SECOND_CONTROL_EVENT_NUMBER:
                double examResult = Double.parseDouble(eventResult[1].split(Constants.SPLIT_TEST_STRING)[0]);
                boolean testResult = Boolean.parseBoolean(eventResult[1].split(Constants.SPLIT_TEST_STRING)[1]);
                return createSecondControlEvent(examResult, testResult);
            case Constants.THIRD_CONTROL_EVENT_NUMBER:
                boolean isFirstTestPassed = Boolean.parseBoolean(eventResult[1].split(Constants.SPLIT_TEST_STRING)[0]);
                boolean isSecondTestPassed = Boolean.parseBoolean(eventResult[1].split(Constants.SPLIT_TEST_STRING)[1]);
                boolean isThirdTestPassed = Boolean.parseBoolean(eventResult[1].split(Constants.SPLIT_TEST_STRING)[2]);
                return createThirdControlEvent(isFirstTestPassed, isSecondTestPassed, isThirdTestPassed);
            default:
                throw new RuntimeException("Such control event is not available");
        }
    }

    private FirstControlEvent createFirstControlEvent(int firstScore, int secondScore) {
        Exam firstExam = new Exam(new ScoreRestriction(1, 10), firstScore);
        Exam secondExam = new Exam(new ScoreRestriction(1, 15), secondScore);
        List<Exam> exams = Arrays.asList(firstExam, secondExam);
        FirstControlEvent firstControlEvent = new FirstControlEvent(exams, Constants.PASSING_SCORE_FIRST_EVENT);
        EventChecker.isPassedSession(firstControlEvent);
        return firstControlEvent;
    }

    private SecondControlEvent createSecondControlEvent(double examResult, boolean isTestPassed) {
        Exam exam = new Exam(new ScoreRestriction(0, 10), examResult);
        Test test = new Test(isTestPassed);
        List<Exam> exams = new ArrayList<>();
        List<Test> tests = new ArrayList<>();
        exams.add(exam);
        tests.add(test);
        SecondControlEvent secondControlEvent = new SecondControlEvent(exams, Constants.PASSING_SCORE_SECOND_EVENT, tests);
        EventChecker.isPassedSession(secondControlEvent);
        return secondControlEvent;
    }

    private ThirdControlEvent createThirdControlEvent(boolean isFirstTestPassed, boolean isSecondTestPassed, boolean isThirdTestPassed){
        Test firstTest = new Test(isFirstTestPassed);
        Test secondTest = new Test(isSecondTestPassed);
        Test thirdTest = new Test(isThirdTestPassed);
        List<Test> tests = Arrays.asList(firstTest, secondTest, thirdTest);
        ThirdControlEvent thirdControlEvent = new ThirdControlEvent(tests);
        EventChecker.isPassedSession(thirdControlEvent);
        return thirdControlEvent;
    }


    public void printControlEvents() {
        controlEvents.forEach(controlEvent -> System.out.println(controlEvent));
    }

    public void sortControlEvents() {
        controlEvents.sort((controlEvents1, controlEvent2) -> Boolean.compare(controlEvent2.isSessionPassed(), controlEvents1.isSessionPassed()));
    }
}
