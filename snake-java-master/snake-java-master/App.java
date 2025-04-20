import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        int boardWidth = 600;
        int boardHeight = 600;

        JFrame frame = new JFrame("Snake");

        // Create game panel
        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);

        // Create restart button
        JButton restartButton = new JButton("Restart");
        restartButton.setFocusable(false); // Prevents focus issues with arrow keys
        restartButton.addActionListener(e -> snakeGame.refreshGame());

        // Create a container panel to hold game and button
        JPanel container = new JPanel(new BorderLayout());
        container.add(snakeGame, BorderLayout.CENTER);
        container.add(restartButton, BorderLayout.SOUTH);

        // Setup frame
        frame.setContentPane(container);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Ensure SnakeGame gets keyboard focus for key presses
        SwingUtilities.invokeLater(snakeGame::requestFocusInWindow);
    }
}
