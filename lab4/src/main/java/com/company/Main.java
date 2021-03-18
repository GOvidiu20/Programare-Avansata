package com.company;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(new Faker(),(int)((Math.random() * 10)%10+1)) )
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();
        studentList.addAll(Arrays.asList(students));

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School(new Faker(),((int)(Math.random() * 10))%3+2)) //((int)(Math.random() * 10))%3+1
                .toArray(School[]::new);
        List<School> schoolList = new LinkedList<>();
        schoolList.addAll(Arrays.asList(schools));

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        stdPrefMap.put(studentList.get(0), Arrays.asList(schools[1], schools[0], schools[2]));
        stdPrefMap.put(studentList.get(1), Arrays.asList(schools[1], schools[0], schools[2]));
        stdPrefMap.put(studentList.get(2), Arrays.asList(schools[1], schools[2]));
        stdPrefMap.put(studentList.get(3), Arrays.asList(schools[1], schools[2]));


        Map<School, List<Student>> schPrefMap = new HashMap<>();
        schPrefMap.put(schoolList.get(0), Arrays.asList(students[3], students[0],students[1],students[2]));
        schPrefMap.put(schoolList.get(1), Arrays.asList(students[2], students[3], students[1]));
        schPrefMap.put(schoolList.get(2), Arrays.asList(students[0], students[1], students[3]));

        //Optional
        Describe problem1=new Describe();
        problem1.setSchoolList(schoolList);
        problem1.setStudentList(studentList);
        problem1.setStdPrefMap(stdPrefMap);
        problem1.setSchPrefMap(schPrefMap);
        problem1.describe();
        System.out.println();
        /*List<School> target = Arrays.asList(schoolList.get(0), schoolList.get(2));
        problem1.studentsAcceptSchools(target);
        System.out.println();
        problem1.schoolsPreferance(studentList.get(0));
        */
        System.out.println("OPTIONAL:");
        SolutionOptional s1=new SolutionOptional();
        s1.Solution(problem1);
        System.out.println();
        System.out.println("BONUS:");
        SolutionBonus s2=new SolutionBonus();
        s2.solution(problem1);

        List<Student> lista=Arrays.asList(students[3], students[0]);
    }
}