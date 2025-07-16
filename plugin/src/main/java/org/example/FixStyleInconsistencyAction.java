package org.example;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.example.Configuration;
import org.example.controller.Controller;
import org.example.settings.AppSettings;
import org.jetbrains.annotations.NotNull;

public class FixStyleInconsistencyAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getProject();
		PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);

		if (project == null || psiFile == null) {
			return;
		}

		VirtualFile file = psiFile.getVirtualFile();
		if (file == null) return;

		String filePath = file.getPath();
		Configuration conf = new Configuration();
		conf.setSrc(filePath);
		conf.setOverrideSource(AppSettings.getInstance().getState().override);
		Controller controller = new Controller(conf);
		controller.setTargetProgramStyle(CodeStyleManger.getStyle());

		String code = controller.applyStyle(conf.applicationCollection).replace("\r\n", "\n");
		// 将文件内容替换为code
		WriteCommandAction.runWriteCommandAction(project, () -> {
			Document document = FileDocumentManager.getInstance().getDocument(file);
			if (document != null) {
				document.setText(code);
			}
		});


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
}

