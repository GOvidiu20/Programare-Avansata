package Optional;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Relationships {
    private Map<Vertex, List<Vertex>> relatii;

    public void addRelationship(Vertex vertex,Vertex vertex1){
        List<Vertex> lista=relatii.get(vertex);
        lista.add(vertex1);
        relatii.put(vertex,lista);

        lista=relatii.get(vertex1);
        lista.add(vertex);
        relatii.put(vertex1,lista);
    }
    public Map<Vertex, List<Vertex>> getRelatii() {
        return relatii;
    }
    public void setRelatii(Map<Vertex, List<Vertex>> relatii) {
        this.relatii = relatii;
    }

    public List<Vertex> mostConnectedPersons(int k){
        Map<Vertex,List<Vertex>> sorted = relatii.entrySet().stream()
                .sorted(comparingByValue(comparingInt(List::size)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        Iterator it = sorted.entrySet().iterator();
        int i=0;
        List<Vertex> vertices=new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
            if(i>=sorted.size()-k)
                vertices.add((Vertex) pair.getKey());
            i++;
        }
        return vertices;
    }
    public List<Vertex> leastConnectedPersons(int k){
        Map<Vertex,List<Vertex>> sorted = relatii.entrySet().stream()
                .sorted(comparingByValue(comparingInt(List::size)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        Iterator it = sorted.entrySet().iterator();
        int i=0;
        List<Vertex> vertices=new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
            if(i<k)
                vertices.add((Vertex) pair.getKey());
            i++;
        }
        return vertices;
    }
}
