import com.sm.controller.Controller;
import com.sm.model.Model;
import com.sm.view.View;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("database.ser");

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view, file);

        controller.Start();
    }
}