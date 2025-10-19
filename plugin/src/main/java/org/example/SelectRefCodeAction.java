package org.example;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;

public class SelectRefCodeAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {
		Project project = e.getProject();
		if (project == null) return;

		Editor editor = e.getData(CommonDataKeys.EDITOR);
		if (editor == null) return;

		SelectionModel selectionModel = editor.getSelectionModel();
		if (!selectionModel.hasSelection()) {
//			Messages.showInfoMessage(project, "Please select the target style code first.", "No Selection");
			return;
		}

		String selectedText = selectionModel.getSelectedText();
		if (selectedText == null || selectedText.isEmpty()) return;

		// 保存目标风格代码
		ReferenceCodeStorage.getInstance().setReferenceCode(selectedText);
//		Messages.showInfoMessage(project, "Target style code selected.", "Success");
	}
}
