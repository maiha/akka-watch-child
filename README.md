## usage

* sbt run
```
[info] Compiling 1 Scala source to /home/maiha/git/maiha/akka-watch-child/target/scala-2.11/classes...
[info] Running Main
watch(true): Terminated(Actor[akka://sys/user/$b/child#1212558989])
[success] Total time: 2 s, completed 2014/09/16 16:25:41
```

## conculusion

A parent actor doesn't watch its child automatically.
