import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E07_CrossInsertion {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Countries.names(10));
        LinkedList<String> linkedList = new LinkedList<>(Countries.names(20).subList(10, 20));
        for(Iterator<String> it = arrayList.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        System.out.println("********");
        for(Iterator<String> it = linkedList.iterator(); it.hasNext();)
            System.out.println(it.next());
        System.out.println("********");
        int alindex = 0;
        for(ListIterator<String> lit2 = linkedList.listIterator(); lit2.hasNext();) {
            arrayList.add(alindex, lit2.next());
            alindex += 2;
        }
        System.out.println("al = " + arrayList);
        System.out.println("********");
        for (ListIterator<String> lit2 = linkedList.listIterator(linkedList.size()); lit2.hasPrevious();) {
            arrayList.add(alindex, lit2.previous());
            alindex += 2;
        }
        System.out.println("al = " + arrayList);
    }
}
