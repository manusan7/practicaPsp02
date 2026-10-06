package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import modelo.Cliente;

public class Aplicacion extends JFrame {


    private ArrayList<Cliente> clientes;

    private int posicion = 0;


    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;


    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;


    private JButton anteriorButton;
    private JButton siguienteButton;



    public Aplicacion() {

        super("Gestión de Clientes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        numeroLabel = new JLabel("Número: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");
        puntosLabel = new JLabel("Puntos: ");



        numeroField = new JTextField(10);
        nombreField = new JTextField(10);
        edadField = new JTextField(10);
        puntosField = new JTextField(10);

        numeroField.setEditable(false);
        nombreField.setEditable(false);
        edadField.setEditable(false);
        puntosField.setEditable(false);



        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");




        clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente(1, "Manuel", 19, 120.5));
        clientes.add(new Cliente(2, "Jojeras", 25, 250.0));
        clientes.add(new Cliente(3, "javi", 31, 375.75));



        anteriorButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                posicion--;

                mostrarCliente();

            }
        });



        siguienteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                posicion++;

                mostrarCliente();

            }
        });




        JPanel labelPane = new JPanel();

        labelPane.setLayout(new GridLayout(0, 1));

        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);



        JPanel fieldPane = new JPanel();

        fieldPane.setLayout(new GridLayout(0, 1));

        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);



        JPanel buttonPane = new JPanel();

        buttonPane.setLayout(new FlowLayout());

        buttonPane.add(anteriorButton);
        buttonPane.add(siguienteButton);



        JPanel contentPane = new JPanel();

        contentPane.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );

        contentPane.setLayout(new BorderLayout());

        contentPane.add(labelPane, BorderLayout.WEST);
        contentPane.add(fieldPane, BorderLayout.CENTER);
        contentPane.add(buttonPane, BorderLayout.SOUTH);



        setContentPane(contentPane);



        mostrarCliente();
    }



    private void mostrarCliente() {

        Cliente cliente = clientes.get(posicion);



        numeroField.setText("" + cliente.getNumero());

        nombreField.setText(cliente.getNombre());

        edadField.setText("" + cliente.getEdad());

        puntosField.setText("" + cliente.getPuntos());



        if (posicion == 0) {

            anteriorButton.setEnabled(false);

        } else {

            anteriorButton.setEnabled(true);
        }


        if (posicion == clientes.size() - 1) {

            siguienteButton.setEnabled(false);

        } else {

            siguienteButton.setEnabled(true);
        }
    }



    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                Aplicacion app = new Aplicacion();

                app.pack();

                app.setVisible(true);
            }
        });
    }
}