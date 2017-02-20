import java.util.Objects;

/**
 * Created by dvadmin on 2/20/2017.
 */
public enum Extras {
    Mushroom,
    Tomato;

    static Extras fromChar(char c) {
        if (Objects.equals(c, 'T')) {
            return Tomato;
        }
        return Mushroom;
    }
    @Override
    public String toString() {
        if (this.equals(Tomato)) {
            return "T";
        }
        return "M";
    }
}
