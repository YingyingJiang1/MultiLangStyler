        @SuppressWarnings("unchecked")
        @Override
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription<T> f = (QueueSubscription<T>) s;

                    int m = f.requestFusion(QueueSubscription.ANY | QueueSubscription.BOUNDARY);

                    if (m == QueueSubscription.SYNC) {
                        sourceMode = m;
                        queue = f;
                        done = true;
                        parent.drain();
                        return;
                    }
                    if (m == QueueSubscription.ASYNC) {
                        sourceMode = m;
                        queue = f;
                        s.request(prefetch);
                        return;
                    }
                }

                queue = new SpscArrayQueue<>(prefetch);

                s.request(prefetch);
            }
        }
