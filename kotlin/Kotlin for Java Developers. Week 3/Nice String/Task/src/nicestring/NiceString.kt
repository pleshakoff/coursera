package nicestring

fun String.isNice(): Boolean {

    val condition1 = arrayOf("bu","ba","be").none{this.contains(it)};

    //val condition2:Boolean = arrayOf('a','e','i','o','u').sumBy{letter ->  this.count{c-> c == letter }}>=3;
    val condition2:Boolean = count{it in "aeiou"}>=3

//    val condition3:Boolean = ("$this*").zip("#$this").any { pair -> pair.first == pair.second }
    val condition3:Boolean = zipWithNext().any(){it.first == it.second}

   return arrayOf(condition1,condition2,condition3).count {it} >=2;


}