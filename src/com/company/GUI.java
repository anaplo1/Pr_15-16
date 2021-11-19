package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.DrinkTypeEnum.*;

public class GUI extends JFrame {
    private JButton buttonInternetOrder = new JButton("Создание интернет заказа");
    private JButton buttonRestaurantOrder = new JButton("Создание заказа в ресторане");
    private JButton buttonReadOrders = new JButton("Вывести список заказов");
    private JLabel label = new JLabel("Меню: ");
    protected TableOrdersManager tableOrdersManager = new TableOrdersManager(20); //Предположим что столов 20
    protected InternetOrdersManager internetOrdersManager = new InternetOrdersManager();

    public GUI(){
        this.setBounds(100,100,500,185);
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
            JOptionPane.showMessageDialog(null,internetOrdersManager.readAddressedOrders()+"\n"+tableOrdersManager.readOrders(),"Список заказов", JOptionPane.PLAIN_MESSAGE);
            //JOptionPane.showMessageDialog(null, );
        }
    }

    class internetOrderFrame extends JFrame {

        private JLabel tiitle = new JLabel("Внесение адресса: ");
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

            constraints.weightx = 1.5;
            constraints.weighty   = 0.5;


            constraints.gridx=0;
            constraints.fill = GridBagConstraints.CENTER;
            form.add(tiitle,constraints);

            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.gridy =1;
            constraints.gridx=0;
            form.add(cityNameLabel,constraints);
            constraints.gridx=1;
            form.add(cityName, constraints);

            constraints.gridy =2;

            constraints.gridx=0;
            form.add(zipCodeLabel,constraints);
            constraints.gridx=1;
            form.add(zipCode, constraints);

            constraints.gridy =3;

            constraints.gridx=0;
            form.add(streetNameLabel,constraints);
            constraints.gridx=1;
            form.add(streetName, constraints);

            constraints.gridy =4;

            constraints.gridx=0;
            form.add(buildNumberLabel,constraints);
            constraints.gridx=1;
            form.add(buildingNumber, constraints);

            constraints.gridy =5;

            constraints.gridx=0;
            form.add(buildingLetterLabel,constraints);
            constraints.gridx=1;
            form.add(buildingLetter, constraints);

            constraints.gridy =6;

            constraints.gridx=0;
            form.add(apartmentNumberLabel,constraints);
            constraints.gridx=1;
            form.add(apartmentNumber, constraints);

            constraints.gridy =7;
            constraints.gridx=0;
            constraints.fill = GridBagConstraints.CENTER;
            addAddress.addActionListener(new ButtonEvent1());
            form.add(addAddress,constraints);

        }
        class ButtonEvent1 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                address = new Address(cityName.getText(),Integer.parseInt(zipCode.getText()),streetName.getText(),Integer.parseInt(buildingNumber.getText()),buildingLetter.getText().charAt(0),Integer.parseInt(apartmentNumber.getText()));
                JOptionPane.showMessageDialog(null,"Адресс: "+address.getCityName()+" "+address.getZipCode()+" "+address.getStreetName()+" "+address.getBuildingNumber()+" "+address.getApartmentNumber()+"\n           Успешно добавлен!","Успех!",JOptionPane.PLAIN_MESSAGE);
                clientEntering fourthFrame = new clientEntering();
                setVisible(false);
            }
        }
        class clientEntering extends JFrame {
            private JLabel title = new JLabel("Внесите данные клиента: ");
            private JTextField firstName = new JTextField("",5);
            private JLabel firstNameLabel = new JLabel("Введите имя клиента: ");
            private JTextField secondName = new JTextField("",5);
            private JLabel secondNameLabel = new JLabel("Введите фимилию клиента: ");
            private JTextField age = new JTextField("",5);
            private JLabel ageLabel = new JLabel("Введите возраст клиента: ");
            private JButton addClient = new JButton("Ввести информаию о клиенте");
            private Customer customer;

            public clientEntering(){
                setVisible(true);
                setTitle("Окно ввода информации о клиенте: ");
                this.setBounds(100,100,400,150);

                Container form = this.getContentPane();
                form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                form.setLayout(new GridBagLayout());

                form.setLayout(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();

                constraints.weightx = 1.5;
                constraints.weighty   = 0.5;


                constraints.gridx=0;
                constraints.fill = GridBagConstraints.CENTER;
                form.add(tiitle,constraints);

                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.gridy =1;
                constraints.gridx=0;
                form.add(firstNameLabel,constraints);
                constraints.gridx=1;
                form.add(firstName, constraints);

                constraints.gridy =2;

                constraints.gridx=0;
                form.add(secondNameLabel,constraints);
                constraints.gridx=1;
                form.add(secondName, constraints);

                constraints.gridy =3;

                constraints.gridx=0;
                form.add(ageLabel,constraints);
                constraints.gridx=1;
                form.add(age, constraints);

                constraints.gridy =4;
                constraints.gridx=0;
                constraints.fill = GridBagConstraints.CENTER;
                addClient.addActionListener(new ButtonEvent2());
                form.add(addClient,constraints);
            }
            class ButtonEvent2 implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    customer = new Customer(firstName.getText(),secondName.getText(), Integer.parseInt(age.getText()), address);
                    JOptionPane.showMessageDialog(null,"Данные клиента: "+customer.getFirstName()+" "+customer.getSecondName()+" "+customer.getAge()+"\n           Успешно внесены!","Успех!",JOptionPane.PLAIN_MESSAGE);
                    AddingOrder fourthFrame = new AddingOrder();
                    setVisible(false);
                }
            }
            class AddingOrder extends JFrame{

                private JLabel title = new JLabel("Внесите данных о блюде: ");
                private JTextField dishName = new JTextField("",5);
                private JLabel dishNameLabel = new JLabel("Введите название блюда: ");
                private JTextField dishDiscription = new JTextField("",5);
                private JLabel dishDiscriptionLabel = new JLabel("Введите описание блюда: ");
                private JTextField dishPrice = new JTextField("",5);
                private JLabel dishPriceLabel = new JLabel("Введите цену блюда: ");
                private JButton addDish = new JButton("Ввести блюдо в заказ");

                private JLabel title1 = new JLabel("Внесите данных о напитке: ");
                private JTextField drinkName = new JTextField("",5);
                private JLabel drinkNameLabel = new JLabel("Введите название напитка: ");
                private JTextField drinkDiscription = new JTextField("",5);
                private JLabel drinkDiscriptionLabel = new JLabel("Введите описание напитка: ");
                private JTextField drinkPrice = new JTextField("",5);
                private JLabel drinkPriceLabel = new JLabel("Введите цену напитка: ");
                private JButton addDrink = new JButton("Ввести напиток в заказ");

                private JButton finishOrder = new JButton("Закончить ввод заказа");

                Order order = new InternetOrder();

                public AddingOrder(){
                    setVisible(true);
                    setTitle("Окно внесения заказа");
                    this.setBounds(100,100,700,150);

                    Container form = this.getContentPane();
                    form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    form.setLayout(new GridBagLayout());

                    form.setLayout(new GridBagLayout());

                    GridBagConstraints constraints = new GridBagConstraints();

                    constraints.weightx = 1.5;
                    constraints.weighty   = 0.5;

                    constraints.gridx=0;
                    constraints.fill = GridBagConstraints.HORIZONTAL;
                    form.add(title1,constraints);
                    constraints.gridy =1;
                    constraints.gridx=0;
                    form.add(drinkNameLabel,constraints);
                    constraints.gridx=1;
                    form.add(drinkName, constraints);

                    constraints.gridy =2;

                    constraints.gridx=0;
                    form.add(drinkDiscriptionLabel,constraints);
                    constraints.gridx=1;
                    form.add(drinkDiscription, constraints);

                    constraints.gridy =3;

                    constraints.gridx=0;
                    form.add(drinkPriceLabel,constraints);
                    constraints.gridx=1;
                    form.add(drinkPrice, constraints);

                    constraints.gridy =4;
                    constraints.gridx =1;
                    constraints.fill = GridBagConstraints.CENTER;
                    addDrink.addActionListener(new ButtonEvent3());
                    form.add(addDrink,constraints);

                    constraints.gridx=2;
                    constraints.gridy =0;
                    constraints.fill = GridBagConstraints.HORIZONTAL;
                    form.add(title,constraints);

                    constraints.gridy =1;
                    constraints.gridx=2;
                    form.add(dishNameLabel,constraints);
                    constraints.gridx=3;
                    form.add(dishName, constraints);

                    constraints.gridy =2;

                    constraints.gridx=2;
                    form.add(dishDiscriptionLabel,constraints);
                    constraints.gridx=3;
                    form.add(dishDiscription, constraints);

                    constraints.gridy =3;

                    constraints.gridx=2;
                    form.add(dishPriceLabel,constraints);
                    constraints.gridx=3;
                    form.add(dishPrice, constraints);

                    constraints.gridy =4;
                    constraints.gridx=3;
                    constraints.fill = GridBagConstraints.CENTER;
                    addDish.addActionListener(new ButtonEvent4());
                    form.add(addDish,constraints);

                    constraints.gridy =4;
                    constraints.gridx=2;
                    finishOrder.addActionListener(new ButtonEvent5());
                    form.add(finishOrder, constraints);
                }
                class ButtonEvent3 implements ActionListener{
                    public void actionPerformed(ActionEvent e){
                        Drink drink = new Drink(drinkName.getText(),drinkDiscription.getText(),Integer.parseInt(drinkPrice.getText()),VODKA);
                        JOptionPane.showMessageDialog(null,"Данные блюда: "+drink.getName()+" "+drink.getDiscription()+" "+drink.getPrice()+"\n           Успешно внесены!","Успех!",JOptionPane.PLAIN_MESSAGE);
                        order.add(drink);
                        //setVisible(false);
                    }
                }
                class ButtonEvent4 implements ActionListener{
                    public void actionPerformed(ActionEvent e){
                        Dish dish = new Dish(dishName.getText(), dishDiscription.getText(), Integer.parseInt(dishPrice.getText()));
                        JOptionPane.showMessageDialog(null,"Данные напитка: "+dish.getName()+" "+dish.getDiscription()+" "+dish.getPrice()+"\n           Успешно внесены!","Успех!",JOptionPane.PLAIN_MESSAGE);
                        order.add(dish);
                    }
                }
                class ButtonEvent5 implements ActionListener{
                    public void actionPerformed(ActionEvent e){
                        JOptionPane.showMessageDialog(null,"Внесенные блюда в заказ: "+order.dishesName(),"Заказ успешно внесен!",JOptionPane.PLAIN_MESSAGE);
                        internetOrdersManager.add(customer,order);
                        setVisible(false);
                    }
                }
            }
        }
    }

    class restaurantOrderFrame extends JFrame {

        private JLabel title = new JLabel("Внесите данных о блюде: ");
        private JTextField dishName = new JTextField("",5);
        private JLabel dishNameLabel = new JLabel("Введите название блюда: ");
        private JTextField dishDiscription = new JTextField("",5);
        private JLabel dishDiscriptionLabel = new JLabel("Введите описание блюда: ");
        private JTextField dishPrice = new JTextField("",5);
        private JLabel dishPriceLabel = new JLabel("Введите цену блюда: ");
        private JButton addDish = new JButton("Ввести блюдо в заказ");

        private JLabel title1 = new JLabel("Внесите данных о напитке: ");
        private JTextField drinkName = new JTextField("",5);
        private JLabel drinkNameLabel = new JLabel("Введите название напитка: ");
        private JTextField drinkDiscription = new JTextField("",5);
        private JLabel drinkDiscriptionLabel = new JLabel("Введите описание напитка: ");
        private JTextField drinkPrice = new JTextField("",5);
        private JLabel drinkPriceLabel = new JLabel("Введите цену напитка: ");
        private JButton addDrink = new JButton("Ввести напиток в заказ");

        private JLabel tableNumberLable = new JLabel("Введите номер столика: ");
        private JTextField tableNumber = new JTextField("", 5);
        private JButton finishOrder = new JButton("Закончить ввод заказа");

        Order order = new RestaurantOrder();

        public restaurantOrderFrame(){
                setVisible(true);
                setTitle("Окно внесения заказа");
                this.setBounds(100,100,800,150);

                Container form = this.getContentPane();
                form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                form.setLayout(new GridBagLayout());

                form.setLayout(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();

                constraints.weightx = 1.5;
                constraints.weighty   = 0.5;

                constraints.gridx=0;
                constraints.fill = GridBagConstraints.HORIZONTAL;
                form.add(title1,constraints);
                constraints.gridy =1;
                constraints.gridx=0;
                form.add(drinkNameLabel,constraints);
                constraints.gridx=1;
                form.add(drinkName, constraints);

                constraints.gridy =2;

                constraints.gridx=0;
                form.add(drinkDiscriptionLabel,constraints);
                constraints.gridx=1;
                form.add(drinkDiscription, constraints);

                constraints.gridy =3;

                constraints.gridx=0;
                form.add(drinkPriceLabel,constraints);
                constraints.gridx=1;
                form.add(drinkPrice, constraints);

                constraints.gridy =4;
                constraints.gridx=1;
                addDrink.addActionListener(new ButtonEvent3());
                form.add(addDrink,constraints);

                constraints.gridx=2;
                constraints.gridy =0;
                form.add(title,constraints);

                constraints.gridy =1;
                constraints.gridx=2;
                form.add(dishNameLabel,constraints);
                constraints.gridx=3;
                form.add(dishName, constraints);

                constraints.gridy =2;

                constraints.gridx=2;
                form.add(dishDiscriptionLabel,constraints);
                constraints.gridx=3;
                form.add(dishDiscription, constraints);

                constraints.gridy =3;

                constraints.gridx=2;
                form.add(dishPriceLabel,constraints);
                constraints.gridx=3;
                form.add(dishPrice, constraints);

                constraints.gridy =4;
                constraints.gridx=3;
                addDish.addActionListener(new ButtonEvent4());
                form.add(addDish,constraints);


                constraints.gridy =5;
                constraints.gridx=0;
                form.add(tableNumberLable, constraints);

                constraints.gridy =5;
                constraints.gridx=1;
                form.add(tableNumber, constraints);

                constraints.gridy =5;
                constraints.gridx=3;
                finishOrder.addActionListener(new ButtonEvent5());
                form.add(finishOrder, constraints);
        }
        class ButtonEvent3 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                Drink drink = new Drink(drinkName.getText(),drinkDiscription.getText(),Integer.parseInt(drinkPrice.getText()),VODKA);
                JOptionPane.showMessageDialog(null,"Данные блюда: "+drink.getName()+" "+drink.getDiscription()+" "+drink.getPrice()+"\n           Успешно внесены!","Успех!",JOptionPane.PLAIN_MESSAGE);
                order.add(drink);
                //setVisible(false);
            }
        }
        class ButtonEvent4 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                Dish dish = new Dish(dishName.getText(), dishDiscription.getText(), Integer.parseInt(dishPrice.getText()));
                JOptionPane.showMessageDialog(null,"Данные напитка: "+dish.getName()+" "+dish.getDiscription()+" "+dish.getPrice()+"\n           Успешно внесены!","Успех!",JOptionPane.PLAIN_MESSAGE);
                order.add(dish);
            }
        }
        class ButtonEvent5 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try {
                    tableOrdersManager.add(order,Integer.parseInt(tableNumber.getText()));
                    JOptionPane.showMessageDialog(null,"Внесенные блюда в заказ: "+order.dishesName(),"Заказ успешно внесен!",JOptionPane.PLAIN_MESSAGE);
                } catch (OrderAlreadyAddedException ex) {
                    JOptionPane.showMessageDialog(null,"Введенный заказ уже существует.", "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                } catch (IllegalTableNumber ex) {
                    JOptionPane.showMessageDialog(null,"Введенный номер стола не существует.", "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                }
                setVisible(false);
            }
        }
    }
}
