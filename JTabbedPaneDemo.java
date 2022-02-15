import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/*
<applet code="JTabbedPaneDemo" width=400 height=100>
</applet>
*/
public class JTabbedPaneDemo extends JApplet {
    public void init() {
        try {
            SwingUtilities.invokeAndWait(
                    new Runnable() {
                        public void run() {
                            makeGUI();
                        }
                    }
            );
        } catch (Exception exc) {
            System.out.println("Can't create because of " +exc);
        }
    }

    private void makeGUI() {
    	
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Semister", new SemisterPanel());
        jtp.addTab("Course", new CoursePanel());
        jtp.addTab("Elective", new ElectivePanel());
        add(jtp);
    
    }
}

// Make the panels that will be added to the tabbed pane.
class SemisterPanel extends JPanel {
    public SemisterPanel() {
        JButton b1 = new JButton("2");
        add(b1);
        JButton b2 = new JButton("4");
        add(b2);
        JButton b3 = new JButton("6");
        add(b3);
        JButton b4 = new JButton("8");
        add(b4);
        
}
}



class CoursePanel extends JPanel {
    public CoursePanel() {
        JCheckBox cb1 = new JCheckBox("EC");
        add(cb1);
        JCheckBox cb2 = new JCheckBox("ISE");
        add(cb2);
        JCheckBox cb3 = new JCheckBox("CSE");
        add(cb3);
    }
}
class ElectivePanel extends JPanel {
    public ElectivePanel() {
        JComboBox jcb = new JComboBox();
        jcb.addItem("AI");
        jcb.addItem("IoT");
        jcb.addItem("Big Data");
        add(jcb);
    }


}
