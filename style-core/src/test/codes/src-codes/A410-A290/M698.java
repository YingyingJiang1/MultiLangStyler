    @Override
    public void handleResult(@NonNull final ChannelInfo result) {
        super.handleResult(result);
        currentInfo = result;
        setInitialData(result.getServiceId(), result.getOriginalUrl(), result.getName());

        if (ImageStrategy.shouldLoadImages() && !result.getBanners().isEmpty()) {
            PicassoHelper.loadBanner(result.getBanners()).tag(PICASSO_CHANNEL_TAG)
                    .into(binding.channelBannerImage);
        } else {
            // do not waste space for the banner, if the user disabled images or there is not one
            binding.channelBannerImage.setImageDrawable(null);
        }

        PicassoHelper.loadAvatar(result.getAvatars()).tag(PICASSO_CHANNEL_TAG)
                .into(binding.channelAvatarView);
        PicassoHelper.loadAvatar(result.getParentChannelAvatars()).tag(PICASSO_CHANNEL_TAG)
                .into(binding.subChannelAvatarView);

        binding.channelTitleView.setText(result.getName());
        binding.channelSubscriberView.setVisibility(View.VISIBLE);
        if (result.getSubscriberCount() >= 0) {
            binding.channelSubscriberView.setText(Localization
                    .shortSubscriberCount(activity, result.getSubscriberCount()));
        } else {
            binding.channelSubscriberView.setText(R.string.subscribers_count_not_available);
        }

        if (!TextUtils.isEmpty(currentInfo.getParentChannelName())) {
            binding.subChannelTitleView.setText(String.format(
                    getString(R.string.channel_created_by),
                    currentInfo.getParentChannelName())
            );
            binding.subChannelTitleView.setVisibility(View.VISIBLE);
            binding.subChannelAvatarView.setVisibility(View.VISIBLE);
        }

        updateRssButton();

        channelContentNotSupported = false;
        for (final Throwable throwable : result.getErrors()) {
            if (throwable instanceof ContentNotSupportedException) {
                channelContentNotSupported = true;
                showContentNotSupportedIfNeeded();
                break;
            }
        }

        disposables.clear();
        if (subscribeButtonMonitor != null) {
            subscribeButtonMonitor.dispose();
        }

        updateTabs();
        updateSubscription(result);
        monitorSubscription(result);
    }
