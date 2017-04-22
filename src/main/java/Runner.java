import core.ADB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    public static void main(String[] args) throws IOException {
        String someCommand = "adb devices";
        String inputCommand = "";

        //new UiSelector().resourceId("hello").text("text").checked(true);
        //new UiSelector().makeUiObject();


        while (true) {
            System.out.println("Choose from list of commands and press enter: ");
            System.out.println("-------------------------");
            System.out.println("1 : show list of devices");
            //System.out.println("2 : install app");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            inputCommand = reader.readLine();

            if (inputCommand.equals("1")) {
                System.out.println("-------------------------");
                System.out.println(ADB.command("adb devices"));}
            /*if (inputCommand.equals("2")) {
                System.out.println("Enter devices: ");
                BufferedReader readPaste = new BufferedReader(new InputStreamReader(System.in));
                String paste = readPaste.readLine();
                System.out.println("-------------------------");
                System.out.println(ADB.command("adb " + paste));
            }*/
        }
    }

}
