(ns tic-tac-toe.core)

(defn- keys-for-empty
  [board]
  (into [] (filter (comp #{"e"} board) (keys board))))

(defn score-game
  [board, player]
  (cond
    (= (board 0) (board 1) (board 2) player) {player [0 1 2]}
    (= (board 3) (board 4) (board 5) player) {player [3 4 5]}
    (= (board 6) (board 7) (board 8) player) {player [6 7 8]}

    (= (board 0) (board 3) (board 6) player) {player [0 3 6]}
    (= (board 1) (board 4) (board 7) player) {player [1 4 7]}
    (= (board 2) (board 5) (board 8) player) {player [2 5 8]}

    (= (board 2) (board 4) (board 6) player) {player [2 4 6]}
    (= (board 0) (board 4) (board 8) player) {player [0 4 8]}

    (contains? (set (vals board)) "e") {"incomplete" (keys-for-empty board)}

    :else {"draw" []})
  )
