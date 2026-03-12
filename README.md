# Fuegocreativo GitHub Pages (Base bilingüe en ClojureScript)

Este repositorio ahora incluye una base mínima para un **segundo entorno de trabajo** con:

- Página inicial simple.
- Soporte de idioma **Español / English** con botón toggle.
- Persistencia del idioma elegido usando `localStorage`.
- Lógica fuente en **ClojureScript** (`src/fuegocreativo/core.cljs`).

## Flujo recomendado

1. `main` para producción (sitio público).
2. `development` para trabajo activo.
3. Ramas de feature para cambios puntuales y luego merge a `development`.
4. Cuando esté listo, merge de `development` a `main`.

## Estructura

- `src/fuegocreativo/core.cljs`: código fuente de i18n y toggle.
- `build.edn`: configuración de compilación para `cljs.main`.
- `script.js`: artefacto que carga el navegador en GitHub Pages.

## Correr localmente

```bash
python3 -m http.server 8000
```

Luego abre `http://localhost:8000`.

## Compilar ClojureScript a `script.js`

Si tienes Clojure CLI instalado:

```bash
clojure -M -m cljs.main -co build.edn -c fuegocreativo.core
```
