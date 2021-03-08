package com.company;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();
        studentList.addAll(Arrays.asList(students));
        Collections.sort(studentList,
                ((s1, s2) -> s1.getName().compareTo(s2.getName())));

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i) )
                .toArray(School[]::new);
        List<School> schoolList = new LinkedList<>();
        schoolList.addAll(Arrays.asList(schools));
        schoolList.stream()
                .sorted(Comparator.comparing(School::getName))
                .collect(Collectors.toList());

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        stdPrefMap.put(studentList.get(0), Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(studentList.get(1), Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(studentList.get(2), Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(studentList.get(3), Arrays.asList(schools[0], schools[2]));


        Map<School, List<Student>> schPrefMap = new HashMap<>();
        schPrefMap.put(schoolList.get(0), Arrays.asList(students[3], students[0],students[1],students[2]));
        schPrefMap.put(schoolList.get(1), Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schoolList.get(2), Arrays.asList(students[0], students[1], students[3]));

        System.out.println();
        for(Map.Entry<Student,List<School>> entry : stdPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName()+":");
            for(School x : entry.getValue())
                System.out.print(x.getName()+" ");
            System.out.println();
        }
        System.out.println();
        for(Map.Entry<School,List<Student>> entry : schPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName()+":");
            for(Student x : entry.getValue())
                System.out.print(x.getName()+" ");
            System.out.println();
        }
    }
}