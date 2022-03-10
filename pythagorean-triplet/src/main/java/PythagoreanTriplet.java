import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet{   
    int a, b, c;

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PythagoreanTriplet that = (PythagoreanTriplet) obj;
        return a == that.a &&
                b == that.b &&
                c == that.c;
    }

    public static PythagoreanTripletBuilder makeTripletsList(){
        return new PythagoreanTripletBuilder();
    }

    public static class PythagoreanTripletBuilder{
        int sum;
        int maxFactor;
        PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int maxFactor){
            this.maxFactor = maxFactor;
            return this;
        }

        PythagoreanTripletBuilder thatSumTo(int sum){
            this.sum = sum;
            return this;
        }

        List<PythagoreanTriplet> build(){
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            for(int a = 1; a <= maxFactor; a++){
                for(int b = a; b <= maxFactor; b++){
                    int c = sum - a - b;
                    if(c > 0 && c <= maxFactor && a*a + b*b == c*c){
                        triplets.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            return triplets;
        }
    }
}