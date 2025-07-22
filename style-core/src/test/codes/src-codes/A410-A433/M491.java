    @SuppressLint("SwitchIntDef") // only fit, fill and zoom are supported by NewPipe
    @ResizeMode
    public static int nextResizeModeAndSaveToPrefs(final Player player,
                                                   @ResizeMode final int resizeMode) {
        final int newResizeMode;
        switch (resizeMode) {
            case AspectRatioFrameLayout.RESIZE_MODE_FIT:
                newResizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL;
                break;
            case AspectRatioFrameLayout.RESIZE_MODE_FILL:
                newResizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM;
                break;
            case AspectRatioFrameLayout.RESIZE_MODE_ZOOM:
            default:
                newResizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT;
                break;
        }

        // save the new resize mode so it can be restored in a future session
        player.getPrefs().edit().putInt(
                player.getContext().getString(R.string.last_resize_mode), newResizeMode).apply();
        return newResizeMode;
    }
