class Note(
    val name: String,
    val content: String
)

class MenuNote: Menu{
    override var selectionList: MutableList<Note> = mutableListOf()
    var arhiv: Arhiv? = null

    override fun getMenu():MutableMap<Int, String>{
        val menu: MutableMap<Int, String> = mutableMapOf()
        menu.put(0, "0. Выход")
        menu.put(1, "1. Создать заметку")
        var i = 2
        for (note in selectionList){
            menu.put(i, "$i. Открыть заметку ${note.name}")
            i++
        }
        return menu
    }

     override fun createObject(formMenu: FormMenu){

        println("Введите имя заметки")

        val name = formMenu.readInputText()

        println("Введите текст заметки")
        val content = formMenu.readInputText()

        val note = Note(name, content)
        selectionList.add(note)
        arhiv?.listNotes?.add(note)

    }

}