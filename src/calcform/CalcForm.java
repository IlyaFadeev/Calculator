package calcform;

import calc.Calc;
import com.sun.webpane.webkit.dom.KeyboardEventImpl;
import exception.EmptyNumricalStackException;
import exception.EmptyOperationStackException;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.util.EmptyStackException;

/**
 * Created by Ilya on 28.03.2015.
 */
public class CalcForm extends JFrame {
    public JPanel panel = new JPanel();

    public JButton button7 = new JButton();
    public JButton button8 = new JButton();
    public JButton button9 = new JButton();
    public JButton button4 = new JButton();
    public JButton button5 = new JButton();
    public JButton button6 = new JButton();
    public JButton button1 = new JButton();
    public JButton button2 = new JButton();
    public JButton button3 = new JButton();
    public JButton button0 = new JButton();
    public JButton buttonMult = new JButton();
    public JButton buttonMinus = new JButton();
    public JButton buttonDel = new JButton();
    public JButton buttonPlus = new JButton();
    public JButton buttonDelete = new JButton();
    public JButton buttonClear = new JButton();
    public JButton buttonPoint = new JButton();
    public JButton buttonRes = new JButton();
    public JButton buttonOpen = new JButton();
    public JButton buttonClose = new JButton();
    public JTextField inputField = new JTextField();
    public static JMenuBar plafMenu = new JMenuBar();
    public CalcForm() throws UnsupportedLookAndFeelException
    {
        super("Calculator");
        JMenu plaf = new JMenu("PLaF");
        JMenuItem metalItem = new JMenuItem("Metal");
        JMenuItem nimbusItem = new JMenuItem("Nimbus");
        JMenuItem synthItem = new JMenuItem("Synth");

        metalItem.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e){
                javax.swing.plaf.metal.MetalLookAndFeel nimbusLookAndFeel = new MetalLookAndFeel();
                try {
                    javax.swing.UIManager.setLookAndFeel(nimbusLookAndFeel);
                    panel.updateUI();
                }
                catch (UnsupportedLookAndFeelException exc)
                {
                    exc.printStackTrace();
                }
            }
        });

        nimbusItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.plaf.nimbus.NimbusLookAndFeel nimbusLookAndFeel = new NimbusLookAndFeel();
                try {
                    javax.swing.UIManager.setLookAndFeel(nimbusLookAndFeel);
                    panel.updateUI();
                }
                catch (UnsupportedLookAndFeelException exc)
                {
                    exc.printStackTrace();
                }
            }
        });

        synthItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.plaf.synth.SynthLookAndFeel nimbusLookAndFeel = new SynthLookAndFeel();
                try {
                    javax.swing.UIManager.setLookAndFeel(nimbusLookAndFeel);
                    panel.updateUI();
                } catch (UnsupportedLookAndFeelException exc) {
                    exc.printStackTrace();
                }
            }
        });
        plaf.add(metalItem);
        plaf.add(nimbusItem);
        plaf.add(synthItem);
        plafMenu.add(plaf);
        plafMenu.setBounds(50, 50, 100, 100);
        inputField.setEnabled(false);
        inputField.setFont(new Font("Verdana", 100, 35));
        panel.setLayout(null);
        panel.setFont(new Font("Verdana", 0, 12));
        inputField.setFocusable(true);
        inputField.setBounds(5, 5, 255, 50);
        //(
        buttonOpen.setBounds(160, 60, 50, 25);
        buttonOpen.setText("(");
        //)
        buttonClose.setBounds(210, 60, 50, 25);
        buttonClose.setText(")");
        //c
        buttonDelete.setBounds(5, 60, 50, 25);
        buttonDelete.setText("<-");
        //clear
        buttonClear.setBounds(55, 60, 100, 25);
        buttonClear.setText("C");
        //7
        button7.setBounds(5, 85, 50, 25);
        button7.setText("7");
        //8
        button8.setBounds(55, 85, 50, 25);
        button8.setText("8");
        //9
        button9.setBounds(105, 85, 50, 25);
        button9.setText("9");
        //*
        buttonMult.setBounds(160, 85, 50, 25);
        buttonMult.setText("*");
        //
        buttonDel.setBounds(210, 85, 50, 25);
        buttonDel.setText("/");
        //4
        button4.setBounds(5, 110, 50, 25);
        button4.setText("4");
        //5
        button5.setBounds(55, 110, 50, 25);
        button5.setText("5");
        //6
        button6.setBounds(105, 110, 50, 25);
        button6.setText("6");
        //1
        button1.setBounds(5, 135, 50, 25);
        button1.setText("1");
        //2
        button2.setBounds(55, 135, 50, 25);
        button2.setText("2");
        //3
        button3.setBounds(105, 135, 50, 25);
        button3.setText("3");
        //+
        buttonPlus.setBounds(160, 110, 50, 25);
        buttonPlus.setText("+");
        //-
        buttonMinus.setBounds(210, 110, 50, 25);
        buttonMinus.setText("-");
        //0
        button0.setBounds(5, 160, 100, 25);
        button0.setText("0");
        //.
        buttonPoint.setBounds(105, 160, 50, 25);
        buttonPoint.setText(".");
        //=
        buttonRes.setBounds(160, 135, 100, 50);
        buttonRes.setText("=");
        panel.add(inputField);
        panel.add(buttonClose);
        panel.add(buttonOpen);
        panel.add(buttonDelete);
        panel.add(buttonClear);
        panel.add(buttonRes);
        panel.add(buttonPoint);
        panel.add(button0);
        panel.add(buttonMinus);
        panel.add(buttonPlus);
        panel.add(button3);
        panel.add(button2);
        panel.add(button1);
        panel.add(button6);
        panel.add(button4);
        panel.add(button5);
        panel.add(buttonMult);
        panel.add(buttonDel);
        panel.add(button9);
        panel.add(button8);
        panel.add(button7);
        panel.setFocusable(true);
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + buttonClose.getText();
                inputField.setText(buf);
            }
        });
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                String buf = "";
                if ((e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0) && (!e.isShiftDown())) {

                    buf = inputField.getText() + "0";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

                    buf = inputField.getText() + "1";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

                    buf = inputField.getText() + "2";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3) {

                    buf = inputField.getText() + "3";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    buf = inputField.getText() + "4";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    buf = inputField.getText() + "5";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

                    buf = inputField.getText() + "6";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    buf = inputField.getText() + "7";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    buf = inputField.getText() + "8";
                    inputField.setText(buf);
                } else if ((e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9) && (!e.isShiftDown())) {

                    buf = inputField.getText() + "9";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Calc calc = new Calc();
                    try {
                        inputField.setText(Double.toString(calc.getResultOfExpression(inputField.getText().toCharArray())));
                    } catch (EmptyNumricalStackException ex) {

                        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (EmptyOperationStackException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (EmptyStackException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "Empty field!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Wrong number format!", "Error",JOptionPane.ERROR_MESSAGE);
                        inputField.setText("");
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_EQUALS) {
                    Calc calc = new Calc();
                    try {
                        inputField.setText(Double.toString(calc.getResultOfExpression(inputField.getText().toCharArray())));
                    } catch (EmptyNumricalStackException ex) {

                        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (EmptyOperationStackException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (EmptyStackException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "Empty field!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Wrong number format!", "Error",JOptionPane.ERROR_MESSAGE);
                        inputField.setText("");
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    buf = inputField.getText();
                    char[] c = buf.toCharArray();
                    buf = "";
                    for (int i = 0; i < c.length - 1; i++) {
                        buf += c[i];
                    }
                    inputField.setText(buf);
                } else if ((e.getKeyCode() == KeyEvent.VK_ADD)) {
                    buf = inputField.getText() + "+";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_SUBTRACT || e.getKeyCode() == KeyEvent.VK_MINUS) {
                    buf = inputField.getText() + "-";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                    buf = inputField.getText() + "*";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
                    buf = inputField.getText() + "/";
                    inputField.setText(buf);
                } else if (e.getKeyCode() == KeyEvent.VK_PERIOD || e.getKeyCode() == KeyEvent.VK_QUOTE || e.getKeyCode() == KeyEvent.VK_COMMA || e.getKeyCode() == KeyEvent.VK_DECIMAL) {
                    buf = inputField.getText() + ".";
                    inputField.setText(buf);
                } else if (e.getKeyChar() == '(') {
                    buf = inputField.getText() + "(";
                    inputField.setText(buf);
                } else if (e.getKeyChar() == ')') {
                    buf = inputField.getText() + ")";
                    inputField.setText(buf);
                }
                //buf += e.getKeyChar();
                //inputField.setText(buf);
            }
        });


                buttonOpen.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String buf = "";
                        buf = inputField.getText() + buttonOpen.getText();
                        inputField.setText(buf);
                    }
                });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button0.getText();
                inputField.setText(buf);

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button1.getText();
                inputField.setText(buf);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button2.getText();
                inputField.setText(buf);

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button3.getText();
                inputField.setText(buf);

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button4.getText();
                inputField.setText(buf);

            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button5.getText();
                inputField.setText(buf);

            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button6.getText();
                inputField.setText(buf);

            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button7.getText();
                inputField.setText(buf);

            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button8.getText();
                inputField.setText(buf);

            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + button9.getText();
                inputField.setText(buf);

            }
        });
        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + buttonPoint.getText();
                inputField.setText(buf);

            }
        });
        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + buttonMult.getText();
                inputField.setText(buf);

            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + buttonMinus.getText();
                inputField.setText(buf);

            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + buttonPlus.getText();
                inputField.setText(buf);

            }
        });
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText() + buttonDel.getText();
                inputField.setText(buf);

            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buf = "";
                buf = inputField.getText();
                char[] c = buf.toCharArray();
                buf = "";
                for (int i = 0; i < c.length - 1; i++) {
                    buf += c[i];
                }
                inputField.setText(buf);

            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");

            }
        });
        buttonRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calc calc = new Calc();
                try {
                    inputField.setText(Double.toString(calc.getResultOfExpression(inputField.getText().toCharArray())));
                }
                catch (EmptyNumricalStackException ex)
                {

                    JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (EmptyOperationStackException ex)
                {
                    JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (EmptyStackException ex)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Empty field!", "Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Wrong number format!", "Error",JOptionPane.ERROR_MESSAGE);
                    inputField.setText("");
                }
            }
        });
        getContentPane().add(panel);
        setPreferredSize(new Dimension(285, 145));

    }



}
