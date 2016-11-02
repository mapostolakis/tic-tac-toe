(ns tic-tac-toe.core)

(def players #{"x" "o"})
(def open "e")
(def incomplete "incomplete")
(def draw "draw")
(def winners [[0 1 2] [3 4 5] [6 7 8]
              [0 3 6] [1 4 7] [2 5 8]
              [2 4 6] [0 4 8]])

(defn- select-values
  [map keys]
  (->> [map keys]
       (apply select-keys)
       (vals)))

(defn- keys-for-open
  [board]
  (set (for [key (keys board)
             :when (= (board key) open)]
         key)))

(defn- contains-open?
  [board]
  (contains? (set (vals board)) open))

(defn- hit-winner-combo?
  [board player combo]
  (every? #(= player %) (select-values board combo)))

(defn- winner-result
  [board]
  (flatten (for [combo winners
                 player players
                 :when (hit-winner-combo? board player combo)]
             [player (set combo)])))

(defn- won-game?
  [board]
  (not-empty (winner-result board)))

(defn score-game
  [board]
  (cond
    (won-game? board) (winner-result board)
    (contains-open? board) [incomplete (keys-for-open board)]
    :else [draw #{}]))
