package entities.events;

import entities.controls.Exam;
import entities.controls.Test;

import java.util.List;

public class SecondControlEvent extends ControlEvent {

    public SecondControlEvent(List<Exam> exams, double passingScore, List<Test> tests) {
        super(exams, passingScore, tests);
    }

    @Override
    public String toString() {
        return "Control event №2: the result - " + this.isSessionPassed();
    }
}
