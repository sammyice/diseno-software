package Servicios;

public interface Handler { 
    void setNext(Handler next);
    void handle(int money);
}
