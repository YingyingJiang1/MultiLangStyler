package org.example.settings;

import javax.swing.*;
import java.awt.*;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class AppSettingsComponent {

	private final JPanel mainPanel;
	private final StyleSourceComponent styleSourceComponent;

	public AppSettingsComponent() {
		this.mainPanel = new JPanel(new BorderLayout());;
		styleSourceComponent = new StyleSourceComponent();
		mainPanel.add(styleSourceComponent, BorderLayout.NORTH);
	}

	public JPanel getPanel() {
		return mainPanel;
	}

	public AppSettings.StyleSource getStyleSource() {
		return styleSourceComponent.getSelected();
	}

	public JComponent getPreferredFocusedComponent() {
		return mainPanel;
	}

	public void setStyleSource(AppSettings.StyleSource styleSource) {
		styleSourceComponent.setSelectedStyleSource(styleSource);
	}
}
