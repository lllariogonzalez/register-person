package View;

import javax.swing.JOptionPane;

public class Window {

    // metodo para obtener datos desde un input
    public static String input(String message) {
        return JOptionPane.showInputDialog(message);
    }

    // metodo para mostrar un mensaje
    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    // metodo para mostrar un error
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                "alert",
                JOptionPane.ERROR_MESSAGE);
    }

    // metodo para confirmar o preguntar por dos opciones
    public static boolean option(String message, String optionOne, String optionTwo) {
        int confirmation = JOptionPane.showOptionDialog(null,
                message,
                "Confirmación",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{optionOne, optionTwo},
                optionOne);

        return confirmation != JOptionPane.NO_OPTION && confirmation != JOptionPane.CLOSED_OPTION;

    }
}