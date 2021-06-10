public class RationalTest{
    public static void main(String[] str){
        RationalNumber r1 = new RationalNumber(1,2);
        RationalNumber r2 = new RationalNumber(3,4);
        RationalNumber r = r1.add(r2);
        System.out.println(r);
        System.out.println(r1.multiply(r2));
        System.out.println(r1.divide(r2));
    }
}
