/**
 * Created by dvadmin on 2/20/2017.
 */
public class Pizza {
    private Extras[][] pizzaMatrix;
    private int l;
    private int h;

    public Pizza(Extras[][] pizzaMatrix, int l, int h) {
        this.pizzaMatrix = pizzaMatrix;
        this.l = l;
        this.h = h;
    }

    public Extras[][] getPizzaMatrix() {
        return pizzaMatrix;
    }

    public int getWidth() {
        return pizzaMatrix.length;
    }

    public int getHeight() {
        return pizzaMatrix[0].length;
    }

    public int getH() {
        return h;
    }

    public int getL() {
        return l;
    }

    @Override
    public String toString() {
        String output = "";
        output += "R: " + getWidth() + System.lineSeparator();
        output += "C: " + getHeight() + System.lineSeparator();
        output += "L: " + getL() + System.lineSeparator();
        output += "H: " + getH() + System.lineSeparator();

        columns:
        for (int c = 0; c < getHeight(); c++) {
            rows:
            for (int r = 0; r < getWidth(); r++) {
                output += getPizzaMatrix()[r][c];
            }

            output += System.lineSeparator();
        }
        return output;
    }
}
