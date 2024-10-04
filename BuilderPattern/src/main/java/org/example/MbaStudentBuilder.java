package org.example;

import java.util.ArrayList;
import java.util.List;

public class MbaStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Finance");
        subs.add("HR");
        subs.add("Public Speaking");
        this.subjects = subs;
        return this;
    }
}
