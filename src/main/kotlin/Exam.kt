/**
 * Екзамен викладача
 *
 * Працює з об'єктами класу Student і виставляє їм бали
 *
 * @property teacher Викладач, що проводить екзамен
 * @constructor Створює екзамен з назначеним викладачем
 */
class Exam(_teacher: Teacher) {

    private val teacher: Teacher = _teacher

    /**
     * Проводить екзамен
     *
     * @param group Група студентів, для якої проводиться екзамен
     * @return Та частина групи студентів, що пройшла екзамен
     */
    fun takeExam(group: ArrayList<Student>) : ArrayList<Student> {
        println("${teacher.subject} exam") //Виведення на консоль сповіщення про проведення екзамену
        val passed = arrayListOf<Student>() //Створення нової пустої колекції
        //Екзаменування вчителем кожного студента
        for (student in group) {
            //виключення, якщо поганий бал
            if (!teacher.examine(student)) {
                println("BAD MARKS")
                student.remove()
            }
            else {
                passed.add(student)
            }
        }
        return passed
    }
}