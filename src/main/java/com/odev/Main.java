public class Main {
    public static void main(String[] args) {
        // Nesne örneği oluşturuluyor (Object Lifecycle - Creation)
        ResumeGenerator myResume = new ResumeGenerator(
                "Emre SAR",
                "Yazilim Mühendisligi Ögrencisi",
                "emre.sar@gmail.com",
                "+90 555 123 45 67"
        );

        // PDF oluşturma metodu çağrılıyor. (Proje ana dizininde profil.jpg olmalı)
        String pdfPath = "Emre_Sar_Ozgecmis.pdf";
        String imagePath = "pp.jpeg"; // Fotoğrafını proje klasörüne bu isimle at.

        myResume.createResume(pdfPath, imagePath);
    }
}