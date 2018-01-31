package edu.neu.coe.cyse7200


import org.scalatest.{FlatSpec, Matchers}

class CustomerSpec extends FlatSpec with Matchers {
  behavior of "Address"

  it should "work for Seq[String] containing untrimmed String" in {
    Address(Seq(" 1", "USA", "MA", "21", "S  ", "N  ")) should matchPattern {
      case Address(true, "USA", "MA", 21, true, false) =>
    }
  }

  it should "work for lower case s and n" in {
    Address(Seq(" 1", "USA", "MA", "21", "s  ", "n  ")) should matchPattern {
      case Address(true, "USA", "MA", 21, true, false) =>
    }
  }

  it should "work for 1.0 as a PrimaryAddress" in {
    Address(Seq(" 1.0", "USA", "MA", "21", "s  ", "n  ")) should matchPattern {
      case Address(true, "USA", "MA", 21, true, false) =>
    }
  }

    behavior of "Bank Profile"

  it should "work for a sequence of Strings " in {
    BankProfile(Seq("1","08/10/12","36","N","1")) should matchPattern {
      case BankProfile(true,"08/10/12",36,false,true) =>
    }
  }

  it should "work for lowercase s " in {
    BankProfile(Seq("1","08/10/12","36","s","1")) should matchPattern {
      case BankProfile(true,"08/10/12",36,true,true) =>
    }
  }

  it should "work for Double values instead of Int " in {
    BankProfile(Seq("1.0","08/10/12","36.0","S","1.0")) should matchPattern {
      case BankProfile(true,"08/10/12",36,true,true) =>
    }
  }

  behavior of "Customer Class"

  it should "work for a Sequence of Strings" in {
    Customer("""2015-01-28,1375586,N,ES,H, 35,2015-01-12, 0,      6, 1,,1.0,A,S,N,,KHL,N, 1,29,MALAGA, 1,87218.1,02 - PARTICULARES,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 0, 0,0""".split(""",(?=([^\"]*\"[^\"]*\")*[^\"]*$)""")) should matchPattern {
      case Customer(1375586, 35, "H", 87218.1, 2, 1,
                    Address(true, "ES", "MALAGA", 29, true, false),
                    BankProfile(false, "2015-01-12", 6, false, false)) =>
    }
  }

}