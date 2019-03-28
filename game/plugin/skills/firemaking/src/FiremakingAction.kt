import org.apollo.game.action.AsyncAction
import org.apollo.game.action.ActionBlock
import org.apollo.game.model.entity.Player
import org.apollo.game.plugin.api.Definitions
import org.apollo.game.plugin.api.firemaking
import org.apollo.util.LanguageUtil

class FiremakingAction(val player: Player, val log: Log?) : AsyncAction<Player>(1, true, player) {
    override fun action(): ActionBlock = {
      if (player.firemaking.current < log!!.level) {
        player.sendMessage("You need a firemaking level of ${log!!.level} to burn this log.")
        stop()
      }

      // this will have to be rechecked each "attempt"
      if (!player.inventory.contains(590)) {
        player.sendMessage("You need need a tinderbox first.")
        stop()
      }
   }
}