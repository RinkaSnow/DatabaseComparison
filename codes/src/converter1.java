import java.io.*;
import java.nio.file.Path;
import java.sql.*;


public class converter1 {

    public static void main() {
        try {
            connecter.getConnection();
            Statement st=connecter.con.createStatement();

            Path path=Path.of("flights.csv");
            File file=new File(path.toString());
            BufferedReader rd=new BufferedReader(new FileReader(file));
            String firstLine=rd.readLine();

            StringBuilder str1=new StringBuilder();
            str1.append("create table flights1 (");
            str1.append("Origin char(3),");
            str1.append("Destination char(3),");
            str1.append("Origin_City varchar(100),");
            str1.append("Origin_State varchar(100),");
            str1.append("Destination_City varchar(100),");
            str1.append("Destination_State varchar(100),");
            str1.append("Passengers int,");
            str1.append("Seats int,");
            str1.append("Flights int,");
            str1.append("Distance float,");
            str1.append("Fly_Date int");
            str1.append(");");
            st.execute(str1.toString());

            while(true) {
                String info=rd.readLine();
                if(info==null)
                    break;
                String[] infos=info.split(",");
                for(int j=0;j<infos.length;j++)
                        infos[j]=infos[j].trim();
                StringBuilder str2=new StringBuilder();
                str2.append("insert into flights1 values(");
                str2.append("\'"+infos[0]+"\',");
                str2.append("\'"+infos[1]+"\',");
                str2.append("\'"+infos[2]+"\',");
                str2.append("\'"+infos[3]+"\',");
                str2.append("\'"+infos[4]+"\',");
                str2.append("\'"+infos[5]+"\',");
                str2.append(infos[6]+",");
                str2.append(infos[7]+",");
                str2.append(infos[8]+",");
                str2.append(infos[9]+",");
                str2.append(infos[10]+"");
                str2.append(");");
                st.execute(str2.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
