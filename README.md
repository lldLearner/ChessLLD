# Thought Process - 

* Chess has Pieces(Rook, Bishop, Queen, King, Pawn, Horse) and has two colors(Black and White). So there will be only two players assigned to one game.
* Pieces can be abstract and (Rook, Bishop, Queen, King, Pawn, Horse) can be its concrete implementations.
* Having done that above *FactoryPattern* is the thing which can be used to get appropriate piece instance.
* Rook, Queen | Bishop, Queen has repeatable move validation logic so *strategy pattern* is the thing which can be used to tackle that and promote reusability.
* In checkmate logic and stalemate logic, there is a requirement of previous state as it requires to check each and every possible move, for that *memento* can be used to store state. Didn,t implemented that because it is a repeatable two line backtracking code, so why to make the codebase bloated unnecessarily.

* The special moves are not implemented yet namelly En Passant, Conversion, Casttleing
