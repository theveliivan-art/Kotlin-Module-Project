import java.util.Scanner

class FormMenu{
    val scanner = Scanner(System.`in`)

    fun readInputText():String{
        var inputText: String = " "
        while (inputText.isNullOrBlank()){
            inputText = scanner.nextLine()
        }
        return inputText
    }

    fun getActionID(menu: MutableMap<Int, String>):Int{
        var actionID: Int?
        while (true){
            actionID = actionSelection(menu)
            if (actionID!=null){return actionID}
        }
    }

    fun actionSelection(menu: MutableMap<Int, String>):Int?{

        println("Выберите пункт меню:")
        for (i in menu) {
            println("${i.value}")
        }

        if (scanner.hasNextInt()) {
            val number = scanner.nextInt()
            if (menu[number] != null) {
                return number
            } else {
                println("Такого пункта нет в меню.")
            }
        } else {
            println("Необходимо ввести числовой номер пукта меню.")
        }
        scanner.nextLine()

        return null
    }
}