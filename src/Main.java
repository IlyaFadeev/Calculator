import calcform.CalcForm;

import javax.swing.*;
import calcform.CalcForm;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;

/**
 * Created by Ilya on 28.03.2015.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, IllegalAccessException, InstantiationException, ClassNotFoundException{

        CalcForm frame = new CalcForm();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(CalcForm.plafMenu);
        frame.setSize(new Dimension(270, 245));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}