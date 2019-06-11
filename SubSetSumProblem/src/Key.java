import java.util.List;
import java.util.Objects;

public class Key {
    List<Integer> list;
    int k;

    public Key(List<Integer> list, int k){
        this.list = list;
        this.k = k;

    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return getK() == key.getK() &&
                Objects.equals(getList(), key.getList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getList(), getK());
    }
}
