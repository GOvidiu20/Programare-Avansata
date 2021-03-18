package com.company;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SolutionBonus {
    Map<School,Integer> currentCapacity=new HashMap<>();
    private void setCapacities(List<School> schools, School scoala , int newCap){ //supdate la o capacitate cand adaugam un nou elev
        for(School x : schools)
            if(scoala.equals(x))
                currentCapacity.put(x,newCap);
    }
    private int getSchoolCapacity(School x){//da capacitatea unei scoli la un momentdat
        for(Map.Entry<School,Integer> entry : currentCapacity.entrySet())
            if(entry.getKey().equals(x))
                return entry.getValue();
        return 0;
    }
    private List<Student> getListaStudenti(Map<School, List<Student>> scoli,School scoala){ //ne da lista de studenti  pe care o are o scoala la un momentdat
        for(Map.Entry<School,List<Student>> entry : scoli.entrySet())
            if(entry.getKey().equals(scoala))
                return entry.getValue();
        return null;
    }
    private int getCapacities(School x) {
        for (Map.Entry<School, Integer> entry : currentCapacity.entrySet())
            if (entry.getKey().equals(x))
                return entry.getValue();
        return 0;
    }
    private Map<Student,Boolean> setAdmis(List<Student> studs){
        Map<Student,Boolean> x=new HashMap<>();
        for(Student st : studs)
            x.put(st,FALSE);
        return x;
    }
    private Boolean getStudentStatus(Map<Student,Boolean> x,Student stud){
        for(Map.Entry<Student,Boolean> entry : x.entrySet())
            if(entry.getKey().equals(stud))
                return entry.getValue();
        return TRUE;
    }
    private void changeStatus(Map<Student,Boolean> x,Student stud,Boolean value){
        for(Map.Entry<Student,Boolean> entry : x.entrySet())
            if(entry.getKey().equals(stud))
                x.put(stud,value);
    }
    private boolean capacityNotFull(List<School> scoli){
        int aux=0;
        for(School x : scoli)
            if(x.getCapacity()==getCapacities(x))
                aux++;
        if(aux==scoli.size())
            return FALSE;
        return TRUE;
    }
    private int getPlaceFromPreferinte(List<Student> lista,Student student){
        int i=0;
        for(Student x : lista) {
            i++;
            if (x.equals(student))
                return i;
        }
        return 0;
    }
    private Student getMinim(List<Student> lista1,List<Student>lista2){
        int maxim=0;
        Student stud=null;
        for(Student x : lista2) {
            int place = getPlaceFromPreferinte(lista1, x);
            if(place == 0 )
                return x;
            if (place > maxim) {
                maxim = place;
                stud = x;
            }
        }
        return stud;
    }
    public Student getLowestRanking(Map<School, List<Student>> scoli,List<Student>list,School x){

        Student stud=null;
        for(Map.Entry<School,List<Student>> entry : scoli.entrySet())
            if(entry.getKey().equals(x))
                return getMinim(entry.getValue(),list);
        return stud;
    }
    public List<Student> getListaStudentiPreferati(Map<School, List<Student>> scoli,School x){
        for(Map.Entry<School,List<Student>> entry : scoli.entrySet())
            if(entry.getKey().equals(x))
                return entry.getValue();
        return null;
    }
    public void solution(Describe problem) {
        Map<School, List<Student>> studentsAccepted = new HashMap<>();
        Map<Student, List<School>> studentsPreferences = new HashMap<>();
        Map<School, List<Student>> schoolsPreferences = new HashMap<>();
        Map<Student, Boolean> admis = new HashMap<>();
        admis = setAdmis(problem.studentList);
        studentsPreferences = problem.getStdPrefMap();
        schoolsPreferences = problem.getSchPrefMap();
        int finish = problem.studentList.size();
        while (finish != 0 && capacityNotFull(problem.schoolList)) { //mai sunt studenti de admis si capacitate in scoli
            for (Map.Entry<Student, List<School>> entry : studentsPreferences.entrySet()) { // pentru fiecare student
                for (School x : entry.getValue()) {   //luam lista lui cu scoli preferate
                    if (getStudentStatus(admis, entry.getKey()) == FALSE) {  //daca studentul nu e admis nicaieri
                        if (x.getCapacity() > getSchoolCapacity(x)) { // daca lista scolii nu e plina i-l adaugam
                            List<Student> listaStudenti = new ArrayList<>();
                            if (getSchoolCapacity(x) != 0)
                                listaStudenti = getListaStudenti(studentsAccepted, x);
                            listaStudenti.add(entry.getKey());
                            studentsAccepted.put(x, listaStudenti);
                            int cap = getCapacities(x) + 1;
                            setCapacities(problem.getSchoolList(), x, cap);
                            changeStatus(admis, entry.getKey(), TRUE);
                            finish--;
                            break;
                        } else { // daca lista e plina,scoatem studentul cu cel mai mic scor si il introducem pe studentul curent
                            List<Student> listaStudenti = new ArrayList<>();
                            listaStudenti = getListaStudenti(studentsAccepted, x);
                            Student s = getLowestRanking(schoolsPreferences,listaStudenti,x);//alege studentul care se afla pe cel mai jos rank in preferinta scolii
                            int placeStudentActual=getPlaceFromPreferinte(getListaStudentiPreferati(schoolsPreferences,x), entry.getKey());
                            int placeStudentVerificat=getPlaceFromPreferinte(getListaStudentiPreferati(schoolsPreferences,x), s);
                            if ( placeStudentVerificat ==0 || placeStudentActual< placeStudentVerificat && placeStudentActual !=0) {//daca studentul actual se afla mai sus in lista de preferinte a scolii
                                listaStudenti.remove(s);
                                listaStudenti.add(entry.getKey());
                                studentsAccepted.put(x, listaStudenti);
                                changeStatus(admis, s, FALSE);
                                changeStatus(admis, entry.getKey(), TRUE);
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (Map.Entry<School, List<Student>> entry : studentsAccepted.entrySet()) {
            System.out.print(entry.getKey().getName() + " : ");
            Comparator<Student> byScore = Comparator.comparing(Student::getScore).reversed();
            Collections.sort(entry.getValue(), byScore);
            for (Student x : entry.getValue())
                System.out.print("{" + x.getName() + "," + x.getScore() + "}");
            System.out.println();
        }
        System.out.println();
        int i = 0;
        for (Student x : problem.getStudentList()) {
            System.out.println("Student" + i + " " + x.getName());
            i++;
        }
        i=0;
        System.out.println();
        for(School x: problem.getSchoolList()){
            System.out.println("scoala" + i + " " + x.getName());
            i++;
        }
    }
}
