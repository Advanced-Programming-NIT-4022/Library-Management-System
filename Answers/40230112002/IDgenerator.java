import java.util.HashSet;

public interface IDgenerator<E extends Comparable> {
    HashSet<Integer> UsedID = new HashSet<>();
    // Added an Interface for the Repeated Usage of IDgenerator in all classes
    E Unique_ID_Generator();
}
