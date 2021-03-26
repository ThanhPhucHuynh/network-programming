import java.io.Serializable;


public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String destinationDirectory;
    private String sourceDirectory;
    private String filename;
    private long fileSize;
    private int piecesOfFile;
    private int lastBytesLength;
    private String status;

    public FileInfo(){
        
    }
    public FileInfo(String destinationDirectory, String sourceDirectory, String filename, long fileSize, int piecesOfFile, int lastBytesLength, String status){
        this.destinationDirectory = destinationDirectory;
        this.sourceDirectory = sourceDirectory;
        this.filename = filename;
        this.fileSize = fileSize;
        this.piecesOfFile = piecesOfFile;
        this.lastBytesLength = lastBytesLength;
        this.status = status;
    }

    //setter and getter
    public void setDestinationDirectory(String destinationDirectory){
        this.destinationDirectory = destinationDirectory;
    }
    public void setSourceDirectory(String sourceDirectory){
        this.sourceDirectory = sourceDirectory;
    }
    public void setFileName(String fileName){
        this.filename = fileName;
    }
    public void setFileSize(long fileSize){
        this.fileSize = fileSize;
    }
    public void setPiecesOfFile(int piecesOfFile){
        this.piecesOfFile = piecesOfFile;
    }
    public void setLastBytesLength(int lastBytesLength){
        this.lastBytesLength = lastBytesLength;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getDestinationDirectory(){
        return this.destinationDirectory;
    }
    public String getSourceDirectory(){
        return this.sourceDirectory;
    }
    public String getFileName(){
        return this.filename;
    }
    public long getFileSize(){
        return this.fileSize;
    }
    public int getPiecesOfFile(){
        return this.piecesOfFile;
    }
    public int getLastBytesLength(){
        return this.lastBytesLength;
    }    
    public String getStatus(){
        return this.status;
    }
    
}