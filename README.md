# 🚀 Altokeyaa - Actividad Firebase/Firestore

Proyecto Android desarrollado con **Jetpack Compose** y **Firebase Firestore**, permitiendo guardar, listar y eliminar notas en tiempo real mediante una interfaz moderna y dinámica.

---

# 📋 Objetivo

Este proyecto demuestra la integración completa de **Firebase Firestore** en una aplicación Android moderna utilizando **Jetpack Compose**.

## ✅ Funcionalidades principales

- Guardar notas en Firestore
- Listar notas en tiempo real
- Eliminar notas
- Interfaz moderna con Material Design 3
- Actualización automática de datos

---

# 🛠️ Tecnologías utilizadas

- 📱 Android Studio
- ⚡ Kotlin
- 🎨 Jetpack Compose
- 🔥 Firebase Firestore
- 🧩 Google Services
- 🪄 Material Design 3
- 🔄 Kotlin Coroutines

---

# 📦 Dependencias principales

## Firebase

```kotlin
implementation(platform("com.google.firebase:firebase-bom:34.12.0"))
implementation("com.google.firebase:firebase-firestore-ktx")
```

## Plugin Gradle

```kotlin
id("com.google.gms.google-services")
```

---

# 🚀 Instalación y configuración

## 1️⃣ Clonar repositorio

```bash
git clone <tu-repositorio>
cd t1
```

---

## 2️⃣ Configurar Firebase

### Descargar archivo de configuración

Desde Firebase Console descarga:

```txt
google-services.json
```

### Colocarlo en:

```txt
app/google-services.json
```

---

## 3️⃣ Compilar proyecto

```bash
./gradlew build
```

Luego ejecutar desde:

- Android Studio
- Emulador Android
- Dispositivo físico

---

# 💾 Estructura del proyecto

```txt
app/
├── src/main/java/com/example/altokeyaa/
│   ├── MainActivity.kt
│   ├── ui/
│   │   ├── home/
│   │   ├── firestore/
│   │   │   └── FirestoreDemoScreen.kt
│   │   ├── login/
│   │   ├── orders/
│   │   ├── promo/
│   │   └── theme/
│   └── ...
├── google-services.json
└── build.gradle.kts
```

---

# 🔥 Funcionalidades Firestore

## 📌 Pantalla FirestoreDemoScreen

La pantalla permite realizar operaciones CRUD básicas utilizando Firestore.

### Operaciones implementadas

## ✅ CREATE

Guardar una nueva nota en la colección:

```txt
notas
```

---

## ✅ READ

Listar todas las notas en tiempo real ordenadas por fecha.

---

## ✅ DELETE

Eliminar notas mediante su ID único.

---

# 🗂️ Ejemplo de datos almacenados

```json
{
  "notas": [
    {
      "id": "auto-generado",
      "texto": "Mi primera nota",
      "timestamp": 1704067200000
    }
  ]
}
```

---

# 📸 Evidencia de funcionamiento

## ✍️ Guardar nota

1. Escribir texto
2. Presionar botón **Guardar**
3. Mostrar mensaje:

```txt
✅ Nota guardada
```

4. Verificar en Firebase Console

---

## 📄 Listar notas

- Carga automática al abrir pantalla
- Orden descendente por timestamp
- Actualización en tiempo real

---

## 🗑️ Eliminar nota

1. Presionar ícono papelera
2. Eliminar registro
3. Mostrar mensaje:

```txt
🗑️ Nota eliminada
```

---

# 🔐 Reglas Firestore (Modo prueba)

```js
rules_version = '2';

service cloud.firestore {
  match /databases/{database}/documents {

    match /{document=**} {
      allow read, write: if true;
    }

  }
}
```

---

# ⚠️ Importante

Estas reglas son solo para desarrollo y pruebas.

Para producción se recomienda:

- Autenticación Firebase
- Reglas restrictivas
- Validación de usuarios

---

# ✅ Checklist de entrega

- [x] Firebase Firestore conectado
- [x] Archivo google-services.json agregado
- [x] Dependencias Firebase configuradas
- [x] CRUD funcional
- [x] Interfaz Material Design 3
- [x] Actualización en tiempo real
- [x] Proyecto compila correctamente
- [x] README documentado

---

# 📝 Notas adicionales

- Proyecto compilado correctamente
- BUILD SUCCESSFUL
- Integración Firebase funcionando
- Compatible con Android moderno
- Arquitectura basada en Compose

---

# 👨‍💻 Autor

Desarrollado para la actividad académica de Firebase/Firestore utilizando Android Studio y Jetpack Compose.

---

# 📄 Licencia

Proyecto educativo de libre uso con fines de aprendizaje.
