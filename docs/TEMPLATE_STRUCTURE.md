# Struktur Template Thymeleaf - Perkamen

## 📁 Struktur Folder

```
templates/
├── index.html                  # Halaman utama yang menggunakan semua fragments dan sections
├── fragments/                  # Komponen yang dapat digunakan ulang
│   ├── head.html              # Meta tags, CSS links, dan title dinamis
│   ├── navbar.html            # Navigation bar dengan menu responsif
│   ├── footer.html            # Footer dengan social links dan copyright
│   └── scripts.html           # JavaScript files dan custom scripts
├── layouts/                    # Template layout dasar
│   └── main-layout.html       # Layout utama dengan head, navbar, content, footer
└── sections/                   # Section-section konten halaman
    ├── hero.html              # Hero section dengan animasi
    ├── features.html          # Features section (9 fitur)
    ├── workflow.html          # Workflow section (alur surat masuk & keluar)
    ├── technology.html        # Technology stack section
    ├── pricing.html           # Pricing section (3 paket)
    └── cta.html               # Call-to-action section dengan kontak
```

## 🎯 Keuntungan Struktur Modular

### 1. **Maintainability** (Mudah Dipelihara)

- Setiap komponen terpisah dalam file sendiri
- Perubahan pada satu section tidak mempengaruhi yang lain
- Mudah menemukan dan memperbaiki bug

### 2. **Reusability** (Dapat Digunakan Ulang)

- Fragment seperti navbar, footer, head dapat digunakan di halaman lain
- Tidak perlu copy-paste kode yang sama berulang kali
- Konsistensi tampilan di seluruh aplikasi

### 3. **Scalability** (Mudah Dikembangkan)

- Mudah menambahkan section baru
- Mudah membuat halaman baru dengan menggunakan layout yang sama
- Tim dapat bekerja pada file yang berbeda tanpa konflik

### 4. **Clean Code** (Kode Bersih)

- File lebih kecil dan fokus
- Lebih mudah dibaca dan dipahami
- Mengikuti prinsip Single Responsibility Principle (SRP)

## 📝 Cara Penggunaan

### Menggunakan Fragment di Halaman Lain

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="id">
  <!-- Include head fragment -->
  <head th:replace="fragments/head :: head"></head>

  <body>
    <!-- Include navbar fragment -->
    <div th:replace="fragments/navbar :: navbar"></div>

    <!-- Your content here -->
    <main>
      <h1>Halaman Baru</h1>
    </main>

    <!-- Include footer fragment -->
    <div th:replace="fragments/footer :: footer"></div>

    <!-- Include scripts fragment -->
    <div th:replace="fragments/scripts :: scripts"></div>
  </body>
</html>
```

### Menggunakan Layout Utama

```html
<!DOCTYPE html>
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
  layout:decorate="~{layouts/main-layout}"
  lang="id"
>
  <head>
    <title>Halaman Baru - Perkamen</title>
  </head>

  <body>
    <main layout:fragment="content">
      <!-- Content khusus halaman ini -->
      <h1>Halaman Baru</h1>
    </main>
  </body>
</html>
```

### Menggunakan Section Tertentu

```html
<!-- Hanya menggunakan hero section -->
<div th:replace="sections/hero :: hero"></div>

<!-- Hanya menggunakan features section -->
<div th:replace="sections/features :: features"></div>
```

## 🔧 Customization

### Menambahkan Parameter Dinamis ke Fragment

**Di Controller:**

```java
@GetMapping("/")
public String index(Model model) {
    model.addAttribute("pageTitle", "Beranda");
    return "index";
}
```

**Di Template:**

```html
<!-- head.html sudah support dynamic title -->
<title
  th:text="${pageTitle != null ? pageTitle + ' - Perkamen' : 'Perkamen - Sistem Informasi Surat Menyurat Digital'}"
>
  Perkamen
