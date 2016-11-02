(ns tic-tac-toe.core-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.core :refer :all]))

(describe "game rules"

;; horizontal winners

  (it "returns winner when player played 0 1 2"
      (should= (score-game {0 "x" 1 "x" 2 "x" 3 "e" 4 "e" 5 "e" 6 "e" 7 "o" 8 "o"}) ["x" #{0 1 2}])
      (should= (score-game {0 "o" 1 "o" 2 "o" 3 "e" 4 "x" 5 "e" 6 "e" 7 "x" 8 "x"}) ["o" #{0 1 2}]))

  (it "returns winner when player plays 3 4 5"
      (should= (score-game {0 "e" 1 "e" 2 "e" 3 "x" 4 "x" 5 "x" 6 "e" 7 "e" 8 "e"}) ["x" #{3 4 5}])
      (should= (score-game {0 "e" 1 "e" 2 "e" 3 "o" 4 "o" 5 "o" 6 "e" 7 "e" 8 "e"}) ["o" #{3 4 5}]))

  (it "returns winner when player plays 6 7 8"
      (should= (score-game {0 "e" 1 "e" 2 "e" 3 "e" 4 "e" 5 "e" 6 "x" 7 "x" 8 "x"}) ["x" #{6 7 8}])
      (should= (score-game {0 "e" 1 "e" 2 "e" 3 "e" 4 "e" 5 "e" 6 "o" 7 "o" 8 "o"}) ["o" #{6 7 8}]))

;; vertical winners

   (it "returns winner when player plays 0 3 6"
       (should= (score-game {0 "x" 1 "e" 2 "e" 3 "x" 4 "e" 5 "e" 6 "x" 7 "e" 8 "e"}) ["x" #{0 3 6}])
       (should= (score-game {0 "o" 1 "e" 2 "e" 3 "o" 4 "e" 5 "e" 6 "o" 7 "e" 8 "e"}) ["o" #{0 3 6}]))

   (it "returns winner when player plays 1 4 7"
       (should= (score-game {0 "e" 1 "x" 2 "e" 3 "e" 4 "x" 5 "e" 6 "e" 7 "x" 8 "e"}) ["x" #{1 4 7}])
       (should= (score-game {0 "e" 1 "o" 2 "e" 3 "e" 4 "o" 5 "e" 6 "e" 7 "o" 8 "e"}) ["o" #{1 4 7}]))

   (it "returns winner when player plays 2 5 8"
       (should= (score-game {0 "e" 1 "e" 2 "x" 3 "e" 4 "e" 5 "x" 6 "e" 7 "e" 8 "x"}) ["x" #{2 5 8}])
       (should= (score-game {0 "e" 1 "e" 2 "o" 3 "e" 4 "e" 5 "o" 6 "e" 7 "e" 8 "o"}) ["o" #{2 5 8}]))

;; diagonal winners

   (it "returns winner when player plays 2 4 6"
       (should= (score-game {0 "e" 1 "e" 2 "x" 3 "e" 4 "x" 5 "e" 6 "x" 7 "e" 8 "e"}) ["x" #{2 4 6}])
       (should= (score-game {0 "e" 1 "e" 2 "o" 3 "e" 4 "o" 5 "e" 6 "o" 7 "e" 8 "e"}) ["o" #{2 4 6}]))

   (it "returns winner when player plays 0 4 8"
       (should= (score-game {0 "x" 1 "e" 2 "e" 3 "e" 4 "x" 5 "e" 6 "e" 7 "e" 8 "x"}) ["x" #{0 4 8}])
       (should= (score-game {0 "o" 1 "e" 2 "x" 3 "e" 4 "o" 5 "e" 6 "x" 7 "x" 8 "o"}) ["o" #{0 4 8}]))

;; draws

   (it "returns draw when there are no empty tiles and no winners"
       (should= (score-game {0 "x" 1 "x" 2 "o" 3 "o" 4 "o" 5 "x" 6 "x" 7 "o" 8 "o"}) ["draw" #{}]))

;; incomplete game

   (it "returns incomplete game when there are more empty tiles"
       (should= (score-game {0 "e" 1 "e" 2 "e" 3 "e" 4 "e" 5 "e" 6 "e" 7 "e" 8 "e"}) ["incomplete" #{0 1 2 3 4 5 6 7 8}])
       (should= (score-game {0 "x" 1 "x" 2 "o" 3 "o" 4 "o" 5 "x" 6 "x" 7 "o" 8 "e"}) ["incomplete" #{8}])
       (should= (score-game {0 "e" 1 "x" 2 "o" 3 "e" 4 "o" 5 "x" 6 "x" 7 "o" 8 "e"}) ["incomplete" #{0 3 8}]))
)
