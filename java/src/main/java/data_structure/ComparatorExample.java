package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorExample {
  static class Person {
    String name;
    int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public int getAge() { return this.age; }

    public String getName() { return this.name; }
  }

  // instance initializer block
  static List<Person> people = new ArrayList<>();
  {
    people.add(new Person("John", 25));
    people.add(new Person("kyle", 30));
    people.add(new Person("Peter", 22));
  }

  public static void main(String argc[]) {
    List<Person> peopletwo = new ArrayList<>();
    peopletwo.add(new Person("John", 25));
    peopletwo.add(new Person("kyle", 30));
    peopletwo.add(new Person("Peter", 22));

    Comparator<Person> ageComparator = new Comparator<Person>() {
      @Override
      public int compare(Person p1, Person p2) {
        return p1.age - p2.age; // accending order
        // return p2.age - p1.age // descending order
      }
    };

    Collections.sort(people, ageComparator);
    Collections.sort(peopletwo, ageComparator);
    System.out.println(people);

    // Descending
    Comparator<Person> ageComparatorDesc = ageComparator.reversed();
    Comparator<Person> ageComparatorDescLambda = (p1, p2) -> p2.age - p1.age;

    // Comparator Static Methods
    // comparing
    Comparator<Person> byAge = Comparator.comparing(p -> p.age);
    Comparator<Person> byName = Comparator.comparing(p -> p.name);
    // comparing with method references
    Comparator<Person> byAgeTwo = Comparator.comparing(Person::getAge);
    // Reverse order
    Comparator<Person> byAgeRev =
            Comparator.comparing(Person::getAge).reversed();
    // Natural order for primitives
    Comparator<Person> byAgePrimitive = Comparator.comparingInt(Person::getAge);

    // Chaining Comparators: sort by age then name
    Comparator<Person> multiSort =
            Comparator.comparing(Person::getAge).thenComparing(Person::getName);

    // Null Handling
    Comparator<Person> nullsFrist =
            Comparator.nullsFirst(Comparator.comparing(Person::getName));
    Comparator<Person> nullsLast =
            Comparator.nullsLast(Comparator.comparing(Person::getName));
  }
}
