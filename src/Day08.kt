fun main() {
    //example8()

    exercise8()
}

fun exercise8() {


    val count = countAcc(
        instructions = instructions
    )

    println(count.first)



    val z = instructions.withIndex().map { (i, instruction) ->
        val replacement = when(instruction) {
            is ACC -> null
            is JMP -> NOP(instruction.num)
            is NOP -> JMP(instruction.num)
        }

        if(replacement != null) {
            val replaceableInstructions = instructions.toMutableList() // !!!!  not save -> instructions as MutableList<Instruction>) !!!!!!!!
            replaceableInstructions[i] = replacement
            val possibleCount = countAcc(
                instructions = replaceableInstructions
            )
            if(possibleCount.second) possibleCount.first
            else null
        }else {
            null
        }
    }

    println(z.filterNotNull())


}


private val bootCode = readStringFileByLine("src/resources/input08.txt") /*listOf(
    "nop +0",
    "acc +1",
    "jmp +4",
    "acc +3",
    "jmp -3",
    "acc -99",
    "acc +1",
    "jmp -4",
    "acc +6"
)*/

sealed class Instruction
class ACC(val num: Int) : Instruction()
class JMP(val num: Int) : Instruction()
class NOP(val num: Int) : Instruction()


private val instructions: List<Instruction> = bootCode.map {
    val str = it.split(" ")
    when (str[0]) {
        "acc" -> ACC(str[1].toInt())
        "jmp" -> JMP(str[1].toInt())
        "nop" -> NOP(str[1].toInt())
        else -> NOP(0)
    }
}

fun example8() {
    val count = countAcc(
        instructions = instructions
    )

    println(count.first)

}

fun countAcc(
    pointer: Int = 0,
    acc: Int = 0,
    history: MutableSet<Int> = mutableSetOf(),
    instructions: List<Instruction>
): Pair<Int, Boolean> {
    return when {
        pointer == instructions.size -> Pair(acc, true)
        history.contains(pointer) -> Pair(acc, false)
        else -> {
            history.add(pointer)
            when (val instruction = instructions[pointer]) {
                is ACC -> countAcc(pointer + 1, acc + instruction.num, history, instructions)
                is JMP -> countAcc(pointer + instruction.num, acc, history, instructions)
                is NOP -> countAcc(pointer + 1, acc, history, instructions)
            }
        }
    }
}
