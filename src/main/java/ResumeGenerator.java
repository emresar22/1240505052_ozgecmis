import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class ResumeGenerator {

    private String fullName;
    private String title;
    private String email;
    private String phone;

    public ResumeGenerator(String fullName, String title, String email, String phone) {
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
    }

    public void createResume(String destPath, String imagePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(destPath));
            document.open();

            // Profil Fotoğrafı Ekleme
            try {
                Image profilePic = Image.getInstance(imagePath);
                profilePic.scaleAbsolute(100f, 100f);
                profilePic.setAlignment(Element.ALIGN_RIGHT);
                document.add(profilePic);
            } catch (Exception e) {
                System.out.println("Fotoğraf bulunamadı, fotoğrafsız devam ediliyor. Lütfen proje dizinine 'profil.jpg' ekleyin.");
            }

            // Kişisel Bilgiler
            Font nameFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.ITALIC);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);

            document.add(new Paragraph(fullName, nameFont));
            document.add(new Paragraph(title, titleFont));
            document.add(new Paragraph("E-posta: " + email, normalFont));
            document.add(new Paragraph("Telefon: " + phone, normalFont));
            document.add(new Paragraph("\n"));

            // İş Deneyimleri (3 Adet Hayali)
            document.add(new Paragraph("İs Deneyimleri", headerFont));
            document.add(new Paragraph("---------------------------------------------------"));

            document.add(addExperience("Kidemli Yazilim Muhendisi", "TechGlobal A.S.", "2024 - Gunumuz", "Mikroservis mimarileri tasarlandi ve Java Spring Boot ile backend servisleri gelistirildi."));
            document.add(addExperience("Yazilim Gelistirici", "Bilisim Çozumleri Ltd.", "2021 - 2024", "E-ticaret platformunun veritabani optimizasyonlari yapildi ve RESTful API'ler yazildi."));
            document.add(addExperience("Junior Java Gelistirici", "StartUp Teknoloji", "2019 - 2021", "Musteri yonetim sistemi icin CRUD islemleri ve arayuz entegrasyonlari tamamlandi."));

            document.close();
            System.out.println("Ozgecmis basarıyla olusturuldu: " + destPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Paragraph addExperience(String jobTitle, String company, String date, String description) {
        Paragraph p = new Paragraph();
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font italicFont = new Font(Font.FontFamily.HELVETICA, 11, Font.ITALIC);
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);

        p.add(new Chunk(jobTitle + " - " + company + "\n", boldFont));
        p.add(new Chunk(date + "\n", italicFont));
        p.add(new Chunk(description + "\n\n", normalFont));

        return p;
    }
}