import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Global {
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        MySQL.Create_BD(); // Создание базы данных требуеться вызвать один раз
        Function.Result(Function.Wunderground()); //передайте сюда аргумент "Function.Openweathermap()"-выдаст данные с сайта openweathermap.org
                        //передайте сюда аргумент "Function.Weatherstack()"-выдаст данные с сайта weatherstack.com
                        //передайте сюда аргумент "Function.Wunderground()"-выдаст данные с сайта wunderground.com
    }


}