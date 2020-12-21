package main.kotlin

class Day02(list: List<String>) {

    private val policies = list

    fun solvePart1():Int {
        return findCorrectPassword(policies).size
    }

    fun solvePart2():Int {
        return isOnCorrectPosition(policies).size
    }

    private fun isOnCorrectPosition(policies: List<String>) = policies.filter {
        val p = Policy(it)
        val pwChar = p.password.toCharArray()
        val char1 = pwChar[p.min-1]
        val char2 = pwChar[p.max-1]

        (char1 == p.letter || char2 == p.letter) && char1 != char2
    }

    private fun findCorrectPassword(policies: List<String>) = policies.filter {
        val p = Policy(it)
        val num: Int = p.password.count { c -> c == p.letter }
        num >= p.min && num <= p.max
    }


    private data class Policy(val policy: String) {
        val policyArr = policy.split(" ").toTypedArray()
        val min = policyArr[0].split("-")[0].toInt()
        val max = policyArr[0].split("-")[1].toInt()
        val letter = policyArr[1][0]
        val password = policyArr[2]

    }
}

