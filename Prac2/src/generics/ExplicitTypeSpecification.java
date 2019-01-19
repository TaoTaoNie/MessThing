package generics;//: generics/ExplicitTypeSpecification.java
import generics.pets.*;
import java.util.*;
import generics.util.*;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
