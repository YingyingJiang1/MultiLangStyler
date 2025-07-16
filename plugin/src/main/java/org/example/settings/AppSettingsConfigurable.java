package org.example.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

/**
 * Provides controller functionality for application settings.
 */
final class AppSettingsConfigurable implements Configurable {

	private AppSettingsComponent mySettingsComponent;

	// A default constructor with no arguments is required because
	// this implementation is registered as an applicationConfigurable


	public AppSettingsConfigurable() {
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@Override
	public String getDisplayName() {
		return "Styler Settings";
	}

	@Override
	public JComponent getPreferredFocusedComponent() {
		return mySettingsComponent.getPreferredFocusedComponent();
	}

	@Nullable
	@Override
	public JComponent createComponent() {
		mySettingsComponent = new AppSettingsComponent();
		return mySettingsComponent.getPanel();
	}

	@Override
	public boolean isModified() {
		AppSettings.State state =
				Objects.requireNonNull(AppSettings.getInstance().getState());
		return !Objects.equals(state.styleSource, mySettingsComponent.getStyleSource());
	}

	@Override
	public void apply() {
		AppSettings.State state =
				Objects.requireNonNull(AppSettings.getInstance().getState());
		state.styleSource = mySettingsComponent.getStyleSource();
	}

	@Override
	public void reset() {
		AppSettings.State state =
				Objects.requireNonNull(AppSettings.getInstance().getState());
		mySettingsComponent.setStyleSource(state.styleSource);
	}

	@Override
	public void disposeUIResources() {
		mySettingsComponent = null;
	}

	public AppSettingsComponent getMySettingsComponent() {
		return mySettingsComponent;
	}
}
