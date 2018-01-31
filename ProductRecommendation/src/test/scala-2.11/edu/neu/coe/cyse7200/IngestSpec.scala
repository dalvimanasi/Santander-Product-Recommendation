package edu.neu.coe.cyse7200

import org.scalatest.{FlatSpec, Matchers}
import scala.io.Source
import scala.util._

/**
  * Created by aadityabhat on 12/9/16.
  */
class IngestSpec extends FlatSpec with Matchers{
  behavior of "ingest"

  it should "work for Double" in {
    trait IngestibleDouble extends Ingestible[Double] {
      def fromString(w: String): Try[Double] = Try(w.toDouble)
    }
    implicit object IngestibleDouble extends IngestibleDouble
    val source = Source.fromChars(Array('x', '\n', '4','.', '2'))
    val ingester = new Ingest[Double]()
    val xys: Iterator[Try[Double]] = ingester(source)
    for(x <- xys) x should matchPattern{ case Success(4.2) => }
  }
}
