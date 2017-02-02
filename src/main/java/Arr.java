import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lukasz on 1/30/17.
 */
public class Arr {
    int x;
    String username;
    List<Integer> w = new ArrayList<>();
    List<String> names = Arrays.asList("KKK", "ABC", "testowy");

    public Arr(int x, List<Integer> w) {
        this.x = x;
        this.w = w;
    }

    public Arr() {
    }

    public boolean contains() {
        return names.stream().filter(i -> i.equals(username)).findFirst().isPresent();
    }

    public int size() {
        for (int i = 1; i <= this.x; i++) {
            w.add(i);
        }
        return w.stream().mapToInt(Integer::intValue).sum();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public List<Integer> getW() {
        return w;
    }

    public void setW(List<Integer> w) {
        this.w = w;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
