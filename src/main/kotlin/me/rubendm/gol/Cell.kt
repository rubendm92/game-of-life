package me.rubendm.gol

sealed class Cell {
    abstract fun tick(neighborhood: Neighborhood): Cell
}

object AliveCell: Cell() {
    override fun tick(neighborhood: Neighborhood): Cell = neighborhood.raise(this)
}

object DeadCell: Cell() {
    override fun tick(neighborhood: Neighborhood): Cell = neighborhood.raise(this)
}


sealed class Neighborhood {
    abstract fun raise(cell: AliveCell): Cell
    abstract fun raise(cell: DeadCell): Cell
}

object Deadly: Neighborhood() {
    override fun raise(cell: AliveCell): Cell = DeadCell

    override fun raise(cell: DeadCell): Cell = DeadCell
}

object Average: Neighborhood() {
    override fun raise(cell: AliveCell): Cell = AliveCell

    override fun raise(cell: DeadCell): Cell = DeadCell
}

object Prolific: Neighborhood() {
    override fun raise(cell: AliveCell): Cell = AliveCell

    override fun raise(cell: DeadCell): Cell = AliveCell
}