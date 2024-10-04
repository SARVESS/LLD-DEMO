package org.example;

public class Director {

    StudentBuilder studentBuilder;
    public Director(StudentBuilder studentBuilder) {
         this.studentBuilder = studentBuilder;
    }


    public Student createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        }
        else if(studentBuilder instanceof MbaStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setRollNumber(2).setAge(10).setName("Ramesh").setSubjects().build();
    }

    private Student createMBAStudent() {
        return studentBuilder.setName("Suresh").setRollNumber(10).setFatherName("Suren").setMotherName("Mamta").setAge(20).setSubjects().build();
    }

}
