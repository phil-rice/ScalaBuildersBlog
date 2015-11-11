package org.validoc.scalaBuilders

object LongTools {
  val hiDivisor = (Int.MaxValue.toLong + 1) * 2
  val loMask = hiDivisor - 1
  def hi(l: Long): Int = (l / hiDivisor).toInt
  def lo(l: Long): Int = (l & loMask).toInt
}

class OttAsLong(val ott: Long) extends AnyVal {
  def toPart = new ValueAndSize(LongTools.hi(ott))
  def fromPart = new ValueAndSize(LongTools.lo(ott))
  override def toString = s"OttAsLong($toPart <== $fromPart)"
}
class ValueAndSize(val int: Int) extends AnyVal {
  def size = int & 7
  def value = int / 8
  override def toString = s"($value/$size)"
}

object ScalaBuilders {
  implicit def asIterator[X](x: LongArrayAndLength) = new Iterator[OttAsLong] {
    var index = 0
    def hasNext = index < x.getSize - 1
    def next = {
      val result = x.get(index)
      index += 1
      new OttAsLong(result)
    }
  }
  def main(args: Array[String]): Unit = {
    val l = new LongArrayAndLength(100)
    l.add(1)
    l.add(2)
    l.add(3)
    l.foreach(println(_))
  }
}
