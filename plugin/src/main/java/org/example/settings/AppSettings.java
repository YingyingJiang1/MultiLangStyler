package org.example.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * Global plugin settings (Application-level).
 */
@State(
		name = "org.example.styler.AppSettings",
		storages = @Storage("stylerPluginSettings.xml")
)
public final class AppSettings implements PersistentStateComponent<AppSettings.State> {

	private State state = new State();

	public static AppSettings getInstance() {
		return ApplicationManager.getApplication().getService(AppSettings.class);
	}

	@Override
	public @NotNull State getState() {
		return state;
	}

	public void loadState(@NotNull State state) {
		this.state = state;
	}



	public static class State {
		/**
		 * 当前选定的风格来源方式。
		 */
		public StyleSource styleSource = new StyleSource();
		public Language language = Language.JAVA;
		// Default action is modify the file directly, when `override` is false, a copy of file will be created.
		public boolean override = false;
		public String styleOutputPath = "";


		public void loadState(State state) {
			styleSource = state.styleSource;
		}
	}

	/**
	 * 可选的风格来源。
	 */
	public enum StyleSourceType {
		MOST_COMMON_AUTHOR,
		SPECIFIC_AUTHOR,
		SPECIFIC_DIRECTORY,
		STYLE_CONFIG_FILE
		;

		public String getName() {
			return switch (this) {
				case MOST_COMMON_AUTHOR -> "Most common author";
				case SPECIFIC_AUTHOR -> "Specific author";
				case SPECIFIC_DIRECTORY -> "Specific directory";
				case STYLE_CONFIG_FILE -> "Style configuration file";
			};
		}

	}

	public static class StyleSource {
		private StyleSourceType styleSourceType;
		private String parameter;

		public StyleSource() {
			this.styleSourceType = StyleSourceType.MOST_COMMON_AUTHOR;
			this.parameter = null;
		}

		public StyleSource(StyleSourceType styleSourceType, String parameter) {
			this.styleSourceType = styleSourceType;
			this.parameter = parameter;
		}


		public List<String> getSplitParameters() {
			return List.of(parameter.split(";"));
		}

		public String getParameter() {
			return parameter;
		}

		public StyleSourceType getStyleSourceType() {
			return styleSourceType;
		}

		public void setStyleSourceType(StyleSourceType styleSourceType) {
			this.styleSourceType = styleSourceType;
		}

		public void setParameter(String parameter) {
			this.parameter = parameter;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			StyleSource that = (StyleSource) o;
			return styleSourceType == that.styleSourceType && Objects.equals(parameter, that.parameter);
		}

		@Override
		public int hashCode() {
			return Objects.hash(styleSourceType, parameter);
		}
	}

	public enum Language {
		JAVA,
		CPP
		;
	}
}
