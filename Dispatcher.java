import java.util.ArrayList;

public class Dispatcher {
    ArrayList <Bus> busQueue = new ArrayList<>();

    public int addBus (Bus bus){
        busQueue.add(bus);
        int busPosition = busQueue.indexOf(bus);
        return busPosition;
    }

    //Fix
    public int addBus(Bus bus, int position){
        int positionReturn;
        busQueue.remove(bus);
        if (position > busQueue.size()){
            busQueue.add(bus);
            positionReturn = busQueue.indexOf(bus);
            return positionReturn;
        } else {
            busQueue.set(position, bus);
        }
        return position;
    }
    public Bus findBus(int id){
        for (int i = 0; i < busQueue.size(); i++){
            if (busQueue.get(i).getId() == id){
                return busQueue.get(i);
            }
        }
        return null;
    }

    public Bus removeBus(int id){
        for(int i = 0; i<busQueue.size(); i++){
            if (busQueue.get(i).getId() == id){
                Bus busRemoval = busQueue.get(i);
                busQueue.remove(i);
                return busRemoval;
            }
        }
        return null;
    }

    public Bus dispatchBus(){
        if (busQueue.isEmpty()){
            return null;
        }else{
            Bus dispatchBus = busQueue.get(0);
            busQueue.remove(0);
            return dispatchBus;
        }
    }

    @Override
    public String toString(){
        String busIdList = "";
        for (int i = 0; i < busQueue.size(); i++){
            String temp = busQueue.get(i).toString();
            busIdList += "\n" + temp;
        }
        return busIdList;
    }
}
