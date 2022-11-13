import kotlin.random.Random

/**
 * Викладач з предмету
 *
 * Працює з об'єктами класу Student і екзаменує їх
 *
 * @property subject Навчальний предмет
 * @constructor Створює викладача з певним предметом
 */
class Teacher(_subject: String) {

    val subject: String = _subject

    /**
     * Екзаменує студента
     *
     * @param student Студент, якого екзаменує викладач
     * @return True, якщо студент прошов, і false - якщо ні.
     */
    fun examine(student: Student) : Boolean {
        student.setNewMark(subject, Random.nextInt(40, 100)) //в цій реалізації оцінки виставляються випадковим чином
        //перевірка
        if (!student.checkMarks()) {
            return false
        }
        return true
    }
}