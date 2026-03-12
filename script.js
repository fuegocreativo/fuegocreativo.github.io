/*
 * Generated artifact for GitHub Pages runtime.
 * Source of truth: src/fuegocreativo/core.cljs
 */
(() => {
  const translations = {
    es: {
      title: "Fuego Creativo",
      subtitle: "Un espacio limpio para construir nuevas ideas.",
      visionTitle: "Visión",
      visionBody:
        "Este entorno es una base enfocada y simple para experimentar, validar y publicar.",
      workflowTitle: "Flujo recomendado",
      workflow1: "main: versión pública estable.",
      workflow2: "development: entorno de trabajo activo.",
      workflow3: "Feature branches para cambios puntuales.",
      footer: "Hecho para iterar rápido, sin ruido."
    },
    en: {
      title: "Fuego Creativo",
      subtitle: "A clean space to build new ideas.",
      visionTitle: "Vision",
      visionBody:
        "This environment is a focused, simple base to experiment, validate, and publish.",
      workflowTitle: "Recommended workflow",
      workflow1: "main: stable public version.",
      workflow2: "development: active working environment.",
      workflow3: "Feature branches for focused changes.",
      footer: "Built to iterate fast, without noise."
    }
  };

  const root = document.documentElement;
  const toggle = document.getElementById("lang-toggle");

  const textFor = (lang, key) => translations[lang]?.[key] ?? translations.es[key] ?? "";

  const applyLanguage = (lang) => {
    const dictionary = lang === "en" ? "en" : "es";
    document.querySelectorAll("[data-i18n]").forEach((element) => {
      const key = element.getAttribute("data-i18n");
      element.textContent = textFor(dictionary, key);
    });

    root.lang = dictionary;
    toggle.textContent = dictionary === "es" ? "EN" : "ES";
    localStorage.setItem("preferredLanguage", dictionary);
  };

  if (!toggle) return;

  const stored = localStorage.getItem("preferredLanguage");
  applyLanguage(stored === "en" ? "en" : "es");

  toggle.addEventListener("click", () => {
    applyLanguage(root.lang === "es" ? "en" : "es");
  });
})();
