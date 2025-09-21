private ArrayList<Object> getSpecialItems() {
  synchronized (DownloadManager.this) {

    ArrayList<Mission> pending = new ArrayList<>(mMissionsPending);

    ArrayList<Mission> finished = new ArrayList<>(mMissionsFinished);

    List<Mission> remove = new ArrayList<>(hidden);
    // hide missions (if required)
    remove.removeIf(mission -> pending.remove(mission) || finished.remove(mission));
    int fakeTotal = pending.size();
    if (fakeTotal > 0) {
      fakeTotal++;
    }
    fakeTotal += finished.size();
    if (finished.size() > 0) {
      fakeTotal++;
    }

    ArrayList<Object> list = new ArrayList<>(fakeTotal);
    if (pending.size() > 0) {
      list.add(PENDING);
      list.addAll(pending);
    }

    if (finished.size() > 0) {
      list.add(FINISHED);
      list.addAll(finished);
    }
    hasFinished = finished.size() > 0;
    return list;
  }
}
