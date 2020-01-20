import java.sql.*;

public class MySQL {


    public static void Create_BD() throws ClassNotFoundException {   //Создание таблицы
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connect = DriverManager.getConnection(Settings.URLmySQL, Settings.USER, Settings.Password);
            Statement statement=connect.createStatement();{
                statement.executeUpdate("create TABLE WEATHER_DATA (id MEDIUMINT NOT NULL AUTO_INCREMENT,RESPONSE VARCHAR (50) NOT NULL,PRIMARY KEY (id))");
                System.out.println("BD created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void Trans_of_MySql(String Data_Json) throws ClassNotFoundException { //внесение данных в таблицу
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connect = DriverManager.getConnection(Settings.URLmySQL, Settings.USER, Settings.Password);
            Statement statement=connect.createStatement();{
                String sql="INSERT INTO WEATHER_DATA(RESPONSE)VALUE ((?))";
                final PreparedStatement statement3 =connect.prepareStatement(sql); {
                    statement3.setString(1, Data_Json);
                    statement3.executeUpdate();
                    System.out.println("data entered in DB!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
