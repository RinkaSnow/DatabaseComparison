import java.sql.SQLException;
import java.sql.Statement;

public class sqlImplement {
    public static void selectAirport(String airport) {
        try {
            Statement st=connecter.con.createStatement();
            String query="select * from flights1 sqlRes1 where (origin = \'"+airport+"\');";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectAirport2(String airport) {
        try {
            Statement st=connecter.con.createStatement();
            String query="select * from flights2 sqlRes1 where (origin = \'"+airport+"\');";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectPassengers(int passengers) {
        try {
            Statement st=connecter.con.createStatement();
            String query="select * from flights1 sqlRes2 where (passengers = "+passengers+");";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectPassengers2(int passengers) {
        try {
            Statement st=connecter.con.createStatement();
            String query="select * from flights2 sqlRes2 where (passengers = "+passengers+");";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectFlight(String flight) {
        try {
            String[] infos=flight.split(",");
            for(int j=0;j<infos.length;j++)
                infos[j]=infos[j].trim();
            Statement st=connecter.con.createStatement();
            String query="select * from flights1 sqlRes3 where ("+
                    "origin=\'"+infos[0]+"\' and "+
                    "destination=\'"+infos[1]+"\' and "+
                    "origin_city=\'"+infos[2]+"\' and "+
                    "origin_state=\'"+infos[3]+"\' and "+
                    "destination=\'"+infos[4]+"\' and "+
                    "destination=\'"+infos[5]+"\' and "+
                    "passengers="+infos[6]+" and "+
                    "seats="+infos[7]+" and "+
                    "flights="+infos[8]+" and "+
                    "distance="+infos[9]+" and "+
                    "fly_date="+infos[10]+
                    ");";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectFlight2(String flight) {
        try {
            String[] infos=flight.split(",");
            for(int j=0;j<infos.length;j++)
                infos[j]=infos[j].trim();
            Statement st=connecter.con.createStatement();
            String query="select * from flights2 sqlRes3 where ("+
                    "origin=\'"+infos[0]+"\' and "+
                    "destination=\'"+infos[1]+"\' and "+
                    "passengers="+infos[6]+" and "+
                    "seats="+infos[7]+" and "+
                    "flights="+infos[8]+" and "+
                    "distance="+infos[9]+" and "+
                    "fly_date="+infos[10]+
                    ");";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeAirport(String airport) {
        try {
            Statement st=connecter.con.createStatement();
            String query="update flights1 set origin = " +
                        "replace( origin, \'"+airport.toUpperCase()+"\', \'"+airport.toLowerCase()+
                        "\') where origin = \'"+airport.toUpperCase()+"\';";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void changePassengers(int limit) {
        try {
            Statement st=connecter.con.createStatement();
            String query="update flights1 set passengers = passengers*2" +
                    " where passengers >="+((Integer)limit).toString()+";";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void changePassengers2(int limit) {
        try {
            Statement st=connecter.con.createStatement();
            String query="update flights2 set passengers = passengers*2" +
                    " where passengers >="+((Integer)limit).toString()+";";
            st.execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
