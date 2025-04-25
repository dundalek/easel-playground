(ns playground.hello
  (:require
   [com.phronemophobic.schematic.model :as sm]
   [com.phronemophobic.easel :as easel]))

(def hello-data
  '{:element/type :com.phronemophobic.schematic.model/component,
    :component/name hello,
    :component/body
    #:element{:type :com.phronemophobic.schematic.model/paragraph,
              :text
              #:element{:type :com.phronemophobic.schematic.model/code,
                        :id #uuid "11457050-317f-43cd-b677-1ffe56435ff4",
                        :code (str "Hello, " name "!")},
              :width
              #:element{:type :com.phronemophobic.schematic.model/code,
                        :id #uuid "f73a8cac-53a2-49d5-8d3e-621ba72ac2d0",
                        :code nil},
              :paragraph-style
              #:element{:type :com.phronemophobic.schematic.model/code,
                        :id #uuid "1bd9d5d2-5bd6-4a0e-824b-2104fcaaab63",
                        :code
                        #:paragraph-style{:text-style
                                          #:text-style{:font-size 14,
                                                       :height
                                                       1.5714285714285714,
                                                       :height-override
                                                       true,
                                                       :color
                                                       [0.0
                                                        0.0
                                                        0.0
                                                        0.88]}}},
              :id #uuid "858b2120-048d-45b3-a3eb-7e58dab0108d"},
    :element/id #uuid "9f41e539-6539-4637-add3-c92364e56c49",
    :component/defaults {:name "John"}})

(comment
  (eval (sm/compile hello-data))

  (easel/add-component-as-applet #'hello {:name "Jane"})

  (tap> {:name "John"}))
