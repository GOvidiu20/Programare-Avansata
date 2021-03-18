package com.company;

import java.util.*;

public class SolutionOptional {
    Map<School,Integer> currentCapacity=new HashMap<>();
    private void setCapacities( School scoala , int newCap){ //update la o capacitate cand adaugam un nou elev
     currentCapacity.put(scoala,newCap);
    }
    private int getSchoolCapacity(School x){//da capacitatea unei scoli la un momentdat
        for(Map.Entry<School,Integer> entry : currentCapacity.entrySet())
            if(entry.getKey().equals(x))
                return entry.getValue();
        return 0;
    }
    private List<School> getListForStudent(Map<Student,List<School>> studenti,Student x){
        for(Map.Entry<Student,List<School>> entry : studenti.entrySet())
            if(entry.getKey().equals(x))
                return entry.getValue();
        return null;
    }
    private List<Student> getListaScoala(Map<School,List<Student>> lista,School scoala){
        for(Map.Entry<School,List<Student>> entry : lista.entrySet()){
            if(entry.getKey().equals(scoala))
                return entry.getValue();
        }
        return null;
    }
    public void Solution(Describe problema) {
        Map<School, List<Student>> studentsAccepted = new HashMap<>();
        List<School> listaScoli = new ArrayList<>();
        List<Student>listaStudenti = new ArrayList<>();
        listaStudenti=problema.getStudentList();
        Comparator<Student> byScore = Comparator.comparing(Student::getScore).reversed();
        Collections.sort(listaStudenti, byScore);
        for(Student student : listaStudenti){
            listaScoli=getListForStudent(problema.getStdPrefMap(),student);
            for(School scoala : listaScoli) {
                int capacity=getSchoolCapacity(scoala);
                List<Student> listaAuxiliara=new ArrayList<>();
                if (scoala.getCapacity() > capacity){
                    if(capacity!=0)
                        listaAuxiliara=getListaScoala(studentsAccepted,scoala);
                    listaAuxiliara.add(student);
                    capacity++;
                    setCapacities(scoala,capacity);
                    studentsAccepted.put(scoala,listaAuxiliara);
                    break;
                }
            }
        }

        for (Map.Entry<School, List<Student>> entry : studentsAccepted.entrySet()) {
            System.out.print(entry.getKey().getName() + " : ");
            Collections.sort(entry.getValue(), byScore);
            for (Student x : entry.getValue())
                System.out.print("{"+x.getName()+","+x.getScore()+"}");
            System.out.println();
        }
    }
}
