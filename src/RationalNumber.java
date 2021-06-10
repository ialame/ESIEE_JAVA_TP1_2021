public class RationalNumber{
    private int numerat;
    private int denominator;

    public RationalNumber(int numerat, int denominator) {
        if(denominator == 0) throw new IllegalArgumentException("Error: denominator is negative.");
        this.numerat = numerat;
        this.denominator = denominator;
        //new RationalNumber(this.numerat,this.denominator);
    }
    public RationalNumber(){
        new RationalNumber(0,1);
    }
    public int getDenominator(){
        return this.denominator;
    }
    public int getNumerator(){
        return this.numerat;
    }
    public String toString(){
        reduce();
        if(getNumerator() == 1)
            return getNumerator() + "";
        else
            return getNumerator() + "/" + getDenominator();
    }
    public RationalNumber add(RationalNumber r2){
        int d = r2.getDenominator() * denominator;
        int n = (r2.getDenominator() * numerat) + (r2.getNumerator()* denominator);
        return new RationalNumber(n,d);
    }
    public RationalNumber subtract(RationalNumber r2){
        int n = (r2.getDenominator() * this.numerat) - (r2.getNumerator()*this.denominator);
        int d = r2.getDenominator() * this.denominator;
        return new RationalNumber(n,d);

    }
    public RationalNumber multiply(RationalNumber r2){
        int n = this.numerat * r2.getNumerator();
        int d = this.denominator * r2.getDenominator();
        return new RationalNumber(n, d);
    }
    public RationalNumber divide(RationalNumber r2){
        int n = this.numerat * r2.getDenominator();
        int d = this.denominator * r2.getNumerator();
        return new RationalNumber(n, d);
    }
    public void reduce(){
        if (denominator < 0) {
            denominator = -denominator;
            numerat = -numerat;
        }
        int d = gcd(numerat,denominator);
        numerat /=  d;
        denominator /=  d;
    }
    public int gcd(int x, int y){
        if(x<0)return gcd(-x,y);
        if(y<0)return gcd(x,-y);
        if (y == 0)
            return x;
        else
            return gcd(y,x%y);
    }
}
