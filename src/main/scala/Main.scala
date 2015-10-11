import scala.collection.mutable

object Main {
  import scala.collection.mutable.Map

  def add (map: Map[Int, Int], count: Int) = {
    for (i <- 0 to count) 
      map.put(i, i)
  }

  def get (map: Map[Int, Int], count: Int) = {
    for (i <- 0 to count)
      map(i)
  }

  def main(args: Array[String]) = {
    val n = 5000000
    var totalAdd = 0L
    var totalGet = 0L
    for (_ <- 1 to 10) {
      val map = Map.empty[Int, Int]
      val (_, addTime) = Util.time { add(map, n) }
      totalAdd += addTime
      val (_, getTime) = Util.time { get(map, n) }
      totalGet += getTime
    }
    println(s"Add: ${totalAdd / 1000000} ms, Get: ${totalGet / 1000000} ms")
  }
}
