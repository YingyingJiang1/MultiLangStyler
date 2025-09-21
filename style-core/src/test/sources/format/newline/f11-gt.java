public void updateMission(Mission mission) {
    ContentValues values = getValuesOfMission(Objects.requireNonNull(mission));
    SQLiteDatabase database = getWritableDatabase();
    String ts = String.valueOf(mission.timestamp);
    int rowsAffected;

    if (mission instanceof FinishedMission) {
        if (mission.storage.isInvalid()) {
            rowsAffected = database.update(FINISHED_TABLE_NAME, values, KEY_TIMESTAMP + " = ?", new String[]{ts});
        } else {
            rowsAffected = database.update(FINISHED_TABLE_NAME, values, KEY_PATH + " = ?", new String[]{mission.storage.getUri().toString()});
        }
    } else {
        throw new UnsupportedOperationException("DownloadMission");
    }

    if (rowsAffected != 1) {
        Log.e("FinishedMissionStore", "Expected 1 row to be affected by update but got " + rowsAffected);
    }
}
