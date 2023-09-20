package view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfomationPanel extends JPanel{
	private CombatView cbView;
	private JTextArea showArea;
	private GroupLayout panelLayout;
	private JTextArea inputArea;
	private JScrollPane showPane;

	public InfomationPanel(CombatView cbView) {
		this.cbView = cbView;
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));
		init();
		addEnterListenerToTextArea();
	}
	
	public void init() {
		// Create message area
		showArea = new JTextArea();
		showArea.setEditable(false);

        // Create scroll pane
        showPane = new JScrollPane(showArea);
        showPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Create components
        inputArea = new JTextArea(4, 20);
        
        panelLayout = new GroupLayout(this);
		this.setLayout(panelLayout);

//		panelLayout.setAutoCreateGaps(true);
//		panelLayout.setAutoCreateContainerGaps(true);

		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
						.addGroup(panelLayout.createParallelGroup()
								.addComponent(showPane)
								.addComponent(inputArea))
		);
		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
						.addComponent(showPane, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputArea, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		);
		
	}
	
	public void addEnterListenerToTextArea() {
		inputArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.isShiftDown()) {
                        inputArea.append("\n");
                    } else {
                        cbView.sendMessage(cbView.getPlayerName()+": "+inputArea.getText());
                    	inputArea.setText("");
                        e.consume();
                    }
                }
            }
        });
	}

	public JTextArea getShowArea() {
		return showArea;
	}
	
}