</title>
```

### Membuat Section Baru

1. Buat file baru di folder `sections/`, misalnya `sections/testimonials.html`
2. Definisikan fragment dengan `th:fragment="testimonials"`
3. Include di `index.html` dengan `<div th:replace="sections/testimonials :: testimonials"></div>`

**Contoh:**

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="id">
  <body>
    <section
      th:fragment="testimonials"
      id="testimonials"
      class="testimonials-section py-5"
    >
      <div class="container">
        <!-- Testimonial content here -->
      </div>
    </section>
  </body>
</html>
```

## 🎨 Best Practices

### 1. Naming Convention

- **Fragments**: Gunakan nama yang jelas seperti `head`, `navbar`, `footer`
- **Sections**: Gunakan nama yang mendeskripsikan konten seperti `hero`, `features`, `pricing`
- **Layouts**: Gunakan nama yang mendeskripsikan tujuan seperti `main-layout`, `admin-layout`

### 2. Fragment Definition

```html
<!-- ✅ Good: Clear fragment name -->
<nav th:fragment="navbar" class="navbar">...</nav>

<!-- ❌ Bad: Unclear fragment name -->
<nav th:fragment="nav1" class="navbar">...</nav>
```

### 3. Fragment Inclusion

```html
<!-- ✅ Good: Using th:replace for complete replacement -->
<div th:replace="fragments/navbar :: navbar"></div>

<!-- ⚠️ Alternative: Using th:insert (keeps wrapper div) -->
<div th:insert="fragments/navbar :: navbar"></div>

<!-- ❌ Bad: Using th:include (deprecated) -->
<div th:include="fragments/navbar :: navbar"></div>
```

### 4. Conditional Fragments

```html
<!-- Show different navbar based on user role -->
<div
  th:replace="${user.isAdmin()} ? ~{fragments/admin-navbar :: navbar} : ~{fragments/navbar :: navbar}"
></div>
```

## 📚 Referensi Thymeleaf

- **th:replace** - Mengganti elemen host dengan fragment
- **th:insert** - Menyisipkan fragment ke dalam elemen host
- **th:fragment** - Mendefinisikan fragment yang dapat digunakan ulang
- **layout:fragment** - Mendefinisikan area konten dalam layout (Thymeleaf Layout Dialect)
- **layout:decorate** - Menggunakan layout sebagai template dasar

## 🚀 Migrasi dari Monolithic ke Modular

File `index.html` yang lama (796 baris) sekarang menjadi:

- **index.html**: 25 baris (hanya include fragments)
- **fragments/**: 4 file (head, navbar, footer, scripts)
- **sections/**: 6 file (hero, features, workflow, technology, pricing, cta)
- **layouts/**: 1 file (main-layout)

**Total**: 12 file modular vs 1 file monolithic

## ✅ Checklist Implementasi

- [x] Membuat folder `fragments/`
- [x] Membuat folder `sections/`
- [x] Membuat folder `layouts/`
- [x] Memisahkan head section ke `fragments/head.html`
- [x] Memisahkan navbar ke `fragments/navbar.html`
- [x] Memisahkan footer ke `fragments/footer.html`
- [x] Memisahkan scripts ke `fragments/scripts.html`
- [x] Memisahkan hero section ke `sections/hero.html`
- [x] Memisahkan features section ke `sections/features.html`
- [x] Memisahkan workflow section ke `sections/workflow.html`
- [x] Memisahkan technology section ke `sections/technology.html`
- [x] Memisahkan pricing section ke `sections/pricing.html`
- [x] Memisahkan cta section ke `sections/cta.html`
- [x] Membuat main layout di `layouts/main-layout.html`
- [x] Refactor `index.html` untuk menggunakan fragments dan sections

## 📞 Support

Jika ada pertanyaan atau masalah terkait struktur template ini, silakan hubungi tim development.

---

**Dibuat dengan ❤️ untuk Perkamen System**
