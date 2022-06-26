val cardType = "Vk Pay"
val amountPerMonth = 0
val transferAmount = 3523
const val masterMaestroComission = 0.006
const val visaMirComission = 0.0075

fun main(){
    printResult()
}

fun transfer(cardType: String, transferAmount:Int, amountperMonth: Int): Int{
    val amount = when(cardType) {
        "Mastercard", "Maestro" -> {
            (transferAmount - calculateComission(cardType,amountPerMonth,transferAmount)).toInt()
        }
        "Visa","Мир" -> {
            if (transferAmount > 35_00) (transferAmount - calculateComission(cardType,amountPerMonth,transferAmount)).toInt() else 0
        }
        else -> transferAmount
    }
    return amount
}
fun calculateComission (cardType: String, amountPerMonth: Int, transferAmount: Int) : Int{
    val userComission = when(cardType){
        "Mastercard", "Maestro" -> {
            if (amountPerMonth < 75_000_00) 0 else (transferAmount * masterMaestroComission + 20_00).toInt()
        }
        "Visa","Мир" -> {
            if (transferAmount < 35_00) 35_00 else (transferAmount * visaMirComission).toInt()
        }
        else -> 0
    }
    return userComission
}

fun printResult(){
    println("Комиссия составит: ${calculateComission(cardType, amountPerMonth,transferAmount)} копеек")
    println("Перевод составит: ${transfer(cardType, amountPerMonth, transferAmount)/100} ${amountRubSuffix(transfer(cardType, amountPerMonth, transferAmount))} ${(transfer(cardType, amountPerMonth, transferAmount)%100)} копеек")
}

fun amountRubSuffix (amount: Int): String{
    ending = when {
        amount/100%10 == 1 && amount/100%100 != 11 -> {
            "рубль"
        }
        amount/100%10 == 2  || amount/100%10 == 3 || amount/100%10 == 4 ->{
            "рубля"
        }
        else -> {
            "рублей"
        }
    }
    return ending
}
