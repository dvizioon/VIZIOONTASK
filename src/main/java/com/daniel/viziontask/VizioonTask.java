package com.daniel.viziontask;

import com.daniel.viziontask.ui.TaskFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Daniel Estevão
 */
public class VizioonTask {
    public static void main(String[] args) {
        // Inicia a aplicação na thread do Swing
        SwingUtilities.invokeLater(() -> {
            // Cria e exibe a janela principal
            TaskFrame frame = new TaskFrame();
            frame.setVisible(true);
        });
    }
}