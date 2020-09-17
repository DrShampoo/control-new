package entities.events;

import entities.controls.Exam;

import java.util.List;

public class FirstControlEvent extends ControlEvent {


    public FirstControlEvent(List<Exam> exams, int passingScore) {
        super(exams, passingScore);
    }

    @Override
    public String toString() {
        return "Control event №1: total - " + this.isSessionPassed();
    }
}
