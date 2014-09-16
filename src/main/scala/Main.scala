import akka.actor._

object Main {
  class WatchActor(watch: Boolean) extends Actor {
    val child = context.actorOf(Props.empty, "child")

    if (watch) {
      context.watch(child)
    }

    def receive = {
      case "kill" => context.stop(child)
      case t@ Terminated(`child`) => println(s"watch($watch): $t")
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sys")

    for {
      watch <- Seq(false, true)
    } yield {
      val parent = system.actorOf(Props(new WatchActor(watch)))
      parent ! "kill"
    }

    Thread.sleep(1000)
    system.shutdown
  }
}
