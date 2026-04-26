class Arhiv(
    val name:String,
    val listNotes: MutableList<Note>
)

class MenuArhiv: Menu{
    override var selectionList: MutableList<Arhiv> = mutableListOf()
    override fun getMenu():MutableMap<Int, String>{
        val menu: MutableMap<Int, String> = mutableMapOf(
            0 to "0. Выход",
            1 to "1. Создать архив")
        var i = 2
        for (arhiv in selectionList){
            menu.put(i, "$i. Открыть архив ${arhiv.name}")
            i++
        }
        return menu
    }

    override fun createObject(formMenu: FormMenu){

        println("Введите имя архива")
        val name = formMenu.readInputText()

        val arhiv = Arhiv(name, mutableListOf())
        selectionList.add(arhiv)

    }
}