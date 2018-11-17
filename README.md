# Game of life

This repo is a small exercise I did after our last [Global Day of Coderetreat](https://www.coderetreat.org/) in Madrid. We usually do a restriction based on no conditionals (ifs, switchs, ternary operators...).

This is usually a shocking restriction and it was for me the first time, but I wanted to take some time to do the whole kata without a conditional. And here it is.  

## The problem

In case that you don't know the kata, it is the [Game of life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life). The rules are basically as follows:

* Any live cell with fewer than two live neighbors dies, as if by underpopulation.
* Any live cell with two or three live neighbors lives on to the next generation.
* Any live cell with more than three live neighbors dies, as if by overpopulation.
* Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## How?

Well, polymorphism to the rescue. In the code you will find two types of cells: `AliveCell` and `DeadCell`. And the cells can be raised in three types of neighborhoods: `Deadly` (all cells here die), `Average` (cells keep the same state) and `Prolific` (all cells live). You'll see that all methods are one-liners, using only method overloading to know the next state of a cell.

In the `World` class you'll find a `when` statement from Kotlin that in fact is a type of conditional, like a switch. I used this for the sake of clarity, but I hope you agree that this can be easily replace with a Map of two entries and a `getOrDefault` (I'm not writing the conditional in that case :))

_Edit: I have trolls as friends and they are incapable of imagining a Map instead of when, so I'll replace it 🤷‍♂️_

## Disclaimer

I didn't intend the solution to be perfect. There are some names that are not quite expressive maybe, and for making the test easier I used some `data classes` to have implemented the `equals` method.

The only purpose of this solution is to make a point that writing a full solution with no conditionals is possible :)