import scala.io.Source

object Day1 extends App {

  def requiredFuel1(mass: Long): Long = {
    Math.floorDiv(mass, 3) - 2
  }

  def requiredFuel2(mass: Long): Long = {
    val fuelForMass = requiredFuel1(mass)
    if(fuelForMass > 0) {
      fuelForMass + requiredFuel2(fuelForMass)
    } else {
      Math.max(0, fuelForMass)
    }
  }

  def parseInput(): Vector[Long] = {
    Source.fromResource("Day1Input.txt").getLines().map(_.toLong).toVector
  }

  def part1: Long = parseInput().map(requiredFuel1).sum
  def part2: Long = parseInput().map(requiredFuel2).sum

  println(part1)
  println(part2)
}