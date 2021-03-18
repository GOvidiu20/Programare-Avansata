package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Describe {
    List<Student> studentList = new LinkedList<>();
    List<School> schoolList = new LinkedList<>();
    Map<Student, List<School>> stdPrefMap = new HashMap<>();
    Map<School, List<Student>> schPrefMap = new HashMap<>();

    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public List<School> getSchoolList() {
        return schoolList;
    }
    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }
    public Map<Student, List<School>> getStdPrefMap() {
        return stdPrefMap;
    }
    public void setStdPrefMap(Map<Student, List<School>> stdPrefMap) {
        this.stdPrefMap = stdPrefMap;
    }
    public Map<School, List<Student>> getSchPrefMap() {
        return schPrefMap;
    }
    public void setSchPrefMap(Map<School, List<Student>> schPrefMap) {
        this.schPrefMap = schPrefMap;
    }
    public void describe() {
        for(Map.Entry<Student,List<School>> entry : stdPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName()+" "+entry.getKey().getScore()+" :");
            for(School x : entry.getValue())
                System.out.print(x.getName()+" , ");
            System.out.println();
        }
        System.out.println();
        for(Map.Entry<School,List<Student>> entry : schPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName()+" "+entry.getKey().getCapacity()+" :");
            for(Student x : entry.getValue())
                System.out.print(x.getName()+" , ");
            System.out.println();
        }
    }
    public void studentsAcceptSchools(List<School> target){
        List<Student> result = studentList.stream()
                              .filter(std -> stdPrefMap.get(std).containsAll(target))
                              .collect(Collectors.toList());
        for(Student x : result)
            System.out.print("{" + x.getName()+ "} ");
    }
    public void schoolsPreferance(Student student){
        List<School> result2=schoolList.stream()
                .filter(std -> schPrefMap.get(std).contains(student))
                .collect(Collectors.toList());
        for(School x : result2)
            System.out.print("{" + x.getName()+"} ");
    }
}
