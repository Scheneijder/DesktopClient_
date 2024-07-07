

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class coffeegame extends JFrame {
    private JTextField waterField;
    private JTextField coffeeField;
    private JTextField milkField;
    private JLabel resultLabel;
    private static final String DATABASE_URL = "http://localhost:7000/hasil";

    public coffeegame() {
        setTitle("Coffee Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Coffee Ingredient Mixer");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel waterLabel = new JLabel("Water (%):");
        waterLabel.setBounds(50, 100, 100, 30);
        add(waterLabel);

        waterField = new JTextField();
        waterField.setBounds(150, 100, 100, 30);
        add(waterField);

        JLabel coffeeLabel = new JLabel("Coffee (%):");
        coffeeLabel.setBounds(50, 150, 100, 30);
        add(coffeeLabel);

        coffeeField = new JTextField();
        coffeeField.setBounds(150, 150, 100, 30);
        add(coffeeField);

        JLabel milkLabel = new JLabel("Milk (%):");
        milkLabel.setBounds(50, 200, 100, 30);
        add(milkLabel);

        milkField = new JTextField();
        milkField.setBounds(150, 200, 100, 30);
        add(milkField);

        JButton submitButton = new JButton("Mix Ingredients");
        submitButton.setBounds(50, 250, 200, 40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mixIngredients();
            }
        });
        add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 300, 200, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backAction();
            }
        });
        add(backButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 350, 700, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(resultLabel);
    }

    private void mixIngredients() {
        try {
            int water = Integer.parseInt(waterField.getText());
            int coffee = Integer.parseInt(coffeeField.getText());
            int milk = Integer.parseInt(milkField.getText());

            String result = determineCoffeeType(water, coffee, milk);
            resultLabel.setText("Result: " + result);

            // Send result to the database
            sendResultToDatabase(result);

        } catch (NumberFormatException e) {
            resultLabel.setText("Result: Invalid input! Please enter numbers only.");
        }
    }

    private String determineCoffeeType(int water, int coffee, int milk) {
        if (water == 50 && coffee == 50 && milk == 0) {
            return "Americano";
        } else if (water == 40 && coffee == 30 && milk == 30) {
            return "Latte";
        } else if (water == 100 && coffee == 0 && milk == 0) {
            return "Mineral Water";
        } else if (water == 0 && coffee == 0 && milk == 100) {
            return "Fresh Milk";
        } else {
            return "Failed Product";
        }
    }

    private void sendResultToDatabase(String result) {
        try {
            URL url = new URL(DATABASE_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("kopikeluar", result);

            OutputStream os = conn.getOutputStream();
            os.write(jsonObject.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                resultLabel.setText(resultLabel.getText() + " (Result saved to database)");
            } else {
                resultLabel.setText(resultLabel.getText() + " (Failed to save result to database)");
            }

            conn.disconnect();
        } catch (Exception e) {
            resultLabel.setText(resultLabel.getText() + " (Error: " + e.getMessage() + ")");
        }
    }

    private void backAction() {
        // Assuming there's a previous frame to go back to
        // Example: new PreviousFrame().setVisible(true);
        // this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new coffeegame().setVisible(true);
            }
        });
    }
}
