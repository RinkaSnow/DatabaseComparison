import java.util.Random;

class timeStatic {
    long minval,maxval,sum,cnt;
    String name;
    timeStatic(String name){
        minval=maxval=sum=cnt=0;
        this.name=name;
    }
    void add(long x){
        if(cnt==0){
            minval=maxval=x;
        }
        else{
            minval=Math.min(minval,x);
            maxval=Math.max(maxval,x);
        }
        sum+=x;
        cnt++;
    }
    void output(){
        System.out.printf("%s time: Average=%dms , Min=%dms , Max=%dms\n",name,(long)(1.0*sum/cnt),minval,maxval);
    }
}

public class Tester {

    static void testAirportSelection() {
        javaImplement.initData();
        timeStatic s1=new timeStatic("sql"),s2=new timeStatic("java");

        String[] airports=tools.getAirports();
        Random rand=new Random();
        for(int i=0;i<20;i++) {
            String airport=airports[rand.nextInt(airports.length)];
            long tim1=System.currentTimeMillis();
            sqlImplement.selectAirport(airport);
            long tim2=System.currentTimeMillis();
            javaImplement.selectAirport(airport);
            long tim3=System.currentTimeMillis();
            s1.add(tim2-tim1);
            s2.add(tim3-tim2);
        }
        s1.output();
        s2.output();
    }

    static void testAirportSelection2() {
        timeStatic s1=new timeStatic("sql2");

        String[] airports=tools.getAirports();
        Random rand=new Random();
        for(int i=0;i<20;i++) {
            String airport=airports[rand.nextInt(airports.length)];
            long tim1=System.currentTimeMillis();
            sqlImplement.selectAirport2(airport);
            long tim2=System.currentTimeMillis();
            s1.add(tim2-tim1);
        }
        s1.output();
    }

    static void testPassengersSelection() {
        javaImplement.initData();
        timeStatic s1=new timeStatic("sql"),s2=new timeStatic("java");

        Random rand=new Random();
        for(int i=0;i<20;i++) {
            int passengers=rand.nextInt(10000);
            long tim1=System.currentTimeMillis();
            sqlImplement.selectPassengers(passengers);
            long tim2=System.currentTimeMillis();
            javaImplement.selectPassengers(passengers);
            long tim3=System.currentTimeMillis();
            s1.add(tim2-tim1);
            s2.add(tim3-tim2);
        }
        s1.output();
        s2.output();
    }

    static void testPassengersSelection2() {
        timeStatic s1=new timeStatic("sql2");

        Random rand=new Random();
        for(int i=0;i<20;i++) {
            int passengers=rand.nextInt(10000);
            long tim1=System.currentTimeMillis();
            sqlImplement.selectPassengers2(passengers);
            long tim2=System.currentTimeMillis();
            s1.add(tim2-tim1);
        }
        s1.output();
    }

    static void testFlightsSelection() {
        javaImplement.initData();
        timeStatic s1=new timeStatic("sql"),s2=new timeStatic("java");

        String[] flights=tools.getFlights();
        Random rand=new Random(0);
        for(int i=0;i<20;i++) {
            String flight=flights[rand.nextInt(flights.length)];
            long tim1=System.currentTimeMillis();
            sqlImplement.selectFlight(flight);
            long tim2=System.currentTimeMillis();
            javaImplement.selectFlight(flight);
            long tim3=System.currentTimeMillis();
            s1.add(tim2-tim1);
            s2.add(tim3-tim2);
        }
        s1.output();
        s2.output();
    }

    static void testFlightsSelection2() {
        timeStatic s1=new timeStatic("sql2");

        String[] flights=tools.getFlights();
        Random rand=new Random(0);
        for(int i=0;i<20;i++) {
            String flight=flights[rand.nextInt(flights.length)];
            long tim1=System.currentTimeMillis();
            sqlImplement.selectFlight2(flight);
            long tim2=System.currentTimeMillis();
            s1.add(tim2-tim1);
        }
        s1.output();
    }

    static void testAirportChange() {
        javaImplement.initData();
        timeStatic s1=new timeStatic("sql"),s2=new timeStatic("java");

        String[] flights=tools.getFlights();
        Random rand=new Random(0);
        for(int i=0;i<5;i++) {
            String airport=flights[rand.nextInt(flights.length)];
            long tim1=System.currentTimeMillis();
            sqlImplement.changeAirport(airport);
            long tim2=System.currentTimeMillis();
            javaImplement.changeAirport(airport);
            long tim3=System.currentTimeMillis();
            s1.add(tim2-tim1);
            s2.add(tim3-tim2);
        }
        s1.output();
        s2.output();
    }

    static void testPassengersChange() {
        javaImplement.initData();
        timeStatic s1=new timeStatic("sql"),s2=new timeStatic("java");

        Random rand=new Random(0);
        for(int i=0;i<5;i++) {
            int limit=rand.nextInt(10000);
            long tim1=System.currentTimeMillis();
            sqlImplement.changePassengers(limit);
            long tim2=System.currentTimeMillis();
            javaImplement.changePassengers(limit);
            long tim3=System.currentTimeMillis();
            s1.add(tim2-tim1);
            s2.add(tim3-tim2);
        }
        s1.output();
        s2.output();
    }

    static void testPassengersChange2() {
        timeStatic s1=new timeStatic("sql");

        Random rand=new Random(0);
        for(int i=0;i<5;i++) {
            int limit=rand.nextInt(10000);
            long tim1=System.currentTimeMillis();
            sqlImplement.changePassengers(limit);
            long tim2=System.currentTimeMillis();
            s1.add(tim2-tim1);
        }
        s1.output();
    }

    public static void testPreProcessingTime() {
        long tim1=System.currentTimeMillis();
        converter1.main();
        long tim2=System.currentTimeMillis();
        javaImplement.initData();
        long tim3=System.currentTimeMillis();
        System.out.printf("sql PreProcessingTime: %dms\njava PreProcessingTime: %dms\n",tim2-tim1,tim3-tim2);
    }

    public static void main(String[] args) {
        connecter.getConnection();

        //testAirportSelection();
        //testPassengersSelection();
        //testFlightsSelection();
        //testAirportChange();
        //testPassengersChange();
        //testPreProcessingTime();

        //testAirportSelection2();
        //testPassengersSelection2();
        //testFlightsSelection2();
        //testPassengersChange2();
    }

}
