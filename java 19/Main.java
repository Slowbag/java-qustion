package asd;
 
public class Main {
 
    public static void main(String[] args) {
        Abiturient a1 = new Abiturient("Александр","Невский","Олегович",18,"Чебоксары",50,42,57);
        Faculty b1 = new Faculty("Автоматика и вычислительная техника");
        b1.showFacult(a1.Name,a1.Surname,a1.AVGG);
        
    }
 
}