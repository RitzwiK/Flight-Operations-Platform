package FOP;

import javax.swing.*;

public class SignupMessage {

    public SignupMessage() {
        displayErrorMessage(); // Call the method to show the error message dialog
    }

    // Method to display the error message
    private void displayErrorMessage() {
        // Create a message dialog with the specified message
        JOptionPane.showMessageDialog(null,
                "You cannot sign yourself up for this project, "
                + "you have to seek the admin to login to this frame",
                "Sign Up Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
