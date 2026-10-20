public class PyramidofAny {
    public static void main(String[] args) {
        System.out.println("make a pyramid of x idk");
        System.out.println("maybe do 5");

        int x = 5;
        String block = "X ";
        String space = "  ";
        String[][] result = new String[x][x];

        if(x % 2 != 0) {
            System.out.println("nvm i can't do even lmao for now");
            return;
        }

        for(int i = 1; i <= x; i++) {

        }

        for(String[] row : result) {
            for(String element : row)
                System.out.print(element + "\t");
        }
        System.out.println();
    }
}