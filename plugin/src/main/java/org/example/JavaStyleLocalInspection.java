package org.example;

import com.intellij.codeInspection.*;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.example.Configuration;
import org.example.controller.Controller;
import org.example.settings.AppSettings;
import org.example.style.InconsistencyInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JavaStyleLocalInspection extends LocalInspectionTool {
	LocalQuickFix quickFix = null;

	protected List<InconsistencyInfo> checkStyle(String codeStr, AppSettings.Language language) {
		Controller controller = new Controller(new Configuration());
		controller.setTargetProgramStyle(CodeStyleManger.getStyle());
		List<InconsistencyInfo> infos = controller.analyzeInconsistency(codeStr, language.name());
		return infos;
	}

	protected void highlightInconsistencies(@NotNull PsiElement element,
										  @NotNull List<InconsistencyInfo> infos,
										  @NotNull ProblemsHolder holder) {
		Project project = element.getProject();
		PsiFile file = element.getContainingFile();
		Document document = PsiDocumentManager.getInstance(project).getDocument(file);
		if (document == null) return;

		int elementStartOffset = element.getTextRange().getStartOffset();
		int elementStartLine = document.getLineNumber(elementStartOffset);

		for (InconsistencyInfo info : infos) {
			try {
				int startLine = elementStartLine + info.getStartRow();
				int endLine = elementStartLine + info.getEndRow();

				if (startLine >= document.getLineCount() || endLine >= document.getLineCount()) continue;

				int startOffset = document.getLineStartOffset(startLine) + info.getStartColumn();
				int endOffset = document.getLineStartOffset(endLine) + info.getEndColumn();
				if (startOffset >= endOffset || endOffset > document.getTextLength()) continue;

				TextRange range = new TextRange(startOffset, endOffset);
				PsiElement target = file.findElementAt(startOffset);
				if (target != null) {
					holder.registerProblem(target, info.getMessage(), ProblemHighlightType.WEAK_WARNING);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
		return new JavaElementVisitor() {

			@Override
			public void visitMethod(@NotNull PsiMethod method) {
				super.visitMethod(method);

				List<InconsistencyInfo> infos = checkStyle(method.getText(), AppSettings.Language.JAVA);
				highlightInconsistencies(method, infos, holder);
			}
		};
	}
}

