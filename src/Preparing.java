import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Preparing extends javax.swing.JFrame {
    private String filename;
    private JTextField waterField;
    private JTextField coffeeField;
    private JTextField milkField;
    private JLabel resultLabel;
    private static final String DATABASE_URL = "http://localhost:7000/preparing";

    public Preparing() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButtonUpload = new javax.swing.JButton();

        waterField = new JTextField();
        coffeeField = new JTextField();
        milkField = new JTextField();
        resultLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hello, ");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabel2.setText("Preparing");

        jLabel3.setText("jLabel3");
        jLabel4.setText("Urutan :");
        jLabel5.setText("jLabel5");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Hasil Kopi:");

        jButton3.setText("Mix Ingredients");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonUpload.setText("Upload");
        jButtonUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonUploadActionPerformed(evt);
            }
        });

        resultLabel.setText("Result: ");
        resultLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel waterLabel = new JLabel("Water (%):");
        JLabel coffeeLabel = new JLabel("Coffee (%):");
        JLabel milkLabel = new JLabel("Milk (%):");

        String[] columnNames = {"Menu", "Water (%)", "Coffee (%)", "Milk (%)"};
        Object[][] data = {
                {"Americano", 50, 50, 0},
                {"Latte", 40, 30, 30},
                {"Mineral Water", 100, 0, 0},
                {"Fresh Milk", 0, 0, 100}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jButton3))
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel7)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(jLabel2)))
                                .addGap(50, 50, 50)
                                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(waterLabel)
                                        .addComponent(coffeeLabel)
                                        .addComponent(milkLabel))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(waterField)
                                        .addComponent(coffeeField)
                                        .addComponent(milkField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonUpload)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(waterLabel)
                                        .addComponent(waterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(coffeeLabel)
                                        .addComponent(coffeeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(milkLabel)
                                        .addComponent(milkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(23, 23, 23)
                                                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButtonUpload))
                                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String simpan = jLabel3.getText();
        index in = new index();
        in.jLabel3.setText(simpan);
        in.setVisible(true);
        this.setVisible(false);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        mixIngredients();
    }

    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {
        sendResultToDatabase();
    }

    private void mixIngredients() {
        try {
            int water = Integer.parseInt(waterField.getText());
            int coffee = Integer.parseInt(coffeeField.getText());
            int milk = Integer.parseInt(milkField.getText());

            String result = determineCoffeeType(water, coffee, milk);
            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Please enter valid percentages.");
        } catch (Exception e) {
            resultLabel.setText("Error occurred while mixing ingredients.");
            e.printStackTrace();
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
            return "Custom Mix";
        }
    }

    private void sendResultToDatabase() {
        String maker = jLabel3.getText();
        String urutan = jLabel5.getText();
        String result = resultLabel.getText().replace("Result: ", "");

        try {
            URL url = new URL(DATABASE_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Urutan", urutan);
            jsonObject.put("Result", result);
            jsonObject.put("Barista", maker);

            OutputStream os = con.getOutputStream();
            os.write(jsonObject.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(this, "Result uploaded successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to upload result. Response Code: " + responseCode);
            }

            con.disconnect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error occurred while uploading result.");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preparing().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
}
