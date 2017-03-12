package simulation.util

import scala.collection.mutable

/**
  * Created by salim on 3/10/2017.
  */
case class Counter[T]() {
  lazy val state: mutable.Map[T, Int] = mutable.HashMap[T, Int]()

  def apply(i: T): Int = state.getOrElse(i, 0)

  def count(i: T): Unit = {
    val newCount = 1 + this (i)
    state += (i -> newCount)
  }
}
