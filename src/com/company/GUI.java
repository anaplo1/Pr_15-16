package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton buttonInternetOrder = new JButton("Создание интернет заказа");
    private JButton buttonRestaurantOrder = new JButton("Создание заказа в ресторане");
    private JButton buttonReadOrders = new JButton("Вывести список заказов");
    private JLabel label = new JLabel("Меню: ");
    protected TableOrdersManager tableOrdersManager = new TableOrdersManager(20); //Предположим что столов 20
    protected InternetOrdersManager internetOrdersManager = new InternetOrdersManager();

    public GUI(){
        this.setBounds(100,100,500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Основное окно выбора");

        Container form = this.getContentPane();
        form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        form.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;
        form.add(label, constraints);

        constraints.gridy =1;
        constraints.gridx =0;
        buttonInternetOrder.addActionListener(new ButtonEvent1());
        form.add(buttonInternetOrder,constraints);
        buttonRestaurantOrder.addActionListener(new ButtonEvent2());

        constraints.gridx =1;
        form.add(buttonRestaurantOrder,constraints);

        constraints.gridy =2;
        constraints.gridx =0;
        buttonReadOrders.addActionListener(new ButtonEvent3());
        form.add(buttonReadOrders,constraints);
    }

    class ButtonEvent1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            internetOrderFrame secondFrame = new internetOrderFrame();
        }
    }

    class ButtonEvent2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            restaurantOrderFrame thirdFrame = new restaurantOrderFrame();
        }
    }

    class ButtonEvent3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
        }
    }

    class internetOrderFrame extends JFrame {

        private JTextField cityName = new JTextField("",5);
        private JLabel cityNameLabel = new JLabel("Название города: ");
        private JTextField zipCode = new JTextField("",5);
        private JLabel zipCodeLabel = new JLabel("Зип код: ");
        private JTextField streetName = new JTextField("",5);
        private JLabel streetNameLabel = new JLabel("Название улицы: ");
        private JTextField buildingNumber = new JTextField("",5);
        private JLabel buildNumberLabel = new JLabel("Номер дома: ");
        private JTextField buildingLetter = new JTextField("",5);
        private JLabel buildingLetterLabel = new JLabel("Буква дома: ");
        private JTextField apartmentNumber = new JTextField("",5);
        private JLabel apartmentNumberLabel = new JLabel("Номер квартиры: ");
        private JButton addAddress = new JButton("Ввод адресса");

        public Address address;

        public internetOrderFrame(){
            setVisible(true);
            setTitle("Окно создания интернет заказа");
            this.setBounds(100,100,400,250);

            Container form = this.getContentPane();
            form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            form.setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();

            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1.5;
            constraints.weighty   = 0.5;

            constraints.gridx=0;
            form.add(cityNameLabel,constraints);
            constraints.gridx=1;
            form.add(cityName, constraints);

            constraints.weighty =1;

            constraints.gridx=0;
            form.add(zipCodeLabel,constraints);
            constraints.gridx=1;
            form.add(zipCode, constraints);

            constraints.gridy =2;

            constraints.gridx=0;
            form.add(streetNameLabel,constraints);
            constraints.gridx=1;
            form.add(streetName, constraints);

            constraints.gridy =3;

            constraints.gridx=0;
            form.add(buildNumberLabel,constraints);
            constraints.gridx=1;
            form.add(buildingNumber, constraints);

            constraints.gridy =4;

            constraints.gridx=0;
            form.add(buildingLetterLabel,constraints);
            constraints.gridx=1;
            form.add(buildingLetter, constraints);

            constraints.gridy =5;

            constraints.gridx=0;
            form.add(apartmentNumberLabel,constraints);
            constraints.gridx=1;
            form.add(apartmentNumber, constraints);

            constraints.gridy =6;
            constraints.gridx=0;
            addAddress.addActionListener(new ButtonEvent1());
            form.add(addAddress,constraints);
        }
        class ButtonEvent1 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                address = new Address(cityName.getText(),Integer.parseInt(zipCode.getText()),streetName.getText(),Integer.parseInt(buildingNumber.getText()),buildingLetter.getText().charAt(0),Integer.parseInt(apartmentNumber.getText()));
                JOptionPane.showMessageDialog(null,"Адресс: "+address.getCityName()+" "+address.getZipCode()+" "+address.getStreetName()+" "+address.getBuildingNumber()+" "+address.getApartmentNumber()+"\n           Успешно добавлен!","Успех!",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class restaurantOrderFrame extends JFrame {

        public restaurantOrderFrame(){
            setVisible(true);
            setTitle("Окно создания заказа в ресторане");
            this.setBounds(100,100,400,150);
        }
    }
}
