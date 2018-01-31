package edu.neu.coe.cyse7200

import scala.io.Source
import scala.util.Try

/**
  * Created by aadityabhat on 12/7/16.
  */

//Code Skeleton
class Ingest[T: Ingestible] extends (Source => Iterator[Try[T]]) {
  def apply(source: Source): Iterator[Try[T]] = source.getLines.toSeq.drop(1).map(e => implicitly[Ingestible[T]].fromString(e)).iterator
}


trait Ingestible[X] {
  def fromString(w: String): Try[X]
}