import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model,view);

        JFrame window = new JFrame();
        window.setTitle("Sabiha Gökçen");
        window.setSize(1280,720);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(view);
        window.pack();
        window.setVisible(true);
    }
}