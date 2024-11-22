/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajo_clase_estructuradedatos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author eliza
 */
public class Trabajo_Clase_Estructuradedatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        private JButton[][] buttons = new JButton[3][3];
    private String currentPlayer = "X";
    private String playerXName = "Jugador 1";
    private String playerOName = "Jugador 2";
    private JLabel statusLabel;

    public Trabajo_Clase_Estructuradedatos {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        statusLabel = new JLabel("Turno de: " + playerXName + " (X)");
        add(statusLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener((ActionListener) new ButtonClickListener(i, j));
                boardPanel.add(buttons[i][j]);
            }
        }

        initializePlayers();
    }

    private void initializePlayers() {
        playerXName = JOptionPane.showInputDialog(this, "Nombre del Jugador 1 (X):", "Jugador 1");
        playerOName = JOptionPane.showInputDialog(this, "Nombre del Jugador 2 (O):", "Jugador 2");
        statusLabel.setText("Turno de: " + playerXName + " (X)");
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        String nextPlayerName = currentPlayer.equals("X") ? playerXName : playerOName;
        statusLabel.setText("Turno de: " + nextPlayerName + " (" + currentPlayer + ")");
    }

    private boolean checkWinner(String player) {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(player) &&
                buttons[i][1].getText().equals(player) &&
                buttons[i][2].getText().equals(player)) return true;

            if (buttons[0][i].getText().equals(player) &&
                buttons[1][i].getText().equals(player) &&
                buttons[2][i].getText().equals(player)) return true;
        }

        if (buttons[0][0].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][2].getText().equals(player)) return true;

        if (buttons[0][2].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][0].getText().equals(player)) return true;

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) return false;
            }
        }
        return true;
    }

    private void add(JLabel statusLabel, String NORTH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLayout(BorderLayout borderLayout) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTitle(String tic_Tac_Toe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!buttons[row][col].getText().isEmpty()) {
                JOptionPane.showMessageDialog(TicTacToe.this, "Celda ocupada. Intenta otra.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            buttons[row][col].setText(currentPlayer);

            if (checkWinner(currentPlayer)) {
                String winnerName = currentPlayer.equals("X") ? playerXName : playerOName;
                JOptionPane.showMessageDialog(TicTacToe.this, "¡" + winnerName + " (" + currentPlayer + ") ganó!", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
                resetBoard();
                return;
            }

            if (isBoardFull()) {
                JOptionPane.showMessageDialog(TicTacToe.this, "¡Empate!", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
                resetBoard();
                return;
            }

            switchPlayer();
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = "X";
        statusLabel.setText("Turno de: " + playerXName + " (X)");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToe game = new TicTacToe();
            game.setVisible(true);
        });
    }
    
}
