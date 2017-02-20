public class Main {

    public static void main(String[] args) {
        Extras[][] pizza = new Extras[0][0];
        int l = 2;
        int h = 4;

        Extras[][] currentSlice = new Extras[0][0];
        Extras[][][] potentialSlices = new Extras[0][0][0];


        //rows
        for (int i = 0; i < pizza.length; i++) {
            //columns
            for (int j = pizza[i].length; j > 0; j--) {
                currentSlice = new Extras[i][j];

                NumberOfExtras numberOfExtras = getNumberOfExras(pizza);
                int numberOfTomatoes = numberOfExtras.numberOfTomatoes;
                int numberOfMushrooms = numberOfExtras.numberOfMushrooms;

                if (numberOfTomatoes < l || numberOfMushrooms < l || numberOfTomatoes > h || numberOfMushrooms > h) {
                    //stop
                    continue;
                }
            }
            //need to hop l times
        }
    }

    private static int getNumberOfTomatoes(Extras[][] slice) {
        int v = 0;

        //rows
        for (int i = 0; i < slice.length; i++) {
            //columns
            for (int j = 0; j < slice[i].length; j++) {
                if (slice[i][j] == Extras.Tomato) {
                    v++;
                }
            }
        }
        return v;
    }

    private static NumberOfExtras getNumberOfExras(Extras[][] slice) {
        int t = 0;
        int m = 0;

        //rows
        for (int i = 0; i < slice.length; i++) {
            //columns
            for (int j = 0; j < slice[i].length; j++) {
                if (slice[i][j] == Extras.Mushroom) {
                    m++;
                }
                else {
                    t++;
                }
            }
        }
        return new NumberOfExtras(m,t);
    }

    private enum Extras {
        Mushroom("M"),
        Tomato("T");

        Extras(String m) {

        }
    }

    private static class NumberOfExtras {
        int numberOfTomatoes;
        int numberOfMushrooms;

        NumberOfExtras(int m, int t) {
            numberOfMushrooms = m;
            numberOfTomatoes = t;
        }
    }
}
