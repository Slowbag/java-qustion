import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MyList<T> extends ArrayList<T> {
    @Override
    public T get(int n){
        return super.get(n-1);
    }
}
class Auto {
    boolean carState;
    public Auto (){
        carState=true;
    }
    public Auto(boolean carstate) {
        this.carState = carstate;
    }
    public boolean getAutoState() {
        return carState;
    }
    public void setAutoState(boolean value){
        carState=value;
    }
    public void ShowA(){
        System.out.println("\t"+carState);
    }
}

class Flight{
    Auto flightAuto;
    boolean flightState;
    
    public Flight(){
        flightState = true;
        flightAuto = new Auto();
    }

    public Auto getFlightAuto() {
        return flightAuto;
    }
    
    public boolean getFlightState() {
        return flightState;
    }
    
    public void setFlightAuto(Auto flightAuto) {
        this.flightAuto = flightAuto;
    }
    
    public void setFlightState(boolean flightState) {
        this.flightState = flightState;
    }
    public void ShowF(){
        System.out.println("\t"+flightState);
    }
}   

class Driver {
    int flightNumber;
    String name;
    public Driver(){
        flightNumber = -1;
        name=null;
    }
    public void setFlightNumber(int _flightNumber){
        flightNumber = _flightNumber;
    }
    public void setName(String _name){
        name = _name;
    }
    public int getFlightNumber (){
        return flightNumber;
    }
    public String getName (){
        return name;
    }
    public void setFlightState(List<Flight> _flight, boolean state){
        _flight.get(flightNumber).setFlightState(state); 
    }
    public void setAutoState(List<Flight> _flight, boolean state){
        _flight.get(flightNumber).getFlightAuto().setAutoState(state);
    }
    public void Show(){
        System.out.print(name);
        System.out.println("\t"+flightNumber);
    }
}

class Dispatcher { 
    List<Flight> flightList;
    List<Driver> driverList;
    public Dispatcher(){
            flightList = new MyList<Flight>();
            driverList = new MyList<Driver>();
        }
    public List<Flight> getFlightList(){
        return flightList;
    }
    public List<Driver> getDriverList(){
        return driverList;
    }
    public void addDriver(Driver _driver){
            driverList.add(_driver);
        }
        public void delDriver(int n){
            driverList.remove(n);
        }
        public void addFlight(Flight _flight){
            flightList.add(_flight);
        }
        public void delFlight(int n){
            flightList.remove(n);
        }
        public void setDriverForFlight(int _driverNumber, int _flightNumber){
        try{
            if ((_driverNumber < 1) /*|| (_flightNumber < 1)*/){
                System.out.println("Number of the driver or of the flight is wrong");
                return;
            }
            driverList.get(_driverNumber).setFlightNumber(_flightNumber);
        } catch(Exception e){
            System.out.println("Неправильно введен номер!");
            System.exit(0);
        }
        }
        public void DelDriverForFlight (int _driverNumber){
            driverList.get(_driverNumber).setFlightNumber(-1);
        }
} 

public class JavaApplication7 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Dispatcher A = new Dispatcher();
            /*A.addDriver(new Driver());
            A.addDriver(new Driver());
            A.addFlight(new Flight());
            A.setDriverForFlight(1, 1);
            A.getDriverList().get(0).setFlightState(A.getFlightList(), false);
            System.out.println(A.getFlightList().get(0).getFlightState());
            A.getFlightList().get(1).getFlightAuto().setAutoState(false);
            A.delDriver(0);*/
     do{
        System.out.println("Choose a number from 0 to 5: ");
        System.out.println("\t0. Вывести список");
        System.out.println("\t1. Установить водителя, назначить ему рейс, установить состояние рейса и автомобиля");
        System.out.println("\t2. Добавить водителя и новый рейс");
        System.out.println("\t3. Изменить состояние автомобиля и отметку о выполнении рейса для водителя");
        System.out.println("\t4. Отстранить водителя от работы"); 
        System.out.println("\t5. Изменить рейс у водителя");
        int c = Integer.parseInt(reader.readLine());
        switch (c) {
            case 0: for (int i=0; i<A.getDriverList().size(); i++)
                    {
                         System.out.println(i+":");
                         A.getDriverList().get(i).Show();
                         A.getFlightList().get(i).ShowF();
                         A.getFlightList().get(i).getFlightAuto().ShowA();
                    }
                    break;
            case 1: System.out.println("Введите фамилию водителя:");
                    String s1 = reader.readLine();
                    System.out.println("Введите номер рейса");
                    int num1 = Integer.parseInt(reader.readLine());
                    Driver Dr = new Driver ();
                    Dr.setFlightNumber(num1);
                    Dr.setName(s1);
                    A.addDriver(Dr);
                    System.out.println("Введите отметку о состоянии автомобиля (1-хорошее, 0-плохое):");
                    boolean mark = Boolean.parseBoolean(reader.readLine());
                    A.getDriverList().get(0).setFlightState(A.getFlightList(), mark);
                    System.out.println("Введите отметку о выполнении рейса (1-выполнен, 0-не выполнен):");
                    boolean mark2 = Boolean.parseBoolean(reader.readLine());
                    A.getFlightList().get(0).getFlightAuto().setAutoState(mark2);
                    break;
            case 2: System.out.println("Введите фамилию водителя");
                    String s2 = reader.readLine();
                    System.out.println("Введите номер рейса");
                    int num2= Integer.parseInt(reader.readLine());
                    Driver New_D = new Driver ();
                    New_D.setFlightNumber(num2);
                    New_D.setName(s2);
                    A.addDriver(New_D);
                    break;
            case 3: System.out.println("Введите индекс водителя, с которым хотите работать:");
                    int id = Integer.parseInt(reader.readLine());
                    System.out.println("Введите отметку о состоянии автомобиля (1-хорошее, 0-плохое):");
                    boolean mark1 = Boolean.parseBoolean(reader.readLine());
                    A.getDriverList().get(id).setFlightState(A.getFlightList(), mark1);
                    System.out.println("Введите отметку о выполнении рейса (1-выполнен, 0-не выполнен):");
                    boolean mark22 = Boolean.parseBoolean(reader.readLine());
                    A.getFlightList().get(id).getFlightAuto().setAutoState(mark22);
                    break;
            case 4: System.out.println("Введите индекс водителя, которого хотите отстранить от работы:");
                    int id_v = Integer.parseInt(reader.readLine());
                    A.delDriver(id_v);
            case 5: System.out.println("Введите индекс водителя, у которого хотите сменить рейс:");
                    int id_ = Integer.parseInt(reader.readLine());
                    System.out.println("Введите номер рейса");
                    int numb= Integer.parseInt(reader.readLine());
                    A.setDriverForFlight(id_, numb);
                    break;
            default: System.out.println("You can choose only 0-5! GoodBye..."); 
                     System.exit(0); 
                     break;
        }
        } while(true);
    }
}