import java.util.ArrayList;
import java.util.List;

public class GenericDemo<T> {
    private T t;

    public GenericDemo(T t) {
        this.t = t;
    }

    static <T> List<T> emptyList() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
    }

}
