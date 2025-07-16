package org.example.settings;

import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.example.settings.AppSettings.StyleSource;
import static org.example.settings.AppSettings.StyleSourceType;

/**
 * 封装 StyleSource UI 选择控件和参数输入框。
 */
public class StyleSourceComponent extends JPanel{
	private final Map<StyleSourceType, JRadioButton> radioButtons = new HashMap<>();
	private final Map<StyleSourceType, JTextField> textFields = new HashMap<>();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public StyleSourceComponent() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = JBUI.insets(2);
		gbc.weightx = 1.0;

		// 初始化各个选项和对应输入框
		int row = 0;
		addOption(StyleSourceType.MOST_COMMON_AUTHOR, StyleSourceType.MOST_COMMON_AUTHOR.getName(), false,  gbc, row++);
		addOption(StyleSourceType.SPECIFIC_AUTHOR, StyleSourceType.SPECIFIC_AUTHOR.getName(), true, gbc, row++);
		addOption(StyleSourceType.SPECIFIC_DIRECTORY, StyleSourceType.SPECIFIC_DIRECTORY.getName(), true, gbc, row++);
		addOption(StyleSourceType.STYLE_CONFIG_FILE, StyleSourceType.STYLE_CONFIG_FILE.getName(), true, gbc, row++);

		// 默认选中MOST_COMMON_AUTHOR
		radioButtons.get(StyleSourceType.MOST_COMMON_AUTHOR).setSelected(true);
	}

	private void addOption(StyleSourceType type, String label, boolean hasTextField, GridBagConstraints gbc, int row) {
		JRadioButton radio = new JRadioButton(label);
		radioButtons.put(type, radio);
		buttonGroup.add(radio);

		JTextField textField = null;
		if (hasTextField) {
			textField = new JTextField(15);
			textField.setEnabled(false);
			textField.setVisible(false);
		}
		textFields.put(type, textField);

		gbc.gridy = row;
		gbc.gridx = 0;
		add(radio, gbc);

		if (hasTextField) {
			gbc.gridx = 1;
			add(textField, gbc);
		}

		radio.addActionListener(e -> select());
	}

	// 设置选中风格来源和对应输入内容
	public void setSelectedStyleSource(StyleSource styleSource) {
		if (styleSource == null) return;
		StyleSourceType type = styleSource.getStyleSourceType();
		radioButtons.get(type).setSelected(true);
		JTextField tf = textFields.get(type);
		if (tf != null) {
			tf.setText(styleSource.getParameter());
		}

		select();
	}

	private void select() {
		for (StyleSourceType type : StyleSourceType.values()) {
			JRadioButton radio = radioButtons.get(type);
			JTextField textField = textFields.get(type);
			if (radio.isSelected() && textField != null) {
				textField.setVisible(true);
				textField.setEnabled(true);

			} else {
				// 未选中按钮对应的输入框都隐藏禁用
				if (textField != null) {
					textField.setVisible(false);
					textField.setEnabled(false);
				}
			}
		}

		// 重新布局，确保组件显示正确
		revalidate();
		repaint();
	}

	/**
	 * 获取用户选择的 StyleSource，包括参数。
	 */
	public StyleSource getSelected() {
		StyleSourceType selected = null;
		for (StyleSourceType type : StyleSourceType.values()) {
			if (radioButtons.get(type).isSelected()) {
				selected = type;
			}
		}

		JTextField tf = textFields.get(selected);
		if (tf != null) {
			return new StyleSource(selected, tf.getText());
		}
		return new StyleSource(selected, null);
	}

}
