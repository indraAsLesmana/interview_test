val s = "a0aw00wo0BBw123123AA0B0BB0ccc0a"
// Output must be 'B'

fun solution1() {
    /// solution 1
    val chars = s.toCharArray().toTypedArray().filter { it.isLetter() }
    print(chars.toString())

    var temp: HashMap<Char, Int> = HashMap()

    chars.forEach {
        if (temp.isEmpty()) {
            temp.put(it, 1)
            return@forEach
        }

        temp.put(it, temp.get(it)?.plus(1) ?: 0)

    }

    print("solution 1: " + temp.toList().sortedBy { it.second }.reversed()[0].first)
}

fun solution2(){
    /// solution 2
    var heighestChar: Char? = null
    var heighestNumber = 0

    for (i in s.indices){
        val char = s.get(i);
        if (char.isDigit()) continue;
        var repeatedCount = 0;
        for (j in s.indices){
            if (char == s.get(j)) repeatedCount++;
        }
        if (repeatedCount > heighestNumber){
            heighestChar = char
            heighestNumber = repeatedCount
        }
    }

    print("solution 2: " + heighestChar)
}

fun solution3(){
    /// solution 2
    var heighestChar: Char? = null
    var heighestNumber = 0
    var temp = HashMap<Char, Int>()
    for (i in s.indices){
        val char = s.get(i);
        if (char.isDigit()) continue;
        val increment = temp.get(char)?.plus(1)?: 0
        temp.put(char, increment)

        if ((temp.get(char) ?: 0) > heighestNumber){
            heighestChar = char
            heighestNumber = increment
        }
    }

    print("solution 3: " + heighestChar)
}

solution1()
solution2()
solution3()