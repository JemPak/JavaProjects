/**
 *
 * @author JUAN JOSE MONSALVE
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class CheckConditions extends JFrame implements ActionListener{
    private JLabel label1;
    private JTextField field1;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JCheckBox box1;
            
    public CheckConditions(){
        setLayout(null);   
        setTitle("Practica-checks");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        label1 = new JLabel("Name: ");
        label1.setBounds(50, 20, 60, 20);
        add(label1);
        
        field1  =new JTextField();
        field1.setBounds(100, 20, 100, 20);
        add(field1);
        boton1 = new JButton("Check");
        boton1.setBounds(80, 50, 80, 20);
        add(boton1);
        boton1.addActionListener(this);
        

        box1 = new JCheckBox();
        box1.setBounds(20, 80, 150, 20);
        add(box1);
        box1.addActionListener(this);
        box1.setVisible(false);
        
        boton2 = new JButton("Continuar");
        boton2.setBounds(20, 120, 100, 30);
        add(boton2);
        boton2.addActionListener(this);
        boton2.setVisible(false);
    
        boton3 = new JButton("No Acepto");
        boton3.setBounds(125, 120, 100, 30);
        add(boton3);
        boton3.addActionListener(this);
        boton3.setVisible(false);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1 && !"".equals(field1.getText())){
            String name = "Yo " + field1.getText() + " Acepto";
            box1.setText(name);           
            box1.setVisible(true);
            boton2.setVisible(true);
            boton2.setEnabled(false);   
            boton3.setVisible(true);            
        }
        if (e.getSource() == box1){            
            if (box1.isSelected()){
                boton2.setEnabled(true);
                boton3.setEnabled(false);
            }else{
                boton2.setEnabled(false);
                boton3.setEnabled(true);
            }
        }
        if (e.getSource() == boton2){
            System.exit(0);
        }
        if (e.getSource() == boton3){
            System.exit(0);                           
        }
    }
    
    public static void main(String[] args) {
        CheckConditions check = new CheckConditions();
        check.setBounds(0, 0, 250, 200);
        check.setVisible(true);
        check.setLocationRelativeTo(null);
        check.setResizable(false);        
    }   
}
