/**
 * Created by dvadmin on 2/20/2017.
 */
public class Slice {
    private int x;
    private int y;
    private int w;
    private int h;

    public Slice() {

    }

    public Slice(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Slice(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isOverlapping(Slice s) {
        if (getX() + getW() < s.getX() && s.getY() + s.getH() > getY()) {
            return true;
        }
        if (getY() + getH() < s.getY() && s.getX() + s.getW() > getX()) {
            return true;
        }
        if (s.getX() + s.getW() < getX() && getY() + getH() > s.getY()) {
            return true;
        }
        if (s.getY() + s.getH() < getY() && getX() + getW() > s. getX()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "|x: " + getX() + "| y: " + getY() + "| w:" + getW() + "| h:" + getH() + "|";
    }
}
