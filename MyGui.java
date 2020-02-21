import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyGui {
    int Total_money = 100;
    public static void main(String[] args) {
        MyGui gui = new MyGui();
        gui.go();
    }

    public void go() {

        // Card Label
        JLabel label_Image1 = new JLabel();
        JLabel label_Image2 = new JLabel();
        JLabel label_Image3 = new JLabel();
        JLabel label_Image4 = new JLabel();
        JLabel label_Image5 = new JLabel();
        JLabel label_Image6 = new JLabel();

        label_Image1.setBorder(new CompoundBorder(label_Image1.getBorder(), new EmptyBorder(10,10,10,10)));
        label_Image2.setBorder(new CompoundBorder(label_Image2.getBorder(), new EmptyBorder(10,10,10,10)));
        label_Image3.setBorder(new CompoundBorder(label_Image3.getBorder(), new EmptyBorder(10,10,10,10)));
        label_Image4.setBorder(new CompoundBorder(label_Image4.getBorder(), new EmptyBorder(10,10,10,10)));
        label_Image5.setBorder(new CompoundBorder(label_Image5.getBorder(), new EmptyBorder(10,10,10,10)));
        label_Image6.setBorder(new CompoundBorder(label_Image6.getBorder(), new EmptyBorder(10,10,10,10)));

        //Replace Button
        JButton btn_rpcard1 = new JButton("Replace Card 1");
        JButton btn_rpcard2 = new JButton("Replace Card 2");
        JButton btn_rpcard3 = new JButton("Replace Card 3");

        // Game button
        JButton btn_start = new JButton("Start");
        JButton btn_result = new JButton("Result");

        // Game Label
        JLabel label_bet = new JLabel("Bet: $");
        JLabel label_money = new JLabel(String.valueOf(Total_money));

        //Text field
        JTextField txt_inputbet = new JTextField(10);

        //Info label
        JLabel label_info = new JLabel("Please place your bet! Amount of money you have:$");

        //ImageIcon set
        ImageIcon Image1 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image2 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image3 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image4 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image5 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image6 = new ImageIcon("Images/card_back.gif");

        //Label set ImageIcon
        label_Image1.setIcon(Image1);
        label_Image2.setIcon(Image2);
        label_Image3.setIcon(Image3);
        label_Image4.setIcon(Image4);
        label_Image5.setIcon(Image5);
        label_Image6.setIcon(Image6);

        //Panel Init
        JPanel MainPanel = new JPanel();
        JPanel DealerPanel = new JPanel();
        JPanel PlayerPanel = new JPanel();
        JPanel RpCardBtnPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InfoPanel = new JPanel();

        //DealerPanel Init
        DealerPanel.add(label_Image1);
        DealerPanel.add(label_Image2);
        DealerPanel.add(label_Image3);

        //PlayerPanel Init
        PlayerPanel.add(label_Image4);
        PlayerPanel.add(label_Image5);
        PlayerPanel.add(label_Image6);

        //RpCardBtnPanel Init
        RpCardBtnPanel.add(btn_rpcard1);
        RpCardBtnPanel.add(btn_rpcard2);
        RpCardBtnPanel.add(btn_rpcard3);

        //ButtonPanel Init
        ButtonPanel.add(label_bet);
        ButtonPanel.add(txt_inputbet);
        ButtonPanel.add(btn_start);
        ButtonPanel.add(btn_result);

        //InfoPanel Init
        InfoPanel.add(label_info);
        InfoPanel.add(label_money);

        //MainPanel Init
        MainPanel.setLayout(new GridLayout(5,1));
        MainPanel.add(DealerPanel);
        MainPanel.add(PlayerPanel);
        MainPanel.add(RpCardBtnPanel);
        MainPanel.add(ButtonPanel);
        MainPanel.add(InfoPanel);

        //Set Background Colour
        DealerPanel.setBackground(Color.green);
        PlayerPanel.setBackground(Color.green);
        RpCardBtnPanel.setBackground(Color.green);

        //Frame Init
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(MainPanel);

        //JMenuBar Init
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu Control = new JMenu("Control");
        menuBar.add(Control);
        JMenuItem exit = new JMenuItem("Exit");
        Control.add(exit);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu help = new JMenu("Help");
        menuBar.add(help);
        help.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(frame," Rules to determine who has better cards:\n" +
                        "J, Q, K are regarded as special cards.\n" +
                        "Rule 1: The one with more special cards wins.\n" +
                        "Rule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).\n" +
                        "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        //frame setting
        frame.setTitle("A Simple Card Game");
        frame.setSize(700, 700);
        frame.setVisible(true);

        //game init
        Game game = new Game();
        btn_rpcard1.setEnabled(false);
        btn_rpcard2.setEnabled(false);
        btn_rpcard3.setEnabled(false);
        btn_result.setEnabled(false);

        //Btn_rpcard1 Listener
        btn_rpcard1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (game.gameStatus){
                    game.replacePlayerCard(1);
                    Card Card1 =  game.getPlayerHand().get(0);
                    ImageIcon tmp = new ImageIcon("Images/card_"+ Card1.rank + Card1.suit+".gif");
                    label_Image4.setIcon(tmp);
                    btn_rpcard1.setEnabled(false);

                    if (game.player.getReplace_time()==0){
                        btn_rpcard1.setEnabled(false);
                        btn_rpcard2.setEnabled(false);
                        btn_rpcard3.setEnabled(false);
                    }
                }
            }
        });

        //Btn_rpcard2 Listener
        btn_rpcard2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (game.gameStatus){
                    game.replacePlayerCard(2);
                    Card Card2 =  game.getPlayerHand().get(1);
                    ImageIcon tmp = new ImageIcon("Images/card_"+ Card2.rank + Card2.suit+".gif");
                    label_Image5.setIcon(tmp);
                    btn_rpcard2.setEnabled(false);
                    if (game.player.getReplace_time()==0){
                        btn_rpcard1.setEnabled(false);
                        btn_rpcard2.setEnabled(false);
                        btn_rpcard3.setEnabled(false);
                    }
                }
            }
        });

        //Btn_rpcard3 Listener
        btn_rpcard3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (game.gameStatus){
                    game.replacePlayerCard(3);
                    Card Card3 =  game.getPlayerHand().get(2);
                    ImageIcon tmp = new ImageIcon("Images/card_"+ Card3.rank + Card3.suit+".gif");
                    label_Image6.setIcon(tmp);
                    btn_rpcard3.setEnabled(false);
                    if (game.player.getReplace_time()==0){
                        btn_rpcard1.setEnabled(false);
                        btn_rpcard2.setEnabled(false);
                        btn_rpcard3.setEnabled(false);
                    }
                }
            }
        });

        //Btn_start Listener
        btn_start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (game.gameStatus == false) {
                    try {
                        int bet = Integer.parseInt(txt_inputbet.getText());
                        if (bet <= 0 || bet > Total_money) {
                            JOptionPane.showMessageDialog(frame, "WARNING : The bet you place must be a Positive Integer");
                        } else {
                            label_money.setText(String.valueOf(Total_money));
                            game.Start();
                            label_info.setText("Your current bet is:$"+bet+" Amount of money you have:$");
                            game.setGame_bet(bet);
                            btn_start.setEnabled(false);
                            txt_inputbet.setEditable(false);
                            btn_rpcard1.setEnabled(true);
                            btn_rpcard2.setEnabled(true);
                            btn_rpcard3.setEnabled(true);
                            btn_result.setEnabled(true);

                            ImageIcon CardBack = new ImageIcon("Images/card_back.gif");
                            label_Image1.setIcon(CardBack);
                            label_Image2.setIcon(CardBack);
                            label_Image3.setIcon(CardBack);

                            ArrayList<Card> playerHand = game.getPlayerHand();
                            int counter = 0;
                            for (Card i : playerHand) {
                                if (counter == 0) {
                                    ImageIcon tmp = new ImageIcon("Images/card_" + i.rank + i.suit + ".gif");
                                    label_Image4.setIcon(tmp);
                                    counter++;
                                } else if (counter == 1) {
                                    ImageIcon tmp = new ImageIcon("Images/card_" + i.rank + i.suit + ".gif");
                                    label_Image5.setIcon(tmp);
                                    counter++;
                                } else if (counter == 2) {
                                    ImageIcon tmp = new ImageIcon("Images/card_" + i.rank + i.suit + ".gif");
                                    label_Image6.setIcon(tmp);
                                    counter++;
                                }
                            }
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(frame, "WARNING : The bet you place must be a Positive Integer");
                    }
                }
            }
        });

        //Btn_result Listener
        btn_result.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Card> DealerHand = game.getDealerhand();
                int counter = 0;
                for (Card i : DealerHand) {
                    if (counter == 0) {
                        ImageIcon tmp = new ImageIcon("Images/card_" + i.rank + i.suit + ".gif");
                        label_Image1.setIcon(tmp);
                        counter++;
                    } else if (counter == 1) {
                        ImageIcon tmp = new ImageIcon("Images/card_" + i.rank + i.suit + ".gif");
                        label_Image2.setIcon(tmp);
                        counter++;
                    } else if (counter == 2) {
                        ImageIcon tmp = new ImageIcon("Images/card_" + i.rank + i.suit + ".gif");
                        label_Image3.setIcon(tmp);
                        counter++;
                    }
                }

                if (game.gameStatus){
                    Boolean Player_win=game.result();
                    if (Player_win){
                        JOptionPane.showMessageDialog(frame, "Congratulations! You win this round!");
                        Total_money+=game.getGame_bet();
                    }else {
                        JOptionPane.showMessageDialog(frame, "Sorry! The Dealer wins this round!");
                        Total_money-=game.getGame_bet();
                    }
                    label_money.setText(String.valueOf(Total_money));
                    label_info.setText("Please place your bet! Amount of money you have:$");
                    txt_inputbet.setEditable(true);
                    btn_start.setEnabled(true);
                    txt_inputbet.setEditable(true);
                    btn_rpcard1.setEnabled(false);
                    btn_rpcard2.setEnabled(false);
                    btn_rpcard3.setEnabled(false);
                    btn_result.setEnabled(false);
                    if (Total_money == 0){
                        label_money.setText("");
                        JOptionPane.showMessageDialog(frame,
                                "Game over!\n" +
                                        "You have no more money!\n" +
                                        "Please start a new game!"
                        );
                        label_info.setText("You have no more money! Please start a new game!");
                        txt_inputbet.setEditable(false);
                        btn_start.setEnabled(false);
                        btn_result.setEnabled(false);
                        btn_rpcard1.setEnabled(false);
                        btn_rpcard2.setEnabled(false);
                        btn_rpcard3.setEnabled(false);
                    }

                }

            }
        });
    }



}