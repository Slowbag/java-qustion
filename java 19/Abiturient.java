package asd;

public class Abiturient {  
    public  String Name;
    public String Surname;
    public String Otch;
    public int Age;
    public  String City;
    public  int Ball_matem;
    public  int Ball_fizika;
    public  int Ball_russia;
    public int AVGG=Ball_matem+Ball_fizika+Ball_russia;
 
    Abiturient(String name,String surname,String otch,int age, String city,int ball_matem,int ball_fizika,int ball_russia)
    {
        Name = name;
        Surname = surname;
        Otch = otch;
        Age = age;
        City = city;
        Ball_matem=ball_matem;
        Ball_fizika=ball_fizika;
        Ball_russia=ball_russia;
        AVGG=(ball_matem+ball_fizika+ball_russia)/3;

    }
    
    public void show(){
        
        System.out.println("Абитуриент: " + Surname +" "+ Name +" " + Otch + " || Возраст: "+ Age + " || Город: " + City + AVGG );
                
    }
    
 
}