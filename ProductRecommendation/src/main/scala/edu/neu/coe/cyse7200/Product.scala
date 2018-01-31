package edu.neu.coe.cyse7200


/**
  *Product class contains product profile for a customer at a given date, the records are updated monthly.
  * @param customercode Unique Customer ID
  * @param date Date for the record
  * @param savingAcc savings account
  * @param gaurantees gaurantees
  * @param currentAcc current Account
  * @param derivedAcc derived account
  * @param payrollAcc payroll account
  * @param juniorAcc  junior account
  * @param moreParticularAcc more particular account
  * @param particularAcc particular account
  * @param particularPlusAccion particular plus account
  * @param shorttermDeposit shortterm deposit
  * @param medtermDeposit medium term deposits
  * @param longtermDeposit long term deposits
  * @param eAccount e-Account
  * @param funds funds
  * @param mortgage mortgage
  * @param pensionPlan plan pension
  * @param loan loan
  * @param taxes taxes
  * @param creditCard credit card
  * @param securities securities
  * @param homeAcc home account
  * @param payrollNomina nominal payroll
  * @param pensionNomina nominal pension
  * @param directDebit direct debit
  */


case class Product(customercode:Int,date:String, savingAcc:Boolean, gaurantees:Boolean, currentAcc:Boolean, derivedAcc:Boolean, payrollAcc:Boolean, juniorAcc:Boolean, moreParticularAcc:Boolean, particularAcc:Boolean, particularPlusAccion:Boolean, shorttermDeposit:Boolean, medtermDeposit:Boolean, longtermDeposit:Boolean, eAccount:Boolean, funds:Boolean, mortgage:Boolean, pensionPlan:Boolean, loan:Boolean, taxes:Boolean, creditCard:Boolean, securities:Boolean, homeAcc:Boolean, payrollNomina:Boolean, pensionNomina:Boolean, directDebit:Boolean){
  override def toString: String = s"$customercode,$date,$savingAcc,$gaurantees,$currentAcc,$derivedAcc,$payrollAcc,$juniorAcc,$moreParticularAcc,$particularAcc,$particularPlusAccion,$shorttermDeposit,$medtermDeposit,$longtermDeposit,$eAccount,$funds,$mortgage,$pensionPlan,$loan,$taxes,$creditCard,$securities,$homeAcc,$payrollNomina,$pensionNomina,$directDebit"
}

object Product extends App{

  def intToBool(num: Int):Boolean = num match {
    case 1 => true
    case 0 => false
    case _ => throw new Exception()
  }

  def apply(splitRow:Seq[String]):Product={

    val date = splitRow.head.replace(" ","")

    val customerCode = splitRow(1).replace(" ","").toDouble.toInt

    val savingAcc = intToBool (splitRow(24).replace(" ","").toDouble.toInt)
    val gaurantees=intToBool(splitRow(25).replace(" ","").toDouble.toInt)
    val currentAcc=intToBool(splitRow(26).replace(" ","").toDouble.toInt)
    val derivedAcc=intToBool (splitRow(27).replace(" ","").toDouble.toInt)
    val payrollAcc=intToBool (splitRow(28).replace(" ","").toDouble.toInt)
    val juniorAcc=intToBool (splitRow(29).replace(" ","").toDouble.toInt)
    val moreParticularAcc= intToBool (splitRow(30).replace(" ","").toDouble.toInt)
    val particularAcc= intToBool (splitRow(31).replace(" ","").toDouble.toInt)
    val particularPlusAccion= intToBool (splitRow(32).replace(" ","").toDouble.toInt)
    val shorttermDeposit= intToBool (splitRow(33).replace(" ","").toDouble.toInt)
    val medtermDeposit= intToBool (splitRow(34).replace(" ","").toDouble.toInt)
    val longtermDeposit= intToBool (splitRow(35).replace(" ","").toDouble.toInt)
    val eAccount= intToBool (splitRow(36).replace(" ","").toDouble.toInt)
    val funds= intToBool (splitRow(37).replace(" ","").toDouble.toInt)
    val mortgage= intToBool (splitRow(38).replace(" ","").toDouble.toInt)
    val pensionPlan= intToBool (splitRow(39).replace(" ","").toDouble.toInt)
    val loan= intToBool (splitRow(40).replace(" ","").toDouble.toInt)
    val taxes= intToBool (splitRow(41).replace(" ","").toDouble.toInt)
    val creditCard= intToBool (splitRow(42).replace(" ","").toDouble.toInt)
    val securities= intToBool (splitRow(43).replace(" ","").toDouble.toInt)
    val homeAcc= intToBool(splitRow(44).replace(" ","").toDouble.toInt)
    val payrollNomina= intToBool(splitRow(45).replace(" ","").toDouble.toInt)
    val pensionNomina= intToBool(splitRow(46).replace(" ","").toDouble.toInt)
    val directDebit= intToBool(splitRow(47).replace(" ","").toDouble.toInt)

    Product(customerCode, date, savingAcc,gaurantees,currentAcc,derivedAcc,payrollAcc,juniorAcc,moreParticularAcc,particularAcc,particularPlusAccion,shorttermDeposit,medtermDeposit,longtermDeposit,eAccount,funds,mortgage,pensionPlan,loan,taxes,creditCard,securities,homeAcc,payrollNomina,pensionNomina,directDebit)

  }
}

