import java.util.Random

val r = new Random()

val results = (0 until 2).map(
  (_) => r.nextInt(6) + 1
).toList

val total = results.sum

val same = results.toSet.size == 1