fun main() {
    example2()
    exercise2()
}

fun example2() {
    val policies = listOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
    )

    println(findCorrectPassword(policies).size)
    println(isOnCorrectPosition(policies).size)
}

fun exercise2() {

    val policies = readStringFileByLine("src/resources/input02.txt")

    println(findCorrectPassword(policies).size)
    println(isOnCorrectPosition(policies).size)

}

fun isOnCorrectPosition(policies: List<String>) = policies.filter {
    val p = Policy(it)
    val pwChar = p.password.toCharArray()
    val char1 = pwChar[p.min-1]
    val char2 = pwChar[p.max-1]

    (char1 == p.letter || char2 == p.letter) && char1 != char2
}

fun findCorrectPassword(policies: List<String>) = policies.filter {
    val p = Policy(it)
    val num: Int = p.password.count { c -> c == p.letter }
    num >= p.min && num <= p.max
}


data class Policy(val policy: String) {
    val policyArr = policy.split(" ").toTypedArray()
    val min = policyArr[0].split("-")[0].toInt()
    val max = policyArr[0].split("-")[1].toInt()
    val letter = policyArr[1][0]
    val password = policyArr[2]

}