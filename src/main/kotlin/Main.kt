import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val formMenu = FormMenu()
    val menuArhiv = MenuArhiv()
    val menuNote = MenuNote()
    val listMenu: MutableList<Menu> = mutableListOf()

    listMenu.add(menuArhiv)
    while (listMenu.isNotEmpty()) {

        val currentObject = listMenu[listMenu.size - 1]
        val actionID: Int = formMenu.getActionID(currentObject.getMenu())
        when (actionID) {
            0 -> listMenu.remove(currentObject)
            1 -> currentObject.createObject(formMenu)
            in 2..currentObject.selectionList.size+1 -> {
                if (listMenu.size == 1) {
                    val currentArhiv: Arhiv = currentObject.selectionList[actionID - 2] as Arhiv
                    menuNote.selectionList.clear()
                    menuNote.selectionList.addAll(currentArhiv.listNotes)
                    menuNote.arhiv = currentArhiv
                    listMenu.add(menuNote)
                } else {
                    val note: Note = currentObject.selectionList[actionID - 2] as Note
                    println("\n--- Заметка: ${note.name} ---")
                    println(note.content)
                    println("\nНажмите Enter, чтобы вернуться...")
                    scanner.nextLine()
                }
            }
        }
    }
}
