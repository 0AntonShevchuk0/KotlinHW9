/**
 * Створює групи студентів, викладачів для них та проводить екзамени, виводячи інформацію на консоль
 *
 * @author ТІ-92 Антон Шевчук
 */
fun main() {
        //Створення об'єктів студентів класу Student
        val student = Student("AAA", "AAA", "FH-12", 19, 2)
        val student2 = Student("AAB", "AAB", "FH-12", 19, 2)
        val student3 = Student("ABA", "ABA", "FH-12", 20, 2)
        val student4 = Student("BAA", "BAA", "FH-11", 19, 2)
        val student5 = Student("ABB", "ABB", "FH-11", 19, 2)
        val student6 = Student("BAB", "BAB", "FH-11", 20, 2)
        val student7 = Student("BBA", "BBA", "FH-13", 19, 2)
        val student8 = Student("BBB", "BBB", "FH-13", 20, 2)
        val student9 = Student("CCC", "CCC", "FH-13", 19, 2)

        //Створення об'єктів викладачів класу Teacher
        val teacher = Teacher("Math")
        val teacher2 = Teacher("Programming")
        val teacher3 = Teacher("DB")

        Student.showNumberOfStudents() //Виклик методу класу

    //Створення списків arrayList студентів - груп
        var groupFH12 = arrayListOf(student, student2, student3)
        var groupFH11 = arrayListOf(student4, student5, student6)
        var groupFH13 = arrayListOf(student7, student8, student9)

        //Створення об'єктів екзаменів класу Exam
        val exam = Exam(teacher)
        val exam2 = Exam(teacher2)
        val exam3 = Exam(teacher3)

        //Сиконання екзаменів за допомогою методу takeExam()
        groupFH12 = exam.takeExam(groupFH12)
        groupFH11 = exam.takeExam(groupFH11)

        groupFH12 = exam2.takeExam(groupFH12)
        groupFH13 = exam2.takeExam(groupFH13)

        groupFH13 = exam3.takeExam(groupFH13)
        groupFH11 = exam3.takeExam(groupFH11)

        Student.showNumberOfStudents()

        //Переведення студентів, що залишились на новий курс
        groupFH11.forEach({ it.newCourse() })
        groupFH12.forEach({ it.newCourse() })
        groupFH13.forEach({ it.newCourse() })

        //Виведення інформації про студентів, замінюючи цикл for компактнішим
        //методом foreach
        groupFH11.forEach({ println(it.toString()) })
        groupFH12.forEach({ println(it.toString()) })
        groupFH13.forEach({ println(it.toString()) })
}

