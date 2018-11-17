package me.rubendm.gol

data class Position(val x: Int, val y: Int) {
    fun adjacent(): List<Position> {
        return (-1..1).flatMap { x -> (-1..1).map { Pair(x, it) } }
            .filterNot { it.first == 0 && it.second == 0 }
            .map { Position(x + it.first, y + it.second) }
    }
}

data class Grid(private val cells: Map<Position, Cell>) {
    fun map(f: (Position, Cell) -> Cell): Grid = Grid(cells.mapValues { f(it.key, it.value) })

    fun neighborsOf(position: Position): List<Cell> = position.adjacent().mapNotNull { cells[it] }
}

data class World(private val grid: Grid) {

    fun evolve(): World = World(grid.map { position, cell ->
        cell.tick(neighborhood(grid.neighborsOf(position)))
    })

    private fun neighborhood(neighbors: List<Cell>): Neighborhood {
        return when (neighbors.count { it == AliveCell}) {
            2 -> Average
            3 -> Prolific
            else -> Deadly
        }
    }
}