    @Override
    public void onBroadcastReceived(final Intent intent) {
        super.onBroadcastReceived(intent);
        if (Intent.ACTION_CONFIGURATION_CHANGED.equals(intent.getAction())) {
            // Close it because when changing orientation from portrait
            // (in fullscreen mode) the size of queue layout can be larger than the screen size
            closeItemsList();
        } else if (ACTION_PLAY_PAUSE.equals(intent.getAction())) {
            // Ensure that we have audio-only stream playing when a user
            // started to play from notification's play button from outside of the app
            if (!fragmentIsVisible) {
                onFragmentStopped();
            }
        } else if (VideoDetailFragment.ACTION_VIDEO_FRAGMENT_STOPPED.equals(intent.getAction())) {
            fragmentIsVisible = false;
            onFragmentStopped();
        } else if (VideoDetailFragment.ACTION_VIDEO_FRAGMENT_RESUMED.equals(intent.getAction())) {
            // Restore video source when user returns to the fragment
            fragmentIsVisible = true;
            player.useVideoSource(true);

            // When a user returns from background, the system UI will always be shown even if
            // controls are invisible: hide it in that case
            if (!isControlsVisible()) {
                hideSystemUIIfNeeded();
            }
        }
    }
