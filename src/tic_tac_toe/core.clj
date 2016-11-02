(ns tic-tac-toe.core)

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

(defn- winners-result
  [board player]
  (set (flatten (for [combo winners
                      :when (hit-winner-combo? board player combo)]
                  combo))))

(defn- final-result
  [board player]
  [player (winners-result board player)])

(defn- won-game?
  [board player]
  (not-empty (winners-result board player)))

(defn score-game
  [board, player]
  (cond
    (won-game? board player) (final-result board player)
    (contains-open? board) [incomplete (keys-for-open board)]
    :else [draw #{}]))
