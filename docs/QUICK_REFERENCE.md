# Quick Reference - Thymeleaf Fragments

## 🚀 Penggunaan Cepat

### Include Fragment

```html
<!-- Navbar -->
<div th:replace="fragments/navbar :: navbar"></div>

<!-- Footer -->
<div th:replace="fragments/footer :: footer"></div>

<!-- Hero Section -->
<div th:replace="sections/hero :: hero"></div>
```

### Halaman Lengkap Template

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="id">
  <head th:replace="fragments/head :: head"></head>
  <body>
    <div th:replace="fragments/navbar :: navbar"></div>

    <!-- Your content here -->
    <main>
      <h1>Content</h1>
    </main>

    <div th:replace="fragments/footer :: footer"></div>
    <div th:replace="fragments/scripts :: scripts"></div>
  </body>
</html>
```

## 📁 Daftar Fragment yang Tersedia

### Fragments (Komponen Reusable)

| File                     | Fragment Name | Deskripsi                  |
| ------------------------ | ------------- | -------------------------- |
| `fragments/head.html`    | `head`        | Meta tags, CSS, title      |
| `fragments/navbar.html`  | `navbar`      | Navigation bar             |
| `fragments/footer.html`  | `footer`      | Footer dengan social links |
| `fragments/scripts.html` | `scripts`     | JavaScript files           |

### Sections (Konten Halaman)

| File                       | Fragment Name | Deskripsi                   |
| -------------------------- | ------------- | --------------------------- |
| `sections/hero.html`       | `hero`        | Hero section dengan animasi |
| `sections/features.html`   | `features`    | 9 fitur unggulan            |
| `sections/workflow.html`   | `workflow`    | Alur surat masuk & keluar   |
| `sections/technology.html` | `technology`  | Tech stack                  |
| `sections/pricing.html`    | `pricing`     | 3 paket harga               |
| `sections/cta.html`        | `cta`         | Call-to-action              |

### Layouts

| File                       | Fragment Name | Deskripsi    |
| -------------------------- | ------------- | ------------ |
| `layouts/main-layout.html` | `content`     | Layout utama |

## 🎯 Contoh Penggunaan

### Landing Page (index.html)

```html
<div th:replace="fragments/head :: head"></div>
<div th:replace="fragments/navbar :: navbar"></div>
<div th:replace="sections/hero :: hero"></div>
<div th:replace="sections/features :: features"></div>
<div th:replace="sections/workflow :: workflow"></div>
<div th:replace="sections/technology :: technology"></div>
<div th:replace="sections/pricing :: pricing"></div>
<div th:replace="sections/cta :: cta"></div>
<div th:replace="fragments/footer :: footer"></div>
<div th:replace="fragments/scripts :: scripts"></div>
```

### Simple Page

```html
<div th:replace="fragments/head :: head"></div>
<div th:replace="fragments/navbar :: navbar"></div>
<main>
  <!-- Your content -->
</main>
<div th:replace="fragments/footer :: footer"></div>
<div th:replace="fragments/scripts :: scripts"></div>
```

### Page with Hero Only

```html
<div th:replace="fragments/head :: head"></div>
<div th:replace="fragments/navbar :: navbar"></div>
<div th:replace="sections/hero :: hero"></div>
<main>
  <!-- Your content -->
</main>
<div th:replace="fragments/footer :: footer"></div>
<div th:replace="fragments/scripts :: scripts"></div>
```

## 🔧 Customization

### Dynamic Title

```java
// Controller
model.addAttribute("pageTitle", "Halaman Baru");
```

```html
<!-- Template akan otomatis menggunakan title dinamis -->
<head th:replace="fragments/head :: head"></head>
```

### Conditional Fragment

```html
<!-- Show navbar only if user is logged in -->
<div th:if="${user != null}" th:replace="fragments/navbar :: navbar"></div>
```

## 📝 Cheat Sheet

### th:replace vs th:insert

```html
<!-- th:replace - Mengganti elemen host -->
<div th:replace="fragments/navbar :: navbar"></div>
<!-- Result: <nav class="navbar">...</nav> -->

<!-- th:insert - Menyisipkan ke dalam elemen host -->
<div th:insert="fragments/navbar :: navbar"></div>
<!-- Result: <div><nav class="navbar">...</nav></div> -->
```

### Fragment with Parameters

```html
<!-- Define fragment with parameters -->
<div th:fragment="alert(type, message)">
  <div th:class="'alert alert-' + ${type}">
    <span th:text="${message}"></span>
  </div>
</div>

<!-- Use fragment with parameters -->
<div
  th:replace="fragments/alert :: alert('success', 'Data berhasil disimpan')"
></div>
```

## 🎨 Struktur Folder

```
templates/
├── index.html              # Halaman utama
├── fragments/              # Komponen reusable
│   ├── head.html
│   ├── navbar.html
│   ├── footer.html
│   └── scripts.html
├── sections/               # Section konten
│   ├── hero.html
│   ├── features.html
│   ├── workflow.html
│   ├── technology.html
│   ├── pricing.html
│   └── cta.html
└── layouts/                # Layout template
    └── main-layout.html
```

## ✅ Checklist Membuat Halaman Baru

- [ ] Buat file HTML baru di `templates/`
- [ ] Include `fragments/head :: head`
- [ ] Include `fragments/navbar :: navbar`
- [ ] Tambahkan konten utama
- [ ] Include `fragments/footer :: footer`
- [ ] Include `fragments/scripts :: scripts`
- [ ] Test di browser

## 🚨 Common Mistakes

### ❌ Wrong

```html
<!-- Missing namespace -->
<html lang="id">
  <!-- Wrong fragment path -->
  <div th:replace="head :: head"></div>

  <!-- Using deprecated th:include -->
  <div th:include="fragments/navbar :: navbar"></div>
</html>
```

### ✅ Correct

```html
<!-- With namespace -->
<html xmlns:th="http://www.thymeleaf.org" lang="id">
  <!-- Correct fragment path -->
  <div th:replace="fragments/head :: head"></div>

  <!-- Using th:replace -->
  <div th:replace="fragments/navbar :: navbar"></div>
</html>
```

---

**Quick Reference untuk Perkamen System**
