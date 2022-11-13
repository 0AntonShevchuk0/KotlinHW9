import kotlin.Exception

/**
 * Студент КПІ
 *
 * Зберігає дані студента, змінює деякі за допомогою методів
 *
 * @property marks Колекція з річними оцінками з предметів
 * @property numberOfStudents Рахує загальну кількість студентів
 * @property name Ім'я студента
 * @property surname Прізвище студента
 * @property group Код групи студента
 * @property age Вік студента
 * @property course Курс студента
 * @constructor Створює викладача з певним предметом
 */
class Student(_name: String, _surname: String, _group: String, _age: Int) {

    //Ооб'єкт з властивостями та методами класу
    companion object {
        private var numberOfStudents: Int = 0;

        /**
         * Виводить число студентів на консоль
         */
        fun showNumberOfStudents() {
            println("There are $numberOfStudents students")
        }
    }

    //Блок ініціалізації
    init {
        numberOfStudents++
    }

    private val marks: MutableMap<Int, MutableMap<String, Int>> = mutableMapOf(Pair(1, mutableMapOf()))

    private val name: String = _name

    private val surname: String = _surname

    private var group: String = _group

    private var age: Int = _age

    private var course: Int = 1

    //Вторинний конструктор
    constructor(_name: String, _surname: String, _group: String, _age: Int, _course: Int)
            : this(_name, _surname, _group, _age) {
        course = _course
        marks[course] = mutableMapOf()
    }

    /**
     * Повертає дані студента у вигляді рядка
     *
     * Рядок, що містить значення усіх властивостей об'єкта
     */
    override fun toString(): String {
        val str = StringBuilder() //Створює об'єкт класу StringBuilder для побудови рядків по частинам
        str.append("Student $surname $name\n") //додаємо рядок
        str.append("Group $group\n")
        str.append("Course $course\n")
        str.append("Marks\n")
        for (courseMarks in marks) {
            str.append("    Course ${courseMarks.key}\n")
            for (mark in courseMarks.value) {
                str.append("    Subject ${mark.key} Mark ${mark.value}\n")
            }
        }

        return str.toString()
    }

    /**
     * Ставить студенту оцінку з предмету
     *
     * @param subject Предмет, з якого виставляється оцінка
     * @param mark Значення оцінки від 0 до 100
     * @throws Exception Відхилення від діапазону 0-100
     * @return True, якщо студент прошов, і false - якщо ні.
     */
    fun setNewMark(subject: String, mark: Int) {
        if (mark < 0 || mark > 100)
            throw Exception("Incorrect mark value")
        marks.get(course)?.put(subject, mark)
    }

    /**
     * Переводить студента на новий курс
     */
    fun newCourse() {
        //Якщо студент закінчив 4 курс, то він видаляється
        if (course == 4) {
            remove()
            return;
        }
        age++
        course++
        marks.put(course, mutableMapOf())
    }

    /**
     * Перевіряє оцінки студента
     * @return False, якщо оцінки погані, true - якщо хороші
     */
    fun checkMarks() : Boolean {
        //якщо знаходимо оцінку нижче 60, то попереджуємо про погані оцінки
        if (marks[course]?.filter { it.value < 60 }?.size != 0) {
            alertAboutBadMarks()
            return false
        }
        //якщо середній бал вище A, то повідомляємо про хороші оцінки
        if (marks[course]?.values?.average()?.let { markToChar(it.toInt()) } == 'A') {
            alertAboutGoodMarks()
        }
        return true
    }

    /**
     * Видаляє студента
     */
    fun remove() {
        println("Student expelled")
        numberOfStudents--
    }

    /**
     * Попереджує про погані оцінки на консолі
     */
    private fun alertAboutBadMarks() {
        println("Student have bad marks")
    }

    /**
     * Повідомляє про хороші оцінки на консоль
     */
    private fun alertAboutGoodMarks() {
        println("Student have good marks")
    }

    /**
     * Переводить оцінки-числа в оцінки-літери
     *
     * @param mark Оцінка від 0 жо 100
     * @throws Exception Відхилення від діапазону 0-100
     * @return False, якщо оцінки погані, true - якщо хороші
     */
    private fun markToChar(mark: Int): Char {
        if (mark < 0 || mark > 100)
            throw Exception("Incorrect mark value")
        if (mark < 60) {
            return 'F'
        }
        else if (mark < 65) {
            return 'E'
        }
        else if (mark < 75) {
            return 'D'
        }
        else if (mark < 85) {
            return 'C'
        }
        else if (mark < 95) {
            return 'B'
        }
        else {
            return 'A'
        }
    }
}