package me.rubendm.gol

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class WorldSpec : StringSpec({
    "World evolves raising its cells" {
        World(
            Grid(
                mapOf(
                    Position(0, 0) to DeadCell,
                    Position(0, 1) to DeadCell,
                    Position(0, 2) to DeadCell,
                    Position(1, 0) to AliveCell,
                    Position(1, 1) to AliveCell,
                    Position(1, 2) to AliveCell,
                    Position(2, 0) to DeadCell,
                    Position(2, 1) to DeadCell,
                    Position(2, 2) to DeadCell
                )
            )
        ).evolve() shouldBe World(
            Grid(
                mapOf(
                    Position(0, 0) to DeadCell,
                    Position(0, 1) to AliveCell,
                    Position(0, 2) to DeadCell,
                    Position(1, 0) to DeadCell,
                    Position(1, 1) to AliveCell,
                    Position(1, 2) to DeadCell,
                    Position(2, 0) to DeadCell,
                    Position(2, 1) to AliveCell,
                    Position(2, 2) to DeadCell
                )
            )
        )
    }
})