import java.util.ArrayList;

public class Server implements ISend{
    public static ArrayList<GUI> list = new ArrayList<>();

    public void add(GUI user) {
        list.add(user);
    }

    public void send(String text, String name, String message) {
        for(GUI i: list){
            i.receive(text + name + ": " + message + "\n");
        }
    }

}
