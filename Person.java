public class Person {
    private String name;
    private int ticketNumber;
    private static int nextTicketNumber;
    Person(){
        name = "NO NAME";
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }
    Person(String namePass){
        name = namePass;
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }
    @Override
    public String toString(){
        String stringInformation = ticketNumber + "\t"+name;
        return stringInformation;
    }

    public String getName(){
        return name;
    }
}