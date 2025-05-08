import java.util.ArrayList;

public class DotCom {
    private String name;
    private ArrayList<String> locationCells;

    public void setName(String n) {
        name = n;
    }

    public void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    public String checkYourself(String userGuess) {
        // result = miss
        String result = "miss";

        // check if cell exists (get index and check)
        int index = locationCells.indexOf(userGuess);

        // remove if existing
        // result = hit
        if(index >= 0) {
            locationCells.remove(index);
            result = "hit";
        }

        // if locationCells is empty, result = kill
        if(locationCells.isEmpty()) {
            System.out.println("Ouch! You sunk " + name + "!");
            result = "kill";
        }

        return result;
    }
}
