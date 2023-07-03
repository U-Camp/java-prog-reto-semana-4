import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int TOTAL_PAGES = 3;
    private static int currentPage = 1;
    private static JPanel pagePanel;

    private static JPanel page1() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Página 1");

        // TODO: Agregar JLabel y JTextField para la pregunta y la respuesta

        panel.add(label);
        return panel;
    }

    // TODO: Agregar las funciones page2() page3() y page4()
    // (para las páginas respectivas)

    private static void goToPage(int pageNumber) {
        JPanel page = page1();

        switch (pageNumber) {
            case 1:
                page = page1();
                break;

            // TODO: Agregar case 2, 3 y 4 (para las páginas respectivas)

            default:
                page = page1();
                break;
        }

        pagePanel.removeAll();
        pagePanel.add(page);
        pagePanel.revalidate();
        pagePanel.repaint();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Reto Semana 4");
        frame.setLayout(new BorderLayout());

        // Crear el panel de páginas
        pagePanel = new JPanel();
        pagePanel.setLayout(new FlowLayout());
        frame.add(pagePanel, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();

        // Botón "Anterior"
        JButton previousButton = new JButton("Anterior");
        previousButton.addActionListener(e -> {
            if (currentPage > 1) {
                currentPage--;
                goToPage(currentPage);
            }
        });

        // Botón "Siguiente"
        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(e -> {
            if (currentPage < TOTAL_PAGES) {
                currentPage++;
                goToPage(currentPage);
            }
        });
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Configurar la ventana
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Mostrar la página inicial
        goToPage(1);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}
