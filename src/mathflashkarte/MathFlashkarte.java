package mathflashkarte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MathFlashkarte extends JFrame {

    JLabel probeLabel = new JLabel();
    JLabel richtigLabel = new JLabel();
    JLabel problemLabel = new JLabel();
    JTextField probeTextField = new JTextField();
    JTextField richtigTextField = new JTextField();
    JLabel teilungLabel = new JLabel();

    JPanel problemTypPanel = new JPanel();
    JCheckBox[] typCheckBox = new JCheckBox[4];
    Color hellblau = new Color(255, 218, 185);

    JPanel faktorPanel = new JPanel();
    ButtonGroup faktorButtonGroup = new ButtonGroup();
    JRadioButton[] faktorRadioButton = new JRadioButton[11];

    JPanel timerPanel = new JPanel();
    ButtonGroup timerButtonGroup = new ButtonGroup();
    JRadioButton[] timerRadioButton = new JRadioButton[3];
    JTextField timerTextField = new JPasswordField();
    JScrollBar timerScrollBar = new JScrollBar();
    
    Font meinFont = new Font("Arial", Font.PLAIN, 18);
    
    JButton beginnenButton = new JButton();
    JButton beendenButton = new JButton();

    Random zufallig = new Random();
    int anzahlVersuche, richtigantwort;

    public static void main(String[] args) {
        // TODO code application logic here

        new MathFlashkarte().show();
    }

    public MathFlashkarte() {
        setTitle("Maths Flashkarte");
        getContentPane().setBackground(new Color(255, 239, 213));
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }

        });


        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridPlatz = new GridBagConstraints();

        probeLabel.setText("Probe:");
        probeLabel.setFont(meinFont);
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 0;
        gridPlatz.gridy = 0;
        gridPlatz.anchor = GridBagConstraints.WEST;
        gridPlatz.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(probeLabel, gridPlatz);

        probeTextField.setText("0");
        probeTextField.setPreferredSize(new Dimension(90, 30));
        probeTextField.setEditable(false);
        probeTextField.setBackground(new Color(255,127,80 ));
        probeTextField.setForeground(Color.BLUE);
        probeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        probeTextField.setFont(meinFont);
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 1;
        gridPlatz.gridy = 0;
        gridPlatz.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(probeTextField, gridPlatz);

        richtigLabel.setText("Richtig:");
        richtigLabel.setFont(meinFont);
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 2;
        gridPlatz.gridy = 0;
        gridPlatz.anchor = GridBagConstraints.EAST;
        gridPlatz.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(richtigLabel, gridPlatz);

        richtigTextField.setText("0");
        richtigTextField.setPreferredSize(new Dimension(90, 30));
        richtigTextField.setEditable(false);
        richtigTextField.setBackground(new Color(255,127,80 ));
        richtigTextField.setForeground(Color.BLUE);
        richtigTextField.setHorizontalAlignment(SwingConstants.CENTER);
        richtigTextField.setFont(meinFont);
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 3;
        gridPlatz.gridy = 0;
        gridPlatz.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(richtigTextField, gridPlatz);

        problemLabel.setText("");
        problemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        problemLabel.setPreferredSize(new Dimension(450, 100));
        problemLabel.setBackground(Color.WHITE);
        problemLabel.setOpaque(true);
        problemLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        problemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 0;
        gridPlatz.gridy = 1;
        gridPlatz.gridwidth = 5;
        gridPlatz.insets = new Insets(10, 0, 0, 10);
        getContentPane().add(problemLabel, gridPlatz);

        teilungLabel.setPreferredSize(new Dimension(450, 10));
        teilungLabel.setBackground(new Color(255,127,80 ));
        teilungLabel.setOpaque(true);
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 0;
        gridPlatz.gridy = 2;
        gridPlatz.gridwidth = 5;
        gridPlatz.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(teilungLabel, gridPlatz);

        UIManager.put("TitledBorder.font", new Font("Arial", Font.BOLD, 14));
        problemTypPanel.setPreferredSize(new Dimension(130, 130));
        problemTypPanel.setBorder(BorderFactory.createTitledBorder("Problemtyp :"));
        problemTypPanel.setBackground(hellblau);
        problemTypPanel.setLayout(new GridBagLayout());
        gridPlatz = new GridBagConstraints();
        gridPlatz.gridx = 0;
        gridPlatz.gridy = 3;
        gridPlatz.gridwidth = 2;
        gridPlatz.anchor = GridBagConstraints.NORTH;
        getContentPane().add(problemTypPanel, gridPlatz);

        for (int i = 0; i < 4; i++) {
            typCheckBox[i] = new JCheckBox();
            typCheckBox[i].setBackground(hellblau);
            gridPlatz.gridx = 0;
            gridPlatz.gridy = i;
            gridPlatz.anchor = GridBagConstraints.WEST;
            problemTypPanel.add(typCheckBox[i], gridPlatz);
            typCheckBox[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    typCheckBoxActionPerformed(e);
                }
            });
        }
            typCheckBox[0].setText("Addition");
            typCheckBox[1].setText("Substruktion");
            typCheckBox[2].setText("Multiplikation");
            typCheckBox[3].setText("Division");
            typCheckBox[0].setSelected(true);

            faktorPanel.setPreferredSize(new Dimension(130, 130));
            faktorPanel.setBorder(BorderFactory.createTitledBorder("Faktor:"));
            faktorPanel.setBackground(hellblau);
            faktorPanel.setLayout(new GridBagLayout());
            gridPlatz = new GridBagConstraints();
            gridPlatz.gridx = 2;
            gridPlatz.gridy = 3;
            gridPlatz.gridwidth = 2;
            gridPlatz.anchor = GridBagConstraints.NORTH;
            getContentPane().add(faktorPanel, gridPlatz);
            int x = 2;
            int y = 0;
            for (int i = 0; i < 11; i++) {
                faktorRadioButton[i] = new JRadioButton();
                faktorRadioButton[i].setText(String.valueOf(i));
                faktorRadioButton[i].setBackground(hellblau);
                faktorButtonGroup.add(faktorRadioButton[i]);
                gridPlatz = new GridBagConstraints();

                if (i < 10) {
                    gridPlatz.gridx = x;
                    gridPlatz.gridy = y;
                } else {
                    gridPlatz.gridx = 0;
                    gridPlatz.gridy = 0;
                    gridPlatz.gridwidth = 2;
                }
                gridPlatz.anchor = GridBagConstraints.WEST;
                faktorPanel.add(faktorRadioButton[i], gridPlatz);
                faktorRadioButton[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                x++;
                if (x > 2) {
                    x = 0;
                    y++;
                }
            }
            faktorRadioButton[10].setText("Random");
            faktorRadioButton[10].setSelected(true);

            timerPanel.setPreferredSize(new Dimension(130, 130));
            timerPanel.setBorder(BorderFactory.createTitledBorder("Timer: "));
            timerPanel.setBackground(hellblau);
            timerPanel.setLayout(new GridBagLayout());
            gridPlatz = new GridBagConstraints();
            gridPlatz.gridx = 4;
            gridPlatz.gridy = 3;
            gridPlatz.insets = new Insets(0, 0, 0, 10);
            gridPlatz.anchor = GridBagConstraints.NORTH;
            getContentPane().add(timerPanel, gridPlatz);

            for (int a = 0; a < 3; a++) {
                timerRadioButton[a] = new JRadioButton();
                timerRadioButton[a].setBackground(hellblau);
                timerButtonGroup.add(timerRadioButton[a]);
                gridPlatz = new GridBagConstraints();
                gridPlatz.gridx = 0;
                gridPlatz.gridy = a;
                gridPlatz.gridwidth = 2;
                gridPlatz.anchor = GridBagConstraints.WEST;
                timerPanel.add(timerRadioButton[a], gridPlatz);
                timerRadioButton[a].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timerRadioButtonActionPerformed(e);
                    }
                });
            }

            timerRadioButton[0].setText("Off");
            timerRadioButton[1].setText("On-Count up");
            timerRadioButton[2].setText("On-Count down");
            timerRadioButton[0].setSelected(true);

            timerTextField.setText("Off");
            timerTextField.setPreferredSize(new Dimension(90, 25));
            timerTextField.setEditable(false);
            timerTextField.setBackground(Color.WHITE);
            timerTextField.setForeground(Color.RED);
            timerTextField.setHorizontalAlignment(SwingConstants.CENTER);
            timerTextField.setFont(meinFont);
            gridPlatz = new GridBagConstraints();
            gridPlatz.gridx = 0;
            gridPlatz.gridy = 3;
            gridPlatz.anchor = GridBagConstraints.WEST;
            gridPlatz.insets = new Insets(5, 0, 0, 0);
            timerPanel.add(timerTextField, gridPlatz);

            timerScrollBar.setPreferredSize(new Dimension(20, 25));
            timerScrollBar.setMinimum(1);
            timerScrollBar.setMaximum(60);
            timerScrollBar.setValue(1);
            timerScrollBar.setBlockIncrement(1);
            timerScrollBar.setUnitIncrement(1);
            timerScrollBar.setOrientation(JScrollBar.VERTICAL);
            timerScrollBar.setEnabled(false);
            gridPlatz = new GridBagConstraints();
            gridPlatz.gridx = 1;
            gridPlatz.gridy = 3;
            gridPlatz.anchor = GridBagConstraints.WEST;
            gridPlatz.insets = new Insets(5, 0, 0, 0);
            timerPanel.add(timerScrollBar, gridPlatz);
            timerScrollBar.addAdjustmentListener(new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged(AdjustmentEvent e) {
                        timerScrollBarAdjustmentValueChanged(e);
                    }

            });

            beginnenButton.setText("Beginnen");
            gridPlatz = new GridBagConstraints();
            gridPlatz.gridx = 0;
            gridPlatz.gridy = 4;
            gridPlatz.gridwidth = 2;
            gridPlatz.insets = new Insets(10, 0, 10, 0);
            getContentPane().add(beginnenButton, gridPlatz);
            beginnenButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    beginnenButtonActionPerformed(e);
                }
            });
            
            beendenButton.setText("Beenden");
            gridPlatz = new GridBagConstraints();
            gridPlatz.gridx = 2;
            gridPlatz.gridy = 4;
            gridPlatz.gridwidth = 2;
            gridPlatz.insets = new Insets(10, 0, 10, 0);
            getContentPane().add(beendenButton, gridPlatz);



            beendenButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    beendenButtonActionPerformed(e);
                }
            });
            pack();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        }

    private void beginnenButtonActionPerformed(ActionEvent e) {
    if(beginnenButton.getText().equals("Beginnen"))
    {
        beginnenButton.setText("Beenden");
        beendenButton.setEnabled(false);
        anzahlVersuche = 0;
        richtigantwort = 0;
        probeTextField.setText("0");
        richtigTextField.setText("0");
        problemLabel.setText(getProblem());
    }
    else
    {
        beginnenButton.setText("Beginnen");
        beendenButton.setEnabled(true);
        problemLabel.setText("");
    }
        
    }
    private String getProblem()
    {
        return ("Problem!");
    }

    private void beendenButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }


    private void exitForm(WindowEvent e) {
        System.exit(0);
    }

    private void timerScrollBarAdjustmentValueChanged(AdjustmentEvent e) {
    }

    private void timerRadioButtonActionPerformed(ActionEvent e) {
    }

    private void typCheckBoxActionPerformed(ActionEvent e) {
    }

}