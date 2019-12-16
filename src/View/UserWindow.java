package View;

import Control.ButtonListener;
import Control.FrameMoveListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.multi.MultiLabelUI;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class UserWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel header = new JPanel();
    private JPanel center = new JPanel();
    private JPanel footer = new JPanel();
    private JLabel welcome = new JLabel("Willkommen im Tierheim Moabit");
    private String dateString= LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.SHORT));
    private JLabel date = new JLabel(dateString);
    private Font headline = new Font("Arial", Font.ITALIC, 40);
    private Font subline = new Font("Arial", Font.BOLD, 20);
    private Font buttonline = new Font("Arial", Font.BOLD, 14);
    private Font textline = new Font("Arial", Font.PLAIN, 20);
    private JButton[] buttons = {new JButton("Übersicht"), new JButton("Neues Tierchen"), new JButton("Beenden")};
private JPanel centerContent=new JPanel();
    public UserWindow() {
        setFrame();
        setHeader();
        setCenter();
        setFooter();

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setFrame() {
        setLayout(new BorderLayout());
        setUndecorated(true);
        setTitle("Tierheim Moabit");
        setSize(1200, 800);
    }

    private void setHeader() {
        header.setLayout(new BorderLayout());
        header.setBackground(new Color(255,215,0));

        welcome.setFont(headline);
        welcome.setForeground(new Color(0,50,0));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(welcome,BorderLayout.PAGE_START);
        date.setFont(subline);
        date.setForeground(new Color(0,50,0));
        date.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(date, BorderLayout.PAGE_END);
        add(header, BorderLayout.PAGE_START);
        header.addMouseMotionListener(FrameMoveListener.instance);
        header.addMouseListener(FrameMoveListener.instance);
    }

    private void setCenter() {
        centerContent.setBackground(new Color(240, 240, 200));
        center.setLayout(new BorderLayout());
        Border raised = BorderFactory.createRaisedBevelBorder();
        Border lowered = BorderFactory.createLoweredBevelBorder();
        Border compount = BorderFactory.createCompoundBorder(raised,lowered);
        Border invisible = BorderFactory.createEmptyBorder(25,25,25,25);
        Border border = BorderFactory.createCompoundBorder(invisible,compount);
        center.setBorder(border);
        setCenterGreeting();
        add(center,BorderLayout.CENTER);
    }

    private void setCenterGreeting() {

		centerContent.setLayout(new GridLayout(8, 1));
		JLabel text = new JLabel("Hallo! Wir bieten eine große Auswahl an liebenswerten Tierchen, die alle ein neues Zuhause suchen.");
		JLabel text2 = new JLabel(" Für alle adoptierten Lieblinge gibt es Tierarztbesuche gratis auf Lebenszeit.");
		text.setFont(textline);
		text2.setFont(textline);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		centerContent.add(new JLabel());
		centerContent.add(new JLabel());
		centerContent.add(new JLabel());
		centerContent.add(text);
		centerContent.add(text2);
		center.add(centerContent, BorderLayout.CENTER);
	}

	public void setCenterForm(){
        centerContent.removeAll();
    }

    private void setFooter() {
        footer.setLayout(new GridLayout(1,3));
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            button.addActionListener(ButtonListener.instance);
            button.setBorder(BorderFactory.createRaisedBevelBorder());
            button.setPreferredSize(new Dimension(0,50));
            button.setFont(buttonline);
            button.setBackground(new Color(0,50,0));
            button.setForeground(new Color(255,215,0));
            footer.add(button);
        }
        add(footer, BorderLayout.PAGE_END);
    }
}
