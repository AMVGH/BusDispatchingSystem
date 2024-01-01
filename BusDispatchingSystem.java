import java.util.Scanner;
public class BusDispatchingSystem {
    public static void main(String[] args){
        Dispatcher dispatcher = new Dispatcher();
        Scanner sc = new Scanner(System.in);
        int menuChoice;

        do{
            System.out.println("Bus Dispatching System" +
                    "\n" +
                    "\n1. Add Bus" +
                    "\n2. Add Person to Bus" +
                    "\n3. Remove Bus" +
                    "\n4. Remove Person" +
                    "\n5. List Passengers" +
                    "\n6. List Busses" +
                    "\n7. Requeue Bus" +
                    "\n8. Transfer Person" +
                    "\n9. Dispatch Bus" +
                    "\n0. Exit ");
            menuChoice = sc.nextInt();
            sc.nextLine();

            switch (menuChoice){
                case 1:
                    //(Checked) Creates new Bus object and uses the addBus method to add it to the busQueue arrayList
                    Bus addBus = new Bus();
                    dispatcher.addBus(addBus);
                    System.out.println("Bus " + dispatcher.findBus(addBus.getId())
                            +" added to position " + dispatcher.busQueue.indexOf(addBus));
                    break;
                case 2:
                    //(Checked)Prompts user for a busId as well as a name
                    System.out.print("Enter bus id: ");
                    int caseTwoRead = sc.nextInt();
                    sc.nextLine();

                    //Passes the user prompted busId to .findBus
                    if (dispatcher.findBus(caseTwoRead) == (null)) {
                        //If null, prints no bus + the id the user passed
                        System.out.println("No Bus with ID " + caseTwoRead);
                        break;
                    }

                    System.out.print("Enter person's name: ");
                    String caseTwoNameRead = sc.nextLine();

                        /*If it runs else, it found a bus object with the matching id.
                        * New Person object is created using the overloaded constructor, passes the name
                        * from the user to the constructor and creates a new Person object with the name*/
                        Person addPerson = new Person(caseTwoNameRead);
                        /*Accesses the arrayList of busses in the dispatcher class, goes to the index
                        * that the user passed, uses the addPerson method in the bus class in order to
                        * add the Person Object created on the last line, to the arrayList of passengers
                        * found in that bus instance */
                        dispatcher.findBus(caseTwoRead).addPerson(addPerson);
                        System.out.println(caseTwoNameRead +" has been added to bus "
                                +dispatcher.findBus(caseTwoRead).getId());
                    break;
                case 3:
                    //(Checked) Prompts user for a busID and stores the value
                    System.out.print("Enter bus id: ");
                    int caseThreeRead = sc.nextInt();
                    sc.nextLine();

                    //If statement, passes the id that the user passed to dispatch findBus method
                    if (dispatcher.findBus(caseThreeRead) == (null)){
                        System.out.println("No Bus with ID " + caseThreeRead);
                    }else{
                        //If findBus does not return null, the bus at the user index is removed
                        dispatcher.removeBus(caseThreeRead);
                        System.out.println("Bus " + caseThreeRead + " removed");
                    }
                    break;
                case 4:
                    //(Checked)Prompts user for a bus id and stores the value
                    System.out.print("Enter bus id: ");
                    int caseFourRead = sc.nextInt();
                    sc.nextLine();

                    //Checks the value passed using dispatcher's findBus method
                    if (dispatcher.findBus(caseFourRead) == (null)) {
                        System.out.println("No Bus with ID " + caseFourRead);
                        break;
                    }

                    //If passes findBus, prompts for the persons name
                    System.out.print("Enter person's name: ");
                    String caseFourNameRead = sc.nextLine();
                    //Checks busQueue arrayList at index (caseFourRead), calls .findPerson with the string passed
                    if(dispatcher.findBus(caseFourRead).findPerson(caseFourNameRead) == (null)){
                        System.out.println("No such person found on bus " + dispatcher.busQueue.get(caseFourRead).getId());
                    }else{
                        //Creates a person object, uses the findPerson method to retrieve the person with the name passed
                        Person removePerson = dispatcher.findBus(caseFourRead).findPerson(caseFourNameRead);
                        //accessed busQueue arrayList --> index(caseFourRead) --> removePerson(Previous Person Object)
                        dispatcher.findBus(caseFourRead).removePerson(removePerson);
                        //Prints the name the user passed, also accesses the busQueue arrayList at the caseFour index and calls getId
                        System.out.println(caseFourNameRead + " has been removed from bus " +
                                dispatcher.findBus(caseFourRead).getId());
                    }
                    break;
                case 5:
                    //(Checked)Prompts user for a bus id
                    System.out.print("Enter bus id: ");
                    int caseFiveRead = sc.nextInt();
                    sc.nextLine();

                    //Calls dispatcher's findBus method and passes caseFiveRead to verify if the bus with the id exists
                    if (dispatcher.findBus(caseFiveRead) == (null)) {
                        System.out.println("No Bus with ID " + caseFiveRead);
                        break;
                    }

                    //Gets id of the bus, calls getPassengers Method of the index of the bus arrayList
                    System.out.println("Bus " + dispatcher.findBus(caseFiveRead).getId()
                            + dispatcher.findBus(caseFiveRead).getPassengers());
                    break;
                case 6:
                    //(Checked) Dynamic and works, calls dispatcher's toString method and prints it in the line below
                    String dispatchBusList = dispatcher.toString();
                    System.out.println("BUS QUEUE" + dispatchBusList);
                    break;
                case 7:
                    //(Checked)
                    //Prompts user for bus id
                    System.out.print("Enter bus id: ");
                    int caseSevenRead = sc.nextInt();
                    Bus caseSevenBusAdd;
                    sc.nextLine();

                    //Verifies that the id that the user passed exists within the busQueue array
                    if (dispatcher.findBus(caseSevenRead) == (null)) {
                        System.out.println("No Bus with ID " + caseSevenRead);
                        break;
                    }
                    //Prompts the user for a new bus position if the bus with the id exists
                    System.out.print("Enter new bus position: ");
                    int caseSevenReadPosition = sc.nextInt();

                    //New Bus object to pass to the addBus method of the dispatch glass, gets the object stored at the index passed by the user
                    caseSevenBusAdd = dispatcher.findBus(caseSevenRead);
                    int busPos = dispatcher.addBus(caseSevenBusAdd, caseSevenReadPosition);

                    System.out.println("Bus " + dispatcher.findBus(caseSevenRead).getId() +
                            " added to position " + busPos);
                    break;
                case 8:
                    //(Checked) Prompts user for the individual's name, bus 1 id, bus 2 id
                    System.out.print("Enter person's name: ");
                    String caseEightNamePass = sc.nextLine();
                    System.out.print("Enter id of bus 1: ");
                    int caseEightBus1 = sc.nextInt();
                    System.out.print("Enter id of bus 2: ");
                    int caseEightBus2 = sc.nextInt();

                    //Verifies that both busses exist
                    if (dispatcher.findBus(caseEightBus1) == (null)) {
                        System.out.println("No Bus with ID " + caseEightBus1);
                        break;
                    } else if (dispatcher.findBus(caseEightBus2) == (null)){
                        System.out.println("No Bus with ID " + caseEightBus2);
                        break;
                    }

                    //Verifies that the name passed by the user exists in a person object in bus 1
                    if(dispatcher.findBus(caseEightBus1).findPerson(caseEightNamePass) == (null)){
                        System.out.println("No person with the name " + caseEightNamePass +" found");
                    }
                    //All we had from the user was a name, so we create a person object and store the object found in bus 1, found with the findPerson method
                    Person personPass = dispatcher.findBus(caseEightBus1).findPerson(caseEightNamePass);
                    //Accesses the busQueue arrayList, sets new Bus objects to the bus objects found at the two indexes illustrated by the variables
                    Bus BusPass1 = dispatcher.findBus(caseEightBus1);
                    Bus BusPass2 = dispatcher.findBus(caseEightBus2);
                    //Then uses personPass, busPass1, busPass 2 --> Passes to the transfer Person method in the bus class
                    Boolean transferPerson = dispatcher.findBus(caseEightBus1).transferPerson(BusPass1, BusPass2, personPass);

                    //transferPerson returns a boolean, we use these values to print either success or failure
                    if (transferPerson.equals(true)){
                        System.out.println("Transfer successful");
                        break;
                    }else{
                        System.out.println("Transfer failed");
                    }
                    break;
                case 9:
                    //(Checked) Creates new Bus object and calls the dispatch bus method
                    Bus dispatchBus = dispatcher.dispatchBus();
                    //if dispatchBus returns null, says the queue is empty
                    if (dispatchBus == null){
                        System.out.println("Bus queue is empty");
                        break;
                    }else{
                        //If it detects there is an object in dispatchBus, gets ID and removes it in the dispatch bus method
                        System.out.println("Bus " +dispatchBus.getId() + " has been dispatched");
                    }
                    break;
            }
        }while(menuChoice != 0);
    }
}