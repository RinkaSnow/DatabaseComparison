import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class tools {

    public static String[] getFlights() {
        ArrayList<String>infos=new ArrayList<String>();
        try {
            Path path = Path.of("flights.csv");
            File file = new File(path.toString());
            BufferedReader rd = new BufferedReader(new FileReader(file));
            String firstLine = rd.readLine();

            while(true) {
                String info=rd.readLine();
                if(info==null)
                    break;
                infos.add(info);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        var elements=infos.toArray();
        String[] res=new String[elements.length];
        for(int i=0;i< elements.length;i++)
            res[i]=(String)elements[i];
        return res;
    }
    public static String[] getStates() {
        String[] res=new String[1];
        try {
            TreeSet<String> States = new TreeSet<String>();

            Path path = Path.of("flights.csv");
            File file = new File(path.toString());
            BufferedReader rd = new BufferedReader(new FileReader(file));
            String firstLine = rd.readLine();

            while(true) {
                String info=rd.readLine();
                if(info==null)
                    break;
                String[] infos=info.split(",");
                for(int j=0;j<infos.length;j++)
                    infos[j]=infos[j].trim();
                States.add(infos[3]);
                States.add(infos[5]);
            }

            var elements = States.toArray();
            res = new String[elements.length];
            for (int i = 0; i < elements.length; i++)
                res[i] = (String) elements[i];
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public static String[] getCities() {
        String[] res=new String[1];
        try {
            TreeSet<String> Cities = new TreeSet<String>();

            Path path = Path.of("flights.csv");
            File file = new File(path.toString());
            BufferedReader rd = new BufferedReader(new FileReader(file));
            String firstLine = rd.readLine();

            while(true) {
                String info=rd.readLine();
                if(info==null)
                    break;
                String[] infos=info.split(",");
                for(int j=0;j<infos.length;j++)
                    infos[j]=infos[j].trim();
                Cities.add(infos[2]);
                Cities.add(infos[4]);
            }

            var elements = Cities.toArray();
            res = new String[elements.length];
            for (int i = 0; i < elements.length; i++)
                res[i] = (String) elements[i];
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public static String[] getAirports() {
        String[] res=new String[1];
        try {
            TreeSet<String> Airports = new TreeSet<String>();

            Path path = Path.of("flights.csv");
            File file = new File(path.toString());
            BufferedReader rd = new BufferedReader(new FileReader(file));
            String firstLine = rd.readLine();

            while(true) {
                String info=rd.readLine();
                if(info==null)
                    break;
                String[] infos=info.split(",");
                for(int j=0;j<infos.length;j++)
                    infos[j]=infos[j].trim();
                Airports.add(infos[0]);
                Airports.add(infos[1]);
            }

            var elements = Airports.toArray();
            res = new String[elements.length];
            for (int i = 0; i < elements.length; i++)
                res[i] = (String) elements[i];
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public static void debug() {
        try {
            Path path = Path.of("flights.csv");
            File file = new File(path.toString());
            BufferedReader rd = new BufferedReader(new FileReader(file));
            String firstLine = rd.readLine();

            System.out.println(firstLine);

            while(true) {
                String info=rd.readLine();
                if(info==null)
                    break;
                String[] infos=info.split(",");
                for(int j=0;j<infos.length;j++)
                    infos[j]=infos[j].trim();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

    }
}
