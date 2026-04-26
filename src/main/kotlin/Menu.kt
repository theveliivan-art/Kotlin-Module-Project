interface Menu {
    val selectionList: MutableList<*>
    fun getMenu():MutableMap<Int, String>
    fun createObject(formMenu: FormMenu)
}