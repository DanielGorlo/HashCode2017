import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String path = classloader.getResource("example.in").getPath();

        Pizza pizza = Utils.parsePizza(path);

        printPizza(pizza);

        //First, we brute force the shit out of the pizza
        ArrayList<Slice> allPossibleSlices = getPotentialSlices(pizza);

        printSlices(allPossibleSlices);

    }
        //Next, we check for overlaps
//        for (int i = 0; i < allPossibleSlices.size(); i++) {
//            Slice currentSlice = allPossibleSlices.get(i);
//            ArrayList<Slice> potentialSliceGroups = new ArrayList<>();
//            potentialSliceGroups.add(currentSlice);
//
//            ArrayList<Slice> matchingSlices = getMatchingSlices(currentSlice, allPossibleSlices);
//            while (matchingSlices.size() >= 0) {
//
//            }
//        }
//    }
//
//    private static ArrayList<Slice> getMatchingSlices(Slice s1, ArrayList<Slice> allPossibleSlices) {
//        ArrayList<Slice> nonOverlappingSlices = new ArrayList<>();
//        for (Slice s2 : allPossibleSlices) {
//            if (!s2.isOverlapping(s1)) {
//                nonOverlappingSlices.add(s2);
//            }
//
//        }
//        return nonOverlappingSlices;
//    }

    private static ArrayList<Slice> getPotentialSlices(Pizza pizza) {
        ArrayList<Slice> potentialSlices = new ArrayList<>();
        Slice currentSlice;
        NumberOfExtras numberOfExtras;
        rows:
        for (int r = 0; r < pizza.getWidth(); r++) {

            columns:
            for (int c = 0; c < pizza.getHeight(); c++) {

                row_width:
                for (int rw = 2 * pizza.getL(); rw <= pizza.getWidth() - r; rw++) {
                    currentSlice = new Slice(r, c, rw, 1);

                    numberOfExtras = Utils.getNumberOfExras(currentSlice, pizza);

                    if (numberOfExtras.numberOfTomatoes > pizza.getH() || numberOfExtras.numberOfMushrooms > pizza.getH()) {
                        break row_width;
                    }

                    column_height:
                    for (int ch = 1; ch <= pizza.getHeight() - c; ch++) {
                        currentSlice = new Slice(r, c, rw, ch);

                        numberOfExtras = Utils.getNumberOfExras(currentSlice, pizza);

                        if (numberOfExtras.numberOfTomatoes > pizza.getH() || numberOfExtras.numberOfMushrooms > pizza.getH()) {
                            break column_height;
                        }

                        if (numberOfExtras.numberOfTomatoes < pizza.getL() || numberOfExtras.numberOfMushrooms < pizza.getL()) {
                            continue column_height;
                        }

                        potentialSlices.add(currentSlice);
                    }
                }
            }
        }
        return null;
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
