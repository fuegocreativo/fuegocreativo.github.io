(ns fuegocreativo.core)

(def translations
  {:es {:title "Fuego Creativo"
        :subtitle "Un espacio limpio para construir nuevas ideas."
        :visionTitle "Visión"
        :visionBody "Este entorno es una base enfocada y simple para experimentar, validar y publicar."
        :workflowTitle "Flujo recomendado"
        :workflow1 "main: versión pública estable."
        :workflow2 "development: entorno de trabajo activo."
        :workflow3 "Feature branches para cambios puntuales."
        :footer "Hecho para iterar rápido, sin ruido."}
   :en {:title "Fuego Creativo"
        :subtitle "A clean space to build new ideas."
        :visionTitle "Vision"
        :visionBody "This environment is a focused, simple base to experiment, validate, and publish."
        :workflowTitle "Recommended workflow"
        :workflow1 "main: stable public version."
        :workflow2 "development: active working environment."
        :workflow3 "Feature branches for focused changes."
        :footer "Built to iterate fast, without noise."}})

(defn text-for [lang key]
  (or (get-in translations [lang key])
      (get-in translations [:es key])
      ""))

(defn apply-language! [lang toggle]
  (let [dict-key (if (= lang :en) :en :es)]
    (doseq [el (.querySelectorAll js/document "[data-i18n]")]
      (let [k (keyword (.getAttribute el "data-i18n"))]
        (set! (.-textContent el) (text-for dict-key k))))
    (set! (.. js/document -documentElement -lang) (name dict-key))
    (set! (.-textContent toggle) (if (= dict-key :es) "EN" "ES"))
    (.setItem js/localStorage "preferredLanguage" (name dict-key))))

(defn init! []
  (when-let [toggle (.getElementById js/document "lang-toggle")]
    (let [stored (.getItem js/localStorage "preferredLanguage")
          initial (if (= stored "en") :en :es)]
      (apply-language! initial toggle)
      (.addEventListener toggle
                         "click"
                         (fn []
                           (let [current (.. js/document -documentElement -lang)
                                 next (if (= current "es") :en :es)]
                             (apply-language! next toggle)))))))

(init!)
