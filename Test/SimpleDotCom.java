import java.util.ArrayList;

class SimpleDotCom {
    private ArrayList<String> locationCells;
    private int numOfHits = 0;

    public void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    public String checkYourself(String guess) {
        String result = "miss";
        
        int index = locationCells.indexOf(guess);
        if(index >= 0) {
            locationCells.remove(index);
            result = "hit";
        }

        if(locationCells.isEmpty()) {
            result = "kill";
        }

        System.out.println(result);

        return result;
    }
}
