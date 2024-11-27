
package Modelo;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;

public class MultiLineTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Llamada al super para obtener el componente de celda básico
        JTextArea textArea = new JTextArea();
        textArea.setText(value != null ? value.toString() : "");
        
        // Configurar el área de texto para ajustarse automáticamente a las líneas
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        // Configurar el alto de la celda basado en el contenido
        int preferredHeight = textArea.getPreferredSize().height;
        if (table.getRowHeight(row) < preferredHeight) {
            table.setRowHeight(row, preferredHeight);
        }

        // Configuración de selección de color
        if (isSelected) {
            textArea.setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            textArea.setBackground(table.getBackground());
            textArea.setForeground(table.getForeground());
        }

        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // margen interno
        return textArea;
    }
}
