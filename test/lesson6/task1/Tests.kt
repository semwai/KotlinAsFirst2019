package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, timeStrToSeconds("10:00:00"))
        assertEquals(41685, timeStrToSeconds("11:34:45"))
        assertEquals(86399, timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", twoDigitStr(0))
        assertEquals("09", twoDigitStr(9))
        assertEquals("10", twoDigitStr(10))
        assertEquals("99", twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", timeSecondsToStr(36000))
        assertEquals("11:34:45", timeSecondsToStr(41685))
        assertEquals("23:59:59", timeSecondsToStr(86399))
    }

    @Test
    @Tag("Normal")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", dateStrToDigit("15 июля 2016"))
        assertEquals("", dateStrToDigit("3 мартобря 1918"))
        assertEquals("18.11.2018", dateStrToDigit("18 ноября 2018"))
        assertEquals("", dateStrToDigit("23"))
        assertEquals("03.04.2011", dateStrToDigit("3 апреля 2011"))
        assertEquals("", dateStrToDigit("32 сентября 2011"))
        assertEquals("", dateStrToDigit("29 февраля 1993"))
    }

    @Test
    @Tag("Normal")
    fun dateDigitToStr() {
        assertEquals("15 июля 2016", dateDigitToStr("15.07.2016"))
        assertEquals("", dateDigitToStr("01.02.20.19"))
        assertEquals("", dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", dateDigitToStr("03.04.2011"))
        assertEquals("", dateDigitToStr("ab.cd.ef"))
        assertEquals("", dateDigitToStr("32.09.2011"))
        assertEquals("", dateDigitToStr("29.02.1993"))
    }

    @Test
    @Tag("Normal")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("+12345", flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", flattenPhoneNumber("+12 () 4-5"))
        assertEquals("+425667", flattenPhoneNumber("+42 56 -- 67"))
        assertEquals("+42566789", flattenPhoneNumber("+42(56 -- 67)89"))
        assertEquals("", flattenPhoneNumber("ab-123"))
        assertEquals("", flattenPhoneNumber("134_+874"))
    }

    @Test
    @Tag("Normal")
    fun bestLongJump() {
        assertEquals(717, bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, bestLongJump("% - - % -"))
        assertEquals(754, bestLongJump("700 717 707 % 754"))
        assertEquals(-1, bestLongJump("700 + 700"))

    }

    @Test
    @Tag("Hard")
    fun bestHighJump() {
        assertEquals(226, bestHighJump("226 +"))
        assertEquals(-1, bestHighJump("???"))
        assertEquals(230, bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"))
    }

    @Test
    @Tag("Hard")
    fun plusMinus() {
        assertEquals(6, plusMinus("2 + 31 - 40 + 13"))
        assertEquals(0, plusMinus("0"))
        assertEquals(4, plusMinus("2 + 2"))
        assertEquals(-1, plusMinus("0 - 1"))
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+ 4") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - + 12") }
    }

    @Test
    @Tag("Hard")
    fun firstDuplicateIndex() {
        assertEquals(-1, firstDuplicateIndex("Привет"))
        assertEquals(9, firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
    }

    @Test
    @Tag("Hard")
    fun mostExpensive() {
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("", mostExpensive(""))
        assertEquals("Вино", mostExpensive("Вино 255.0"))
        assertEquals("вкусняшка", mostExpensive("Вино 255.0;            вкусняшка 12332     ;м) 12 "))
        assertEquals("a", mostExpensive("a 0"))
    }

    @Test
    @Tag("Hard")
    fun fromRoman() {
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(1, fromRoman("I"))
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))
        assertEquals(-1, fromRoman("CMCMCMCM"))
        assertEquals(-1, fromRoman("у меня получилось вставить сюда эмодзи💩👺"))
    }

    @Test
    @Tag("Impossible")
    fun computeDeviceCells() {

        assertEquals(
            listOf(430),
            computeDeviceCells(1, "[+]+++++++++++++++++++++[++++++]", 500)
        )
        assertEquals(
            listOf(457),
            computeDeviceCells(1, "+[+++++++++++]", 500)
        )
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 10000))
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(
            listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
            computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000)
        )

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(
            listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
            computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256)
        )
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "===", 3) }
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "+>+>[+>", 3) }
        assertThrows(IllegalStateException::class.java) { computeDeviceCells(20, ">>>>>>>>>>>>>", 12) }
        assertThrows(IllegalArgumentException::class.java) {
            computeDeviceCells(
                1,
                "+]+[++++]]+++]++++++[+++++++++++++++++++]++[+++++++++++++++++-]++<+><+++-+>]-+-+-<+]- <>-+---- [-[-]+]<<+<<] -<+-] -<<]><[->-[--<++<]<-[<-+<]>---+>-+- --<+<<<<-]+[+++ <-[<<>]-[[<[ <-+<<]-<-+--<+<>[<-+-- <--<[<-<-<+]---[<]-] -<<<-----+-+ --+-  -<<--+ +- +[+<<<]--+++-< ----<<]<><------><-- -+< +<]+-+<---+--[--<+--<--<]-]+-<-[<+><-]<--+<<-<<-+[-+---+><[<[+]-]<]<---<<><+>--<-+<--+< +<+<<----<++-<-<[++--><+-+-[-<+ -] <[--<+---+-<<++[+ -+----<<> <-+>-<+-<-+<<+[>+<<+<<<-+>++-++--]+--+-+-+ +++<[]+<-++[++<<>--<---+[><<-<-[+--+>[<+<-+<+++- <<]<]-<- -+-+<--<-<+-< --><>-+---<[>->>+<<<-[]+-- <]<-[ ++<-->+->-<--+] [--<--+-<- <<+<->- ----+><-> [++-----<-+-[+<+[-- >-- -<<  <<-[[[>]]< +---<+-]--+-- +><+-+ +-+<<--]<->-+--->]->++<+-->]+--[--<++]+><<-<[-[<---->-<--<>-<  []-]->[>-- <+>->--+]---< +<++---]>-->-<--<<-+<[- --[-+]>>]<[>+>]-[[>+<<-]<--->+--+- ++[++<++[--] +--+-+[-+]+--+---<<]+-++---[--+-<--+----+-<< [-+<<>+[[++<<[--><<<<+ -<[->]+>]- ]-[---<---+[ -<-<+ -<<<[-<+------<--<]+-<-<-]-+<-+ []+-<<+-[]+<+ +-+--+--->>]<+-+[<-+---+<++--]]->--+<]<<<<[+++>-->---+<>++-><]-----+  -<-->+",
                501
            )
        }
        assertEquals(
            listOf(2916),
            computeDeviceCells(1, "+ ++++++++++++++++++++++++++-++-[+]", 5811)
        )



    }
}