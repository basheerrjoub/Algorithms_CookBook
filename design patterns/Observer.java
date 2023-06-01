import java.util.ArrayList;

interface Observer {
    void update(double temp);
}

interface Subject {

    void attach(Observer o);
    void deatch(Observer o);

    void notifyObserver();
}

class Station implements Subject {
    private ArrayList<Observer> observers;
    private double tempreature;

    public Station(){
        observers = new ArrayList<Observer>();
    }
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void deatch(Observer o) {
        int index = observers.indexOf(o);
        observers.remove(o);

    }

    @Override
    public void notifyObserver() {
        for(Observer o: observers){
            o.update(this.tempreature);
        }
    }

    public void setTempreature(int tempreature) {
        this.tempreature = tempreature;
        notifyObserver();
    }
}

class WebSiteObserver implements Observer{
    private String name;
    public WebSiteObserver(String name){
        this.name = name;
    }
    @Override
    public void update(double temp) {
        System.out.println(this.name+" Updating Tempreature: " + temp);
    }
}

public class Main{
    public static void main(String[] args){
        //Creating a station for controlling the tempreature
        Station palStation;
        palStation = new Station();

        //Creating Observers
        WebSiteObserver mix = new WebSiteObserver("Mix TV Channel");
        WebSiteObserver palestine = new WebSiteObserver("Palestine TV Chennel");

        //Attaching the chennels to observe the change in the tempreature
        palStation.attach(mix);
        palStation.attach(palestine);

        //Set initial Tempreature
        palStation.setTempreature(20);

        //Change the tempreature
        palStation.setTempreature(30);

        //Deattaching mix channel
        palStation.deatch(mix);

        //Change the tempreature
        palStation.setTempreature(40);



    }
}