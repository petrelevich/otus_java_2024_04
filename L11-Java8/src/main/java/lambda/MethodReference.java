package lambda;

@SuppressWarnings({"java:S1612", "java:S1604"})
public class MethodReference {
    public interface Finder {
        int find(String s1, String s2);
    }

    Finder finder = new Finder() {
        @Override
        public int find(String s1, String s2) {
            return s1.indexOf(s2);
        }
    };

    Finder finder2 = (s1, s2) -> s1.indexOf(s2);

    Finder finder1 = String::indexOf;
}
