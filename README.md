# Java PDF Resume Generator

Bu proje, Java programlama dili ve nesne yönelimli programlama (OOP) prensipleri kullanılarak dinamik bir şekilde PDF formatında özgeçmiş (CV) üreten bir konsol uygulamasıdır. Uygulama, iText kütüphanesini kullanarak kişisel bilgileri, profil fotoğrafını ve iş deneyimlerini belirli bir düzende PDF dosyasına yazar.

## 🚀 Kullanılan Teknolojiler ve Bileşenler

- **Java (JDK 11+)**: Temel programlama dili.
- **iText PDF (5.5.13.3)**: PDF dokümanları oluşturmak, metin biçimlendirmeleri yapmak ve görsel (resim) eklemek amacıyla tercih edilmiştir. Harici kütüphane yönetimi için Maven kullanılmıştır.

## 🏗️ Mimari ve OOP Yaklaşımı

Proje direkt olarak `Main` metodu içerisine yığılmak yerine, modülerlik ve okunabilirlik açısından sınıflara bölünmüştür:

1. **`Main.java`**: Uygulamanın giriş noktasıdır. Sadece `ResumeGenerator` nesnesini örnekler (instantiation) ve gerekli parametreleri vererek süreci başlatır.
2. **`ResumeGenerator.java`**: PDF oluşturma iş mantığının (business logic) tamamını barındırır.
   - **Kapsülleme (Encapsulation)**: Sınıf içerisindeki `fullName`, `title`, `email` gibi değişkenler `private` erişim belirleyicisi ile korunmuş, sadece kurucu metot (constructor) üzerinden değer atanmasına izin verilmiştir.
   - **Modülerlik**: İş deneyimlerini ekleyen `addExperience` fonksiyonu, kod tekrarını önlemek amacıyla ayrı bir `private` yardımcı (helper) metot olarak tasarlanmıştır.

## ⚙️ Kurulum ve Çalıştırma

1. Repoyu bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/KULLANICI_ADIN/repo-adi.git](https://github.com/KULLANICI_ADIN/repo-adi.git)
