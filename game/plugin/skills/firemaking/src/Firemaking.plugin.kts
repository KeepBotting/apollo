import Log.Companion.isLog
import Log.Companion.isTinderbox
import org.apollo.game.model.entity.EquipmentConstants
import org.apollo.game.model.event.impl.LoginEvent
import org.apollo.game.message.impl.ItemOnItemMessage
import org.apollo.game.message.impl.ItemOptionMessage

on { ItemOnItemMessage::class }
    .where { (id.isTinderbox() && targetId.isLog() || id.isLog() && targetId.isTinderbox()) }
    .then { player ->
      val logId = if (id.isLog()) id else targetId
      if (logId.isLog()) {
        val log = Log.findById(logId)  
      }
      player.startAction(FiremakingAction(player, log))
      terminate()
    }
