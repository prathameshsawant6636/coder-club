import java.util.ArrayList;

class ParentsProp {
    double land = 8;
    int plots = 2;
    long bankBalance = 99999L;

    void propSummary() {
        System.out.println("Total land: " + land + " Acres. Total Plots: " + plots + " Bank Balance: " + bankBalance);
    }
}

public class Me extends ParentsProp {
    public static void main(String[] args) {
        Me prathamesh = new Me();
        prathamesh.propSummary();

        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(10);

        System.out.println(arrlist.get(0));
    }
}