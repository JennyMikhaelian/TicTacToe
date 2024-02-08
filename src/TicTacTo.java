import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacTo implements ActionListener {

    JFrame frame;
    JPanel button_panel;
    JPanel title_panel;
    JButton[] buttons = new JButton[9];
    JLabel textField;
    Random random;
    boolean player1_turn; // True if its player1's turn and false if player2's turn

    TicTacTo() {

        // X or O turn using Random
        random = new Random();

        // Creating the frame
        frame = new JFrame("TicTacTo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        // Creating a panel to display if the player won or not
        title_panel = new JPanel();
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);


        //Creating a grid panel for the buttons
        button_panel = new JPanel();
        button_panel.setLayout(new GridLayout(3, 3, 2,2));
        button_panel.setBackground(new Color(50,50,50));

        //Creating the buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        textField = new JLabel();
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 75));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setText("Tic Tac Toe");
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                        if (buttons[i].getText().equals("")) {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            player1_turn = true;
                            textField.setText("X turn");
                            check();

                        }
                }
            }
        }
    }

    // A method that determine who's turn is first
    public void firstTurn() {
        //Optional
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // The random class picks an int between 1 and 0
        // If its 0 then player one if 1 then player to 2
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        } else {
            if (random.nextInt(2) == 1) {
                player1_turn = false;
                textField.setText("O turn");
            }
        }

    }

    // A method to check if any player has won
    public void check() {
        // Check X win conditions
        // Checking the first row
        if (buttons[0].getText().equals("X") &&
                buttons[1].getText().equals("X") &&
                buttons[2].getText().equals("X")){
            xWins(0,1,2);
        }
        // Checking the second row
        if (buttons[3].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[5].getText().equals("X")){
            xWins(3,4,5);
        }
        // Checking the third row
        if (buttons[6].getText().equals("X") &&
                buttons[7].getText().equals("X") &&
                buttons[8].getText().equals("X")){
            xWins(6,7,8);
        }
        // Checking other possibilities
        if (buttons[0].getText().equals("X") &&
                buttons[3].getText().equals("X") &&
                buttons[6].getText().equals("X")) {
            xWins(0, 3, 6);
        }
        if (buttons[1].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[7].getText().equals("X")) {
            xWins(1, 4, 7);
        }
        if (buttons[2].getText().equals("X") &&
                buttons[5].getText().equals("X") &&
                buttons[8].getText().equals("X")) {
            xWins(2, 5, 8);
        }
        if (buttons[0].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[8].getText().equals("X")) {
            xWins(0, 4, 8);
        }
        if (buttons[2].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[6].getText().equals("X")) {
            xWins(2, 4, 6);
        }

        // Check O win conditions
        // Checking the first row
        if (buttons[0].getText().equals("O") &&
                buttons[1].getText().equals("O") &&
                buttons[2].getText().equals("O")){
            oWins(0,1,2);
        }
        // Checking the second row
        if (buttons[3].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[5].getText().equals("O")){
            oWins(3,4,5);
        }
        // Checking the third row
        if (buttons[6].getText().equals("O") &&
                buttons[7].getText().equals("O") &&
                buttons[8].getText().equals("O")){
            oWins(6,7,8);
        }
        // Checking other possibilities
        if (buttons[0].getText().equals("O") &&
                buttons[3].getText().equals("O") &&
                buttons[6].getText().equals("O")) {
            oWins(0, 3, 6);
        }
        if (buttons[1].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[7].getText().equals("O")) {
            oWins(1, 4, 7);
        }
        if (buttons[2].getText().equals("O") &&
                buttons[5].getText().equals("O") &&
                buttons[8].getText().equals("O")) {
            oWins(2, 5, 8);
        }
        if (buttons[0].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[8].getText().equals("O")) {
            oWins(0, 4, 8);
        }
        if (buttons[2].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[6].getText().equals("O")) {
            oWins(2, 4, 6);
        }
    }



    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins!");


    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins!");
}
}


