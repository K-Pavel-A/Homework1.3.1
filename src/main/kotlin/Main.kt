var ending = ""

fun main(){
    val time = 60
    agoToText(time)
}

fun agoToText(time: Int) {
    val text = when (time){
       in 0..60 -> "только что"
        in 61..60 * 60 -> "${time /60} ${minutesSuffix(time)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${time /3600} ${hoursSuffix(time)} назад"
        in 24*60*60+1..24*60*60*2 -> "сегодня"
        in 24*60*60*2+1..24*60*60*3 -> "вчера"
        else -> "давно"
    }
    println("Пользователь был в сети $text")
}


fun minutesSuffix (time: Int): String {
    ending = when {
        time/60%10 == 2 && time/60%100 != 12 || time/60%10 == 3 && time/60%100 != 13 || time/60%10 == 4  && time/60%100 != 14 ->{
            "минуты"
        }
        time/60%10 == 1 && time/60%100 != 11 -> {
            "минуту"
        }
        else -> {
            "минут"
        }
    }
    return ending
}

fun hoursSuffix (time: Int): String{
    ending = when {
        time / 3600 % 10 == 1 && time/3600%100 != 11 -> {
            "час"
        }
        time/3600%10 == 2 && time/3600%100 != 12 || time/3600%10 == 3 && time/3600%100 != 13 || time/3600%10 == 4  && time/3600%100 != 14 ->{
            "часа"
        }
        else -> {
            "часов"
        }
    }
    return ending
}
