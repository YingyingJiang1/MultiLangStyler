package org.example;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.example.controller.Controller;
import org.example.style.ProgramStyle;
import org.jetbrains.annotations.NotNull;

public class ApplyStyleAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getProject();
		PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);

		if (project == null || psiFile == null) {
			return;
		}

		VirtualFile file = psiFile.getVirtualFile();
		if (file == null) return;

		ProgramStyle style = CodeStyleManger.getStyle();
		if (style == null) {
			Messages.showInfoMessage(
					project,
					"No style was found. Please select a reference code snippet or configure the project style first!",
					"Reference Style Not Found"
			);
			return;
		}

		Editor editor = e.getData(CommonDataKeys.EDITOR);
		if (editor == null) return;
		SelectionModel selectionModel = editor.getSelectionModel();
		String code = null;
		int[] offset = {0, 0};
		if (selectionModel.hasSelection()) {
			// 对选中代码片段迁移
			code = selectionModel.getSelectedText();
			offset[0] = selectionModel.getSelectionStart();
			offset[1] = selectionModel.getSelectionEnd();
			selectionModel.removeSelection();
		} else {
			// 对整个文件迁移
			code = psiFile.getText();
			offset[1] = psiFile.getTextLength();
		}


		String filePath = file.getPath();
		Configuration conf = new Configuration();
		Controller controller = new Controller(conf);
		controller.setTargetProgramStyle(style);
		String result = controller.applyStyle(code, style, psiFile.getLanguage().getDisplayName());
		replaceString(project, file, code, result, offset);


//		Messages.showInfoMessage(project, "Fixed " + infos.size() + " style inconsistencies.", "Style Fix Complete");
	}

	@Override
	public void update(@NotNull AnActionEvent e) {
		e.getPresentation().setEnabledAndVisible(e.getData(CommonDataKeys.PSI_FILE) != null);
	}

	@Override
	public @NotNull ActionUpdateThread getActionUpdateThread() {
		return ActionUpdateThread.BGT;
	}

	private void replaceString(Project project, VirtualFile file, String original, String newCode, int[] offset) {
		// TODO: optimize efficiency
		WriteCommandAction.runWriteCommandAction(project, () -> {
			Document document = FileDocumentManager.getInstance().getDocument(file);
			if (document != null) {
				document.replaceString(offset[0], offset[1], newCode);
			}
		});
	}
}

