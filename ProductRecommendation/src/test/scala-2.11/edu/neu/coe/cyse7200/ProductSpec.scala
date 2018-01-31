package edu.neu.coe.cyse7200

import org.scalatest.{FlatSpec, Matchers}
import scala.io.Source
import scala.util._

class ProductSpec extends FlatSpec with Matchers {
  behavior of "Product"

  it should "work for a Sequence of Strings with no missing values" in {
    Product("""2015-01-28,1375586,N,ES,H, 35,2015-01-12, 0,6, 1,,1.0,A,S,N,,KHL,N, 1,29,MALAGA, 1,87218.1,02 - PARTICULARES,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 0, 0,0""".split(""",(?=([^\"]*\"[^\"]*\")*[^\"]*$)""")) should matchPattern {
      case Product(1375586,"2015-01-28" ,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false, false, false,false) =>
    }
  }

  it should "work for a Sequence of Strings of Decimal instead of Int" in {
    Product("""2015-01-28,1375586,N,ES,H, 35,2015-01-12, 0,      6, 1,,1.0,A,S,N,,KHL,N, 1,29,MALAGA, 1,87218.1,02 - PARTICULARES,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.0,0.0,0""".split(""",(?=([^\"]*\"[^\"]*\")*[^\"]*$)""")) should matchPattern {
      case Product(1375586,"2015-01-28" ,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false, false, false,false) =>
    }
  }

  it should "work for a Sequence of untrimmed Strings" in {
    Product("""2015-01-28,     1375586,N,ES,H, 35,2015-01-12, 0,      6, 1,,1.0,A,S,N,,KHL,N, 1,29,MALAGA, 1,87218.1,02 - PARTICULARES, 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0.0,0.0,0""".split(""",(?=([^\"]*\"[^\"]*\")*[^\"]*$)""")) should matchPattern {
      case Product(1375586,"2015-01-28" ,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false, false, false,false) =>
    }
  }
}