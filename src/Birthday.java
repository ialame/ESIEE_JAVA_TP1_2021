import java.util.Scanner;
public class Birthday {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Quel jour, mois et année êtes-vous né?");
        int d = input.nextInt();
        int m = input.nextInt();
        int y = input.nextInt();
        TeacherDate B = new TeacherDate(y, m, d);   // Birthday Date
        TeacherDate T = new TeacherDate();  // Today's Date
        System.out.printf("Vous êtes né le %s, qui était un %s.\n",B.toString(),B.getDayOfWeek());
        if(B.isLeapYear() == true){
            System.out.printf("%d était une année bissextile\n",y);
        }
        int NoOfDays = 0;
        int total = 0;
        if(T.getMonth() <= B.getMonth()){
            for(int i = T.getMonth(); i < B.getMonth(); i++){
                if(i == 4 || i == 6 || i == 9|| i == 11){
                    NoOfDays += 30;
                }
                else if(i == 2){
                    if(B.isLeapYear() == true)
                        NoOfDays += 29;
                    else
                        NoOfDays += 28;
                }
                else{
                    NoOfDays += 31;
                }
            }
        }
        else{
            for(int i = T.getMonth(); i <= 12; i++){
                if(i == 4 || i == 6 || i == 9|| i == 11){
                    NoOfDays += 30;
                }
                else if(i == 2){
                    if(B.isLeapYear() == true)
                        NoOfDays += 29;
                    else
                        NoOfDays += 28;
                }
                else{
                    NoOfDays += 31;
                }
            }
            for(int i = 1; i < B.getMonth(); i++){
                if(i == 4 || i == 6 || i == 9|| i == 11){
                    NoOfDays += 30;
                }
                else if(i == 2){
                    if(B.isLeapYear() == true)
                        NoOfDays += 29;
                    else
                        NoOfDays += 28;
                }
                else{
                    NoOfDays += 31;
                }
            }

        }
        total = B.getDay() + NoOfDays - T.getDay() + 1;
        if(total == 0)
            System.out.printf("Bon anniversaire! Vous avez maintenant l'âge de %d.\n",(T.getYear() - B.getYear()));
        else{
            System.out.printf("Votre anniversaire est dans %d jours.\n",total);
        }
        int Days = 0;
        for(int i = B.getYear() + 1; i < T.getYear(); i++){
            if((i%4 == 0 && i%100 !=0) || i%400 ==0 )
                Days += 366;
            else
                Days += 365;
        }
        TeacherDate N = new TeacherDate(B.getYear(),12,31);
        TeacherDate M = new TeacherDate(T.getYear(),1,1);
        for(int i = B.getMonth() ; i <= N.getMonth(); i++){
            if(i == 4 || i == 6 || i == 9|| i == 11){
                Days += 30;
            }
            else if(i == 2){
                if(B.isLeapYear() == true)
                    Days += 29;
                else
                    Days += 28;
            }
            else{
                Days += 31;
            }
        }
        for(int i = M.getMonth(); i < T.getMonth() ; i++){
            if(i == 4 || i == 6 || i == 9|| i == 11){
                Days += 30;
            }
            else if(i == 2){
                if(B.isLeapYear() == true)
                    Days += 29;
                else
                    Days += 28;
            }
            else{
                Days += 31;
            }
        }
        System.out.printf("Vous avez %d jours.", Days + T.getDay() - B.getDay()+ 1);
        input.close();
    }

}