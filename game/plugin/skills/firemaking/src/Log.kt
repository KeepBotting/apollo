enum class Log(val id: Int, val level: Int, val xp: Double) {
    NORMAL(1511, 1, 40.0),
    ACHEY(2862, 1, 40.0),
    OAK(1521, 15, 60.0),
    WILLOW(1519, 30, 90.0),
    TEAK(6333, 35, 105.0),
    MAPLE(1517, 45, 135.0),
    MAHOGANY(6332, 50, 157.5),
    YEW(1515, 60, 202.5),
    MAGIC(1513, 75, 303.8);

    companion object {
      val Logs = Log.values()
      val logIds = Log.values().associateBy(Log::id)

      fun findById(id: Int): Log = Logs.find { log -> log.id == id}
      fun Int.isLog(): Boolean = id in logIds
      fun Int.isTinderbox(): Boolean = id == 980
    }
}
