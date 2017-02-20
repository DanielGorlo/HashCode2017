import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String path = classloader.getResource("example.in").getPath();


        Pizza pizza = Utils.parsePizza(path);

        printPizza(pizza);

        Slice currentSlice;
        ArrayList<Slice> potentialSlices = new ArrayList<>();

        NumberOfExtras numberOfExtras;

        //First, we brute force the shit out of the pizza
        rows:
        for (int r = 0; r < pizza.getWidth(); r++) {

            columns:
            for (int c = 0; c < pizza.getHeight(); c++) {

                row_width:
                for (int rw = 1; rw < pizza.getWidth() - r; rw++) {
                    currentSlice = new Slice(r, c, rw, 1);

                    numberOfExtras = Utils.getNumberOfExras(currentSlice, pizza);

                    if (numberOfExtras.numberOfTomatoes > pizza.getH() || numberOfExtras.numberOfMushrooms > pizza.getH()) {
                        break row_width;
                    }

                    column_height:
                    for (int ch = 1; ch < pizza.getHeight() - c; ch++) {
                        currentSlice = new Slice(r, c, rw, ch);

                        numberOfExtras = Utils.getNumberOfExras(currentSlice, pizza);

                        if (numberOfExtras.numberOfTomatoes > pizza.getH() || numberOfExtras.numberOfMushrooms > pizza.getH()) {
                            break column_height;
                        }

                        if (numberOfExtras.numberOfTomatoes < pizza.getL() || numberOfExtras.numberOfMushrooms < pizza.getL()) {
                            continue;
                        }

                        potentialSlices.add(currentSlice);
                    }
                }
            }
        }

        printSlices(potentialSlices);

        //Next, we check for overlaps

    }

    private static void printPizza(Pizza pizza) {
        System.out.println("Pizza:");
        System.out.println(pizza);
    }

    private static void printSlices(ArrayList<Slice> potentialSlices) {
        System.out.println("Potential slices:");
        for (Slice s : potentialSlices) {
            System.out.println(s);
        }
    }
}
