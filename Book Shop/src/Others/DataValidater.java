package Others;

import java.awt.Color;
import javax.swing.JTextField;

public class DataValidater {

    private static final Color COLOR_ON_ERROR = new Color(255, 255, 153);
    private static final Color COLOR_ON_DEFAULT = new Color(255, 255, 255);
    private static final Color COLOR_ON_OK = new Color(204, 255, 204);

    public static boolean validateString(JTextField field, int size) {
        String value = field.getText();
        if ((!value.isEmpty()) || value.length() <= size) {
            setLookToOk(field);
            return true;
        } else {
            setLookToError(field);
            return false;
        }
    }

    public static boolean validateNumber(JTextField field, int size) {
        try {
            int number = Integer.parseInt(field.getText());
            if (number > size) {
                setLookToError(field);
                return false;
            } else {
                setLookToOk(field);
                return true;
            }

        } catch (NumberFormatException e) {
            setLookToError(field);
            return false;
        }
    }

    public static void setLookToError(JTextField field) {
        field.setBackground(COLOR_ON_ERROR);
    }

    public static void setLookToDefault(JTextField field) {
        field.setBackground(COLOR_ON_DEFAULT);
    }

    public static void setLookToOk(JTextField field) {
        field.setBackground(COLOR_ON_OK);
    }

}
