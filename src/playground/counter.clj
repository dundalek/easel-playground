(ns playground.counter
  (:require
   [membrane.ui :as ui]
   [membrane.component :as component :refer [defui defeffect]]
   [com.phronemophobic.easel :as easel]
   [com.phronemophobic.schematic.model :as sm]
   [com.phronemophobic.schematic.view.component-picker :as component-picker]))

(defui counter [{:keys [num]}]
  (ui/horizontal-layout
   (ui/on :mouse-down (fn [_]
                        [[::counter-increment $num]])
          (ui/button "more!"))
   (ui/label num)))

(defeffect ::counter-increment [$num]
  (dispatch! :update $num inc))

(comment
  (easel/add-component-as-applet #'counter {:num 1})

  (easel/add-component!
   ::counter
   (fn [] {:element/type ::sm/defui
           :element/name "counter"
           :element/function #'counter
           :element/data {:num (component-picker/->code 5)}
           :element/id (random-uuid)}))

  (tap> {:num 2}))
