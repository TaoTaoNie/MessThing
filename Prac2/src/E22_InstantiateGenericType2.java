import java.util.Arrays;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E22_InstantiateGenericType2 {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe =
                new ClassAsFactory<Employee>(Employee.class);
        Employee emp = fe.create(1);
        if(emp == null)
            System.out.println("Employee cannot be instantiated!");
        ClassAsFactory<Integer> fi =
                new ClassAsFactory<Integer>(Integer.class);
        Integer i = fi.create(0);
        if(i == null)
            System.out.println("Integer cannot be instantiated!");
    }
}

class Employee{}
