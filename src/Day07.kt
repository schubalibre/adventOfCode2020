/**
 * Thanks to https://github.com/FlorianCassayre/AdventOfCode-2020/blob/master/src/main/scala/adventofcode/solutions/Day07.scala
 */
fun main() {
    example7()
    exercise7()
}

fun exercise7() {
    val rules = readStringFileByLine("src/resources/input07.txt")
    val bags = buildBagMap(rules)

    findBag(bags)
    individualBagCount(bags)
}

fun example7() {
    val rules = listOf(
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    )

    val bags = buildBagMap(rules)
    findBag(bags)
    individualBagCount(bags)
}

fun individualBagCount(bags: Map<String, List<Pair<String, Int>>>) {
    fun countBags(bag: String): Int = bags[bag]!!.map { it.second * countBags(it.first) }.sum() + 1
    println(countBags("shiny gold bag") - 1)
}

fun findBag(bags: Map<String, List<Pair<String, Int>>>) {

    fun contains(bag: String): Boolean = bag == "shiny gold bag" || bags[bag]!!.any { contains(it.first) }

    val num = bags.keys.filter { it != "shiny gold bag" }.count { contains(it) }

    println(num)

}


fun buildBagMap(rules: List<String>): Map<String, List<Pair<String, Int>>> {

    return rules.map {
        val bagArray = it.split(" contain ")
        val name = bagArray[0].removeSuffix("s")
        val children = getChildren(bagArray[1])
        name to children
    }.toMap()
}


fun getChildren(possiblesChildren: String): List<Pair<String, Int>> {
    return if (possiblesChildren.contains("no other bags")) {
        emptyList()
    } else {
        possiblesChildren
            .split(",")
            .map { str ->
                val num = str.filter { it.isDigit() }.toInt()
                val name = str.filter { it.isLetter() || it.isWhitespace() }.trim().removeSuffix("s")
                Pair(name, num)
            }
    }
}
