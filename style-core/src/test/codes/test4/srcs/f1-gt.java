        @Override
        public void onTextTracksChanged(@NonNull final Tracks currentTracks) {
            super.onTextTracksChanged(currentTracks);

            final boolean trackTypeTextSupported = !currentTracks.containsType(C.TRACK_TYPE_TEXT)
            || currentTracks.isTypeSupported(C.TRACK_TYPE_TEXT, false);

            if (getPlayer().getTrackSelector().getCurrentMappedTrackInfo() == null
            || !trackTypeTextSupported) {
                binding.captionTextView.setVisibility(View.GONE);
                return;
            }

            // Extract all loaded languages
            final List<Tracks.Group> textTracks = currentTracks.getGroups().stream().filter(trackGroupInfo -> C.TRACK_TYPE_TEXT == trackGroupInfo.getType()).collect(Collectors.toList());

            final List<String> availableLanguages = textTracks.stream().map(Tracks.Group::getMediaTrackGroup).filter(textTrack -> textTrack.length > 0).map(textTrack -> textTrack.getFormat(0).language).collect(Collectors.toList());

            // Find selected text track
            final Optional<Format> selectedTracks = textTracks.stream().filter(Tracks.Group::isSelected).filter(info -> info.getMediaTrackGroup().length >= 1).map(info -> info.getMediaTrackGroup().getFormat(0)).findFirst();

            // Build UI
            buildCaptionMenu(availableLanguages);

            if (player.getTrackSelector().getParameters().getRendererDisabled(player.getCaptionRendererIndex()) || selectedTracks.isEmpty()) {
                binding.captionTextView.setText(R.string.caption_none);
            } else {
                binding.captionTextView.setText(selectedTracks.get().language);
            }

            binding.captionTextView.setVisibility(availableLanguages.isEmpty() ? View.GONE:View.VISIBLE);
        }
