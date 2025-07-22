    private void onBroadcastReceived(final Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }

        if (DEBUG) {
            Log.d(TAG, "onBroadcastReceived() called with: intent = [" + intent + "]");
        }

        switch (intent.getAction()) {
            case AudioManager.ACTION_AUDIO_BECOMING_NOISY:
                pause();
                break;
            case ACTION_CLOSE:
                service.destroyPlayerAndStopService();
                break;
            case ACTION_PLAY_PAUSE:
                playPause();
                break;
            case ACTION_PLAY_PREVIOUS:
                playPrevious();
                break;
            case ACTION_PLAY_NEXT:
                playNext();
                break;
            case ACTION_FAST_REWIND:
                fastRewind();
                break;
            case ACTION_FAST_FORWARD:
                fastForward();
                break;
            case ACTION_REPEAT:
                cycleNextRepeatMode();
                break;
            case ACTION_SHUFFLE:
                toggleShuffleModeEnabled();
                break;
            case Intent.ACTION_CONFIGURATION_CHANGED:
                if (DEBUG) {
                    Log.d(TAG, "ACTION_CONFIGURATION_CHANGED received");
                }
                break;
        }

        UIs.call(playerUi -> playerUi.onBroadcastReceived(intent));
    }
