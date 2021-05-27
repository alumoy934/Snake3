import java.net.PortUnreachableException;

public class DatesConfig {

    public static int DELTA = 0;
    public static String username;

    public static void setDELTA(int level) {

        switch (level) {
            case 1 -> DELTA = 300;
            case 2 -> DELTA = 200;
            case 3 -> DELTA = 100;
        }
    }

}
