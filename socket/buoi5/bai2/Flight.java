import java.util.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;


public class Flight extends UnicastRemoteObject implements Flightitf{
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private LocalDateTime date;
    private String fromLocal;
    private String toLocal;
    private double time;
    private int totalEmptySeat;
    private int numberNotEmptySeat;
    private int numberEmptySeat;
    private int total;
    public Flight() throws RemoteException  {
        super();
        this.id = count.incrementAndGet();
    }

    public Flight(LocalDateTime date, String fromLocal, String toLocal, double time, int totalEmptySeat,int total) throws RemoteException  {
        super();
        this.id = count.incrementAndGet();
        this.date = date;
        this.fromLocal = fromLocal;
        this.toLocal = toLocal;
        this.time = time;
        this.totalEmptySeat = totalEmptySeat;
        this.numberNotEmptySeat = 0;
        this.numberEmptySeat = totalEmptySeat;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFromLocal() {
        return fromLocal;
    }

    public void setFromLocal(String fromLocal) {
        this.fromLocal = fromLocal;
    }

    public String getToLocal() {
        return toLocal;
    }

    public void setToLocal(String toLocal) {
        this.toLocal = toLocal;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getTotalEmptySeat() {
        return totalEmptySeat;
    }

    public void setTotalEmptySeat(int totalEmptySeat) {
        this.totalEmptySeat = totalEmptySeat;
    }

    public int getNumberNotEmptySeat() {
        return numberNotEmptySeat;
    }

    public void setNumberNotEmptySeat(int numberNotEmptySeat) {
        this.numberNotEmptySeat = numberNotEmptySeat;
    }

    public int getNumberEmptySeat() {
        return numberEmptySeat;
    }

    public void setNumberEmptySeat(int numberEmptySeat) {
        this.numberEmptySeat = numberEmptySeat;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public void buyTicker() {
        this.numberEmptySeat-=1;
        this.numberNotEmptySeat+=1;
    }
    public void returnTicker() {
        this.numberEmptySeat+=1;
        this.numberNotEmptySeat-=1;
    }
    public String voidShow() {
        String resultInfoFlight = "ID: "+ this.id +"\n Date: "+this.date.toString()+"\n From: "+this.fromLocal+" --> "+this.toLocal+"\n Time: "+this.time+"\n Total Seet: "+this.totalEmptySeat+"\n Emty Seet: "+this.numberEmptySeat;
        // String resultInfoFlight = "ID: "+ this.id ;
        // System.err.println(resultInfoFlight);
        return resultInfoFlight;
    }

}