package org.example;


import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.example.settings.AppSettings;
import org.jetbrains.annotations.NotNull;

public class SetStyleDirectoryAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
		if (file != null && file.isDirectory()) {
			String dirPath = file.getPath();

			AppSettings.StyleSource source = new AppSettings.StyleSource(
					AppSettings.StyleSourceType.SPECIFIC_DIRECTORY,
					dirPath
			);
			AppSettings.getInstance().getState().styleSource = source;

			Notifications.Bus.notify(new Notification(
					"Styler",
					"Style directory set",
					"Now using: " + dirPath,
					NotificationType.INFORMATION
			));

		}
	}

	@Override
	public void update(@NotNull AnActionEvent e) {
		VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
		e.getPresentation().setEnabledAndVisible(file != null && file.isDirectory());
	}

	@Override
	public @NotNull ActionUpdateThread getActionUpdateThread() {
		return ActionUpdateThread.BGT;
	}
}


