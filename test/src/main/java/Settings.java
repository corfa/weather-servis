public class Settings {
    public static  String city="Yekaterinburg"; //указывайте название города с большой буквы!

    //ссылки на сервисы
    public static final String Open_Weathermap="http://api.openweathermap.org/data/2.5/find?q="+city+"&type=like&APPID=67bb63b42e811c8a4db106e492ac43d4";
    public static final String Weather_Stack="http://api.weatherstack.com/current?access_key=f747b77ddad3fadb4880074e4b05f827&query="+city;
    public static final String Wunderground="https://www.wunderground.com/weather/ru/"+city.toLowerCase();
    // для добовление данных создайте базу данных "weather"
    public static final String URLmySQL="jdbc:mysql://localhost:3306/weather"; //данные для подключенния MySQL
    public static final String USER="root";
    public static final String Password="9213";


}