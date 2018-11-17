package me.rubendm.gol

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CellSpec : StringSpec({
    "An alive cell should die in a deadly neighborhood" {
        AliveCell.tick(Deadly) shouldBe DeadCell
    }

    "An alive cell should go on living in an average neighborhood" {
        AliveCell.tick(Average) shouldBe AliveCell
    }

    "An alive cell should go on living in a prolific neighborhood" {
        AliveCell.tick(Prolific) shouldBe AliveCell
    }

    "A dead cell should remain dead in a deadly neighborhood" {
        DeadCell.tick(Deadly) shouldBe DeadCell
    }

    "A dead cell should remain dead in an average neighborhood" {
        DeadCell.tick(Average) shouldBe DeadCell
    }

    "A dead cell should born in a prolific neighborhood" {
        DeadCell.tick(Prolific) shouldBe AliveCell
    }
})