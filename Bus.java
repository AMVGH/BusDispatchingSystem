import java.util.ArrayList;
public class Bus {
    ArrayList <Person> passengers;
    private static int nextId;
    private int busId;
    Bus(){
        passengers = new ArrayList<>();
        busId = nextId;
        nextId++;
    }
    public int getId(){
        return busId;
    }
    public void addPerson (Person person){
        passengers.add(person);
    }
    public boolean removePerson (Person person){
        Boolean removeSuccessful = false;

        if (passengers.remove(person) == true){
            removeSuccessful = true;
        }

        return removeSuccessful;
    }

    public Person findPerson(String name){
        for (int i = 0; i < passengers.size(); i++){
            if (passengers.get(i).getName().equals(name)){
                Person personFound = passengers.get(i);
                return personFound;
            }
        }
        return null;
    }

    public static boolean transferPerson (Bus bus1, Bus bus2, Person person){
        //Find person in bus 1, removes and transfers them to bus 2
        Boolean transferSuccess = true;
        for (int i = 0; i < bus1.passengers.size(); i++){
            if (bus1.passengers.get(i) == person){
                bus1.passengers.remove(person);
                bus2.passengers.add(person);
                return transferSuccess;
            }
        }
        return false;
    }

    public String getPassengers(){
        String passengerString = "";
        for (int i =0; i < passengers.size(); i++){
            String temp = passengers.get(i).toString();
            passengerString += "\n" + temp;
        }
        return passengerString;
    }

    @Override
    public String toString(){
        String stringBusId = String.valueOf(busId);
        return stringBusId;
    }
}

