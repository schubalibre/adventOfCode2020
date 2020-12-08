package main.kotlin

fun main() {
    //main.kotlin.example4()
    exercise4()
}

fun exercise4() {
    val passportData = readStringFileByLine("src/resources/input04.txt")
    checkPasswordData(passportData)
}

private val fields = listOf(
    "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
).sorted()

fun example4() {
    val passportData = listOf(
        "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
        "byr:1937 iyr:2017 cid:147 hgt:183cm",
        "",
        "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
        "hcl:#cfa07d byr:1929",
        "",
        "hcl:#ae17e1 iyr:2013",
        "eyr:2024",
        "ecl:brn pid:760753108 byr:1931",
        "hgt:179cm",
        "",
        "hcl:#cfa07d eyr:2025 pid:166559648",
        "iyr:2011 ecl:brn hgt:59in"
    )

    val validPassportData = listOf(
        "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
        "hcl:#623a2f",
        "",
        "eyr:2029 ecl:blu cid:129 byr:1989",
        "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
        "",
        "hcl:#888785",
        "hgt:164cm byr:2001 iyr:2015 cid:88",
        "pid:545766238 ecl:hzl",
        "eyr:2022",
        "",
        "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"
    )

    val incorrectPassportData = listOf(
        "eyr:1972 cid:100",
        "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
        "",
        "iyr:2019",
        "hcl:#602927 eyr:1967 hgt:170cm",
        "ecl:grn pid:012533040 byr:1946",
        "",
        "hcl:dab227 iyr:2012",
        "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
        "",
        "hgt:59cm ecl:zzz",
        "eyr:2038 hcl:74454a iyr:2023",
        "pid:3556412378 byr:2007"
    )

    checkPasswordData(passportData)
}

fun checkPasswordData(
    passportData: List<String>
) {
    val correctCredentials = passportData
        .joinToString(" ") { if (it == "") "|" else it }
        .split("|").toTypedArray()
        .map { it.trim() }
        .filter { it != "" }
        .map {
            val credentials = it.split(" ")

            val present: Boolean = isPresent(credentials)

            if (present) {
                // FIXME - the correct answer is 198 but it says 199
                validateCredentials(credentials)
            } else {
                false
            }

        }.count { it }
    println(correctCredentials)
}

private fun isPresent(credentials: List<String>): Boolean {
    return credentials
        .map { it.split(":")[0] }
        .filter { it != "cid" }
        .sorted()
        .containsAll(fields)
}

fun validateCredentials(credentials: List<String>): Boolean {
    val validAll = credentials.map {
        val credential = it.split(":")


        val valid = when (credential[0]) {
            "byr" -> checkByr(credential[1])
            "iyr" -> checkIyr(credential[1])
            "eyr" -> checkEyr(credential[1])
            "hgt" -> checkHgt(credential[1])
            "hcl" -> checkHcl(credential[1])
            "ecl" -> checkEcl(credential[1])
            "pid" -> checkPid(credential[1])
            "cid" -> true
            else -> false
        }

        if(valid){
            println(credential[0])
            println(credential[1])

            println(valid)
            println("************")
        }


        valid
    }

    println(validAll)

    return validAll.all{it}
}

fun checkPid(s: String) = s.contains("[0-9]{9}".toRegex())

fun checkEcl(s: String) = s in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

fun checkHcl(s: String) = s.contains("^#[0-9a-f]{6}".toRegex())

fun checkHgt(s: String): Boolean {

    if (s.endsWith("cm")) {
        val height = s.removeSuffix("cm").toInt()
        return height in 150..193
    }

    if (s.endsWith("in")) {
        val height = s.removeSuffix("in").toInt()
        return height in 59..76
    }

    return false
}

fun checkEyr(s: String): Boolean {
    val date = s.toInt()
    return date in 2020..2030
}

fun checkIyr(s: String): Boolean {
    val date = s.toInt()
    return date in 2010..2020
}

fun checkByr(s: String): Boolean {
    val date = s.toInt()
    return date in 1920..2002
}



