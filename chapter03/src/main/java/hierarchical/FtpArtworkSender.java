package hierarchical;

public class FtpArtworkSender implements ArtworkSender {

    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        // FTP Logic
    }

    @Override
    public String getFriendlyName() {
        return "파일 전송 프로토콜";
    }

    @Override
    public String getShortName() {
        return "FTP";
    }
}
