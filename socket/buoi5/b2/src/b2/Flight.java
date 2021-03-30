/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tphuc
 */
public class Flight extends UnicastRemoteObject implements Flightitf{

    private final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private LocalDateTime date;
    private String fromLocal;
    private String toLocal;
    private float time;
    private int totalEmptySeat;
    private int numberNotEmptySeat;
    private int numberEmptySeat;

    public Flight() throws RemoteException {
        super();
        this.id = count.incrementAndGet();
    }

    public Flight(int id, LocalDateTime date, String fromLocal, String toLocal, float time, int totalEmptySeat, int numberNotEmptySeat, int numberEmptySeat) {
        this.id = count.incrementAndGet();
        this.date = date;
        this.fromLocal = fromLocal;
        this.toLocal = toLocal;
        this.time = time;
        this.totalEmptySeat = totalEmptySeat;
        this.numberNotEmptySeat = numberNotEmptySeat;
        this.numberEmptySeat = numberEmptySeat;
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

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
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
    
    public String voidShow() {
        String resutlInfoFlight = "ID: "+ this.id +"\n Date: "+this.date.toString()+"\n From: "+this.fromLocal+" --> "+this.toLocal+"\n Time: "+this.time+"\n Total Seet: "+this.totalEmptySeat+"\n Emty Seet: "+this.numberEmptySeat;
        System.err.println(resutlInfoFlight);
        return resutlInfoFlight;
    }
    
}
