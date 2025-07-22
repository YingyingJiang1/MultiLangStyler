    public static void openVideoDetailFragment(@NonNull final Context context,
                                               @NonNull final FragmentManager fragmentManager,
                                               final int serviceId,
                                               @Nullable final String url,
                                               @NonNull final String title,
                                               @Nullable final PlayQueue playQueue,
                                               final boolean switchingPlayers) {

        final boolean autoPlay;
        @Nullable final PlayerType playerType = PlayerHolder.getInstance().getType();
        if (playerType == null) {
            // no player open
            autoPlay = PlayerHelper.isAutoplayAllowedByUser(context);
        } else if (switchingPlayers) {
            // switching player to main player
            autoPlay = PlayerHolder.getInstance().isPlaying(); // keep play/pause state
        } else if (playerType == PlayerType.MAIN) {
            // opening new stream while already playing in main player
            autoPlay = PlayerHelper.isAutoplayAllowedByUser(context);
        } else {
            // opening new stream while already playing in another player
            autoPlay = false;
        }

        final RunnableWithVideoDetailFragment onVideoDetailFragmentReady = detailFragment -> {
            expandMainPlayer(detailFragment.requireActivity());
            detailFragment.setAutoPlay(autoPlay);
            if (switchingPlayers) {
                // Situation when user switches from players to main player. All needed data is
                // here, we can start watching (assuming newQueue equals playQueue).
                // Starting directly in fullscreen if the previous player type was popup.
                detailFragment.openVideoPlayer(playerType == PlayerType.POPUP
                        || PlayerHelper.isStartMainPlayerFullscreenEnabled(context));
            } else {
                detailFragment.selectAndLoadVideo(serviceId, url, title, playQueue);
            }
            detailFragment.scrollToTop();
        };

        final Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_player_holder);
        if (fragment instanceof VideoDetailFragment && fragment.isVisible()) {
            onVideoDetailFragmentReady.run((VideoDetailFragment) fragment);
        } else {
            // Specify no url here, otherwise the VideoDetailFragment will start loading the
            // stream automatically if it's the first time it is being opened, but then
            // onVideoDetailFragmentReady will kick in and start another loading process.
            // See VideoDetailFragment.wasCleared() and its usage in doInitialLoadLogic().
            final VideoDetailFragment instance = VideoDetailFragment
                    .getInstance(serviceId, null, title, playQueue);
            instance.setAutoPlay(autoPlay);

            defaultTransaction(fragmentManager)
                    .replace(R.id.fragment_player_holder, instance)
                    .runOnCommit(() -> onVideoDetailFragmentReady.run(instance))
                    .commit();
        }
    }
