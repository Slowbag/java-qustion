package asd;
 
public class Faculty {
    
    
    private String Namefacult;
    private String Budgetplace;
    private  String NameAbiturient;
    private  String SurNameAbiturient;
    private int ball_matemAbiturient;
    private int ball_fizikaAbiturient;
    private int ball_russiaAbiturient;
    private int AVGAbiturient;

    Faculty(String namefacult){
        
        Namefacult = namefacult;
    
    }
    
public void showFacult(String nameabiturient,String surnameabiturient,int avgg ) {
        
    NameAbiturient = nameabiturient;
    SurNameAbiturient= surnameabiturient;
    AVGAbiturient=avgg;
        System.out.println("Абитуриент " + NameAbiturient+" " +SurNameAbiturient + " зарегистрировался на факультет: " + Namefacult+ "со средним баллом "+ AVGAbiturient);
        
        
    }
    
 
    
}