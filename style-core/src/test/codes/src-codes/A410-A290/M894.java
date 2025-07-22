    public static RequestCreator loadScaledDownThumbnail(final Context context,
                                                         @NonNull final List<Image> images) {
        // scale down the notification thumbnail for performance
        return PicassoHelper.loadThumbnail(images)
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(final Bitmap source) {
                        if (DEBUG) {
                            Log.d(TAG, "Thumbnail - transform() called");
                        }

                        final float notificationThumbnailWidth = Math.min(
                                context.getResources()
                                        .getDimension(R.dimen.player_notification_thumbnail_width),
                                source.getWidth());

                        final Bitmap result = BitmapCompat.createScaledBitmap(
                                source,
                                (int) notificationThumbnailWidth,
                                (int) (source.getHeight()
                                        / (source.getWidth() / notificationThumbnailWidth)),
                                null,
                                true);

                        if (result == source || !result.isMutable()) {
                            // create a new mutable bitmap to prevent strange crashes on some
                            // devices (see #4638)
                            final Bitmap copied = BitmapCompat.createScaledBitmap(
                                    source,
                                    (int) notificationThumbnailWidth - 1,
                                    (int) (source.getHeight() / (source.getWidth()
                                            / (notificationThumbnailWidth - 1))),
                                    null,
                                    true);
                            source.recycle();
                            return copied;
                        } else {
                            source.recycle();
                            return result;
                        }
                    }

                    @Override
                    public String key() {
                        return PLAYER_THUMBNAIL_TRANSFORMATION_KEY;
                    }
                });
    }
